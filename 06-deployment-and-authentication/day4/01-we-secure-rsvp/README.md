# Secure RSVP

## Introduction

In this activity, we will create a simple REST web service from scratch that uses Spring Security.


## Instructions

### Step 1: Create Project

1. Go to the Spring Initializr (http://start.spring.io).

2. Create a new project as follows:

   * Set ```Group``` to ```com.trilogyed```.

   * Set ```Artifact``` to ```secure-rsvp```.

   * Set ```Name``` to ```SecureRsvp```.

   * Set ```Package name``` to ```com.trilogyed.securersvp```.

   * Set ```Java``` to ```8```. 

3. Add the following dependencies:

   * ```Spring Web [WEB]```

   * ```Spring Data JPA [SQL]```

   * ```MySQL Driver [SQL]```

   * ```Spring Security [SECURITY]```

4. Click Generate to download the zipped project, unzip the project, and open it in IntelliJ.

5. Next, we'll create a database for our application. Open MySQL Workbench, and run the following to create a new schema:

    ```
    create schema if not exists secureapp;
    ```

6. In Intellij, update the `src/main/resources/application.properties` file to include the following connection information for the new schema:

    ```properties
    spring.datasource.url: jdbc:mysql://localhost:3306/secureapp?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
    spring.datasource.username: root
    spring.datasource.password: rootroot
    spring.datasource.driver-class-name: com.mysql.cj.jdbc.Driver
    ```

7. Create a new class called `com.trilogyed.securersvp.controller.RsvpController`, and add the following code to this class:

    ```java
    @RestController
    public class RsvpController {
        @RequestMapping(value="/publicEvent", method= RequestMethod.GET)
        public String viewPublicEvents() {
            return "Here are the public events.";
        }
        
        @RequestMapping(value="/privateEvent", method= RequestMethod.GET)
        public String viewPrivateEvents() {
            return "Here are the private events.";
        }
    }
    ```

8. Start the app by running the main method in the `SecureRsvpApplication` class.

9. In a browser, go to [http://localhost:8080/publicEvent](http://localhost:8080/publicEvent).

    We are prompted for a username and password. By adding the Spring Security dependency, Spring automatically attempts to apply security.
    
    To verify that our endpoints are working correctly, we'll disable the security, for now, and then turn it back on later.

10. In IntelliJ, open the main class `SecureRsvpApplication`, and disable security by updating the `SpringBootApplication` annotation as follows:

    ```java
    @SpringBootApplication(exclude = { SecurityAutoConfiguration.class})
    ```

11. Restart the app.

12. In a browser, go to [http://localhost:8080/publicEvent](http://localhost:8080/publicEvent). The output should resemble the following:

    ```
    Here are the public events.
    ```

13. Go to [http://localhost:8080/privateEvent](http://localhost:8080/privateEvent). The output should resemble the following:

    ```
    Here are the private events.
    ```

### Step 2: Create a Password Encoder Utility

Before we can add users to our database, we'll need a way to encode user passwords. We don't want to store plaintext passwords in the database. We'll create a utility to generate encoded passwords.

1. In IntelliJ, create a class called `com.trilogyed.securersvp.util.PasswordUtility`, and use the following code:

   ```java
   public class PasswordUtility {
   
       public static void main(String[] args) {
           PasswordEncoder enc = new BCryptPasswordEncoder();
   
           String password = "password";
   
           String encodedPassword = enc.encode(password);
   
           System.out.println(encodedPassword);
       }
   }
   ```

2. Now run the utility to generate an encoded password. It will print in the console.

   - This is a very simple utility. To generate a hashed version of a password, simply change the value of the password variable to whatever you want to generate a hash for.

   - Note that if you run the application several times, it generates different outputs. This is due to the secure nature of BCrypt.

     - See https://stackabuse.com/password-encoding-with-spring-security/ for more information on why this works.

### Step 3: Spring Security Schema and Enable Security

Now we have an encoded password. We need somewhere to put it. For Spring Security to work properly, we need a way to store and retrieve hashed passwords for users, as well as authorities (what a user is allowed to do) associated with users. This can be modeled simply with two database tables.

1. Open MySQL Workbench, and run the following:

   ```sql
   use secureapp;
   
   create table if not exists users(
       username varchar(50) not null primary key,
       password varchar(100) not null,
       enabled boolean not null
   );
   
   create table if not exists authorities (
       username varchar(50) not null,
       authority varchar(50) not null,
       constraint fk_authorities_users foreign key(username) references users(username));
       create unique index ix_auth_username on authorities (username,authority
   );
   ```

2. Add a record to the user table with any username and the output of the password generator utility.

   ```sql
   insert into users (username, password, enabled) values ('alex','$2a$10$ZFJLAIAt3xKVs9B.Iepgy.Dwxcj9RKW3oKJWKR4JhX5DmhQRBvVma',true);
   ```

    Now, we have to give this user permission to do something. We can do that by adding a record to the Authorities table. What authority should we give this user? We can name the authority anything we want. The key is that the name of the authority is consistent with the name of the authority we use in our application (Java) code.

3. Add a record to the Authorities table.

   ```sql
   insert into authorities (username, authority) values ('alex', 'REGISTERED_USER');
   ```

    Finally, it's time to add security to our app. Before we reenable security, we have to write some code that configures how the security will work for the app.

4. In IntelliJ, create a new class called `com.trilogyed.securersvp.SecurityConfig`, and add the following code to the class:

   ```java
   @Configuration
   public class SecurityConfig extends WebSecurityConfigurerAdapter {
   
       @Autowired
       DataSource dataSource;
   
       @Autowired
       public void configAuthentication(AuthenticationManagerBuilder authBuilder) throws Exception {
   
           PasswordEncoder encoder = new BCryptPasswordEncoder();
   
           authBuilder.jdbcAuthentication()
               .dataSource(dataSource)
               .usersByUsernameQuery(
                       "select username, password, enabled from users where username = ?")
               .authoritiesByUsernameQuery(
                       "select username, authority from authorities where username = ?")
               .passwordEncoder(encoder);
       }
   
       public void configure(HttpSecurity httpSecurity) throws Exception {
   
           httpSecurity.httpBasic();
   
           httpSecurity.authorizeRequests()
               .mvcMatchers("/privateEvent").hasAuthority("REGISTERED_USER")
               .anyRequest().permitAll();
       }
   }
   ```

    **Notes** about the code:

    - We add the `@Configuration` annotation to this class because this class has configuration code that needs to run when the application starts.
    - To configure security, we have to extend the `WebSecurityConfigurerAdapter` class.
    - We autowire our datasource that contains our security config.
    - The `configAuthentication` method allows us to set our query for users that allows us to check a password, as well as our query for authorities.
    - **Note** that we can use any query here.
        - The only rules are that the first three columns of `usersByUsernameQuery` must represent username, password, and whether the user is enabled, and the first two columns of the `authoritiesByUsernameQuery` must be a username and an authority.
        - That being said, the actual table and column names don't matter.
    - Because we are using BCrypt, we pass an instance of the `BCryptPasswordEncoder`.
    - We will not need to further modify the `configAuthentication` method.
    - The configure method is where we set up our rules. We will eventually chain together a bunch of `mvcMatchers` method calls to configure authorization rules for our app.

5. Finally, we have to reenable security by removing the exclusion from our main application class.

    In `SecureRsvpApplication.java`, **remove** the exclude parameter on the `@SpringBootApplication` annotation so the class now looks like this:

    ```java
    @SpringBootApplication
    public class SecureRsvpApplication {

        public static void main(String[] args) {
            SpringApplication.run(SecureRsvpApplication.class, args);
        }

    }
    ```

6. Restart the app.

7. Open a new **incognito** (or private) browser window, and navigate to [http://localhost:8080/publicEvent](http://localhost:8080/publicEvent). Verify that credentials are not required.

    >It's important (for this step and the next one) to browse in incognito mode; otherwise, the browser tries to help us out by storing some header information that doesn't allow us to cleanly exercise our application.

8. Open a new **incognito** (or private) browser window, and navigate to [http://localhost:8080/privateEvent](http://localhost:8080/privateEvent). Verify that credentials are required.


---

© 2022 Trilogy Education Services, a 2U, Inc. brand. All Rights Reserved.
