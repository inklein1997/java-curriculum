# Hello Heroku

## Introduction

In this activity, we'll create a a simple REST service and deploy it to Heroku.

## Instructions

1. Go to the Spring Initializr (http://start.spring.io).

2. Create a new project:

   * Set ```Group``` to ```com.trilogyed``` 
   
   * Set ```Artifact``` to ```hello-heroku``` 
   
   * Set ```Name``` to ```HelloHeroku```. 

   * Set ```Package name``` to ```com.trilogyed.hello.heroku```. 

   * Set ```Java``` to ```8```. 

3. Add the ```Spring Web``` starter dependency.

4. Unzip the project template into a directory that is not in a Git repository.

5. Create a new Java class called `com.trilogyed.hello.heroku.controller.HelloHerokuController`.

   - Add code to the controller so it resembles the following:

      ```java
        package com.trilogyed.hello.heroku.controller;

        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RestController;

        @RestController
        public class HelloHerokuController {

            @GetMapping(value = "/hello")
            public String helloHeroku(){
                return "Hello, Heroku!";
            }
        }
      ```

6. Navigate to the starter project directory, and run the following commands to create a local Git repository:

    ```
    git init
    git add .
    git commit -m "initial commit"
    ```

7. From the command line, run the following command to log in to Heroku:

    ```
    heroku login
    ```

8. From the command line, run the following command to create a Heroku app:

    ```
    heroku create
    ```

    The output should resemble the following:
    ```
    Creating app... done, ⬢ serene-taiga-24346
    https://serene-taiga-24346.herokuapp.com/ | https://git.heroku.com/serene-taiga-24346.git
    ```

9. From the command line, run the following command to deploy the Heroku app:

    ```
    git push heroku main
    ```

10. From the command line, run the following command to open the Heroku app in your browser:

    ```
    heroku open
    ```

11. Browse to the `/hello` route; the output should resemble the following:
    ```
    Hello, Heroku!
    ```

---

© 2022 Trilogy Education Services, a 2U, Inc. brand. All Rights Reserved.
