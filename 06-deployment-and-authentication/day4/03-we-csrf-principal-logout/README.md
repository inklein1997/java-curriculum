# CSRF Principal Logout

## Introduction

In this activity, we'll configure CSRF protection and logout for our web service. We'll also use the Principal object to get information about the user.


## Instructions

1. In IntelliJ, open the `SecurityConfig` class, and update the `configure` method to include the last two blocks (`logout` and `csrf`):

   ```java
       public void configure(HttpSecurity httpSecurity) throws Exception {
   
           httpSecurity.httpBasic();
   
           httpSecurity.authorizeRequests()
               .mvcMatchers("/privateEvent").hasAuthority("REGISTERED_USER")
               .mvcMatchers("/registerPrivateEvent").hasAuthority("REGISTERED_USER")
               .anyRequest().permitAll();

           httpSecurity
               .logout()
               .clearAuthentication(true)
               .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
               .logoutSuccessUrl("/allDone")
               .deleteCookies("JSESSIONID")
               .deleteCookies("XSRF-TOKEN")
               .invalidateHttpSession(true);

           httpSecurity
               .csrf()
               .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
       }
   ```

    Notes about the previous code:

    We enable logout by calling the `logout()` method on the `HttpSecurity` parameter. We then specify the following:

    1. The URL that is to be called for logging out
    2. The URL that the application will redirect to when logout is complete
    3. The cookies to delete
    4. Tell the application to invalidate the HTTP session

    Spring has CSRF protection enabled by default, but the mechanism used for exchanging the CSRF token by default is the HTTP session, which doesn't work well for Postman and many frameworks, including Angular. These frameworks expect the CSRF token in a cookie, so we tell Spring Security to put the CSRF token in a cookie to accommodate these clients.

2. Open the `RsvpController` class, and update the code on the `privateEvent` and `registerPrivateEvent` endpoints so that they take the `Principal` as a parameter, and use it in the code. The code should resemble the following:

    ```java
    @RestController
    public class RsvpController {
        @RequestMapping(value="/publicEvent", method= RequestMethod.GET)
        public String viewPublicEvents() {
            return "Here are the public events.";
        }

        @RequestMapping(value="/registerPublicEvent", method= RequestMethod.GET)
        public String registerPublicEvent() {
            return "You are registering for a public event.";
        }

        @RequestMapping(value="/privateEvent", method= RequestMethod.GET)
        public String viewPrivateEvents(Principal principal) {
            return "Here are the private events, exclusively for you, " + principal.getName();
        }

        @RequestMapping(value="/registerPrivateEvent", method= RequestMethod.GET)
        public String registerPrivateEvent(Principal principal) {
            return "You are registering for a private event, " + principal.getName();
        }
    }
    ```

3. In the `RsvpController` class, update the code to handle logout. The code should resemble the following:

    ```java
    @RestController
    public class RsvpController {
        @RequestMapping(value="/publicEvent", method= RequestMethod.GET)
        public String viewPublicEvents() {
            return "Here are the public events.";
        }

        @RequestMapping(value="/registerPublicEvent", method= RequestMethod.GET)
        public String registerPublicEvent() {
            return "You are registering for a public event.";
        }

        @RequestMapping(value="/privateEvent", method= RequestMethod.GET)
        public String viewPrivateEvents(Principal principal) {
            return "Here are the private events, exclusively for you, " + principal.getName();
        }

        @RequestMapping(value="/registerPrivateEvent", method= RequestMethod.GET)
        public String registerPrivateEvent(Principal principal) {
            return "You are registering for a private event, " + principal.getName();
        }

        @RequestMapping(value="/allDone", method=RequestMethod.GET)
        public String calledByLogout() {
            return "You are logged out.";
        }
    }
    ```

4. Restart the app.

5. Open [http://localhost:8080/publicEvent](http://localhost:8080/publicEvent). Verify that credentials are not required.

6. Open [http://localhost:8080/privateEvent](http://localhost:8080/privateEvent). Log in using the credentials for one of the users. The output should display the name of the user in the message.


---

© 2022 Trilogy Education Services, a 2U, Inc. brand. All Rights Reserved.
