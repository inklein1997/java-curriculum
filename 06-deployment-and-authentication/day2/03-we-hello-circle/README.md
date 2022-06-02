# Hello Circle

## Introduction

In this activity, we will start creating a simple CI/CD pipeline using CircleCI.


## Instructions

### Step 1. Create a GitHub Repository

1. Log in to [GitHub](https://github.com/), and create a new public repository named `CiCdDemo`.

2. Clone the new repository locally.

### Step 2. Create a Project

1. Go to the Spring Initializr (http://start.spring.io).

2. Create a new project as follows:

   * Set ```Group``` to ```com.trilogyed```.

   * Set ```Artifact``` to ```hello-circle```.

   * Set ```Name``` to ```HelloCircle```.

   * Set ```Package name``` to ```com.trilogyed.hellocircle```.

   * Set ```Java``` to ```8```. 

3. Add the following dependency:

   * ```Spring Web [WEB]```

4. Click Generate to download the zipped project.

5. Unzip the project, and add the files to the local CiCdDemo repository.

6. Open the `pom.xml` file and add the following dependency:

    ```xml
    <dependency>
        <groupId>org.junit.vintage</groupId>
        <artifactId>junit-vintage-engine</artifactId>
        <scope>test</scope>
    </dependency>
    ```

7. Open the `hello-circle` project in IntelliJ, create a new class called `com.trilogyed.hellocircle.controller.HelloCircleController` and add the following code to this class:

    ```java
    @RestController
    public class HelloCircleController {

    @GetMapping(value = "/hello")
        public String helloCircle(){
            return "Hello, Circle!";
        }
    }
    ```

8. Save your changes, and commit them to the local CiCdDemo repository.

9. Push your changes to the remote CiCdDemo repository.

### Step 3. Config.yml

Now we have a simple REST web service, and we've added the code to a repository.

>Remember, the goal with CI is that we want our code to build and run our tests every time we commit changes.

Setting up CircleCI comprises the following two parts:
- Tell CircleCI about our repository.
- Tell CircleCI what to do when it detects a change.

In this activity, we'll focus on telling CircleCI what to do when it detects a change.

1. Add a new folder called `.circleci` to the root of your local repository.

2. Add new file called `config.yml` to the `.circleci` folder.

**Note:** The indentation in a `.yml` file is very important. It needs to be consistent throughout the file in order to work correctly.

3. First, we identify which version of CircleCI we are using. Add the following text to the `config.yml`:
   ```
    # Use the latest 2.1 version of CircleCI pipeline process engine.
    # See: https://circleci.com/docs/2.0/configuration-reference
    version: 2.1
   ```

4. Next, we define a job called `build-and-test`. Add the following text to the `config.yml`:
   ```
    # Define a job to be invoked later in a workflow.
    # See: https://circleci.com/docs/2.0/configuration-reference/#jobs
    jobs:
    # Below is the definition of your job to build and test your app. You can rename and customize it as you want.
    build-and-test:
   ```

5. The first thing we'll do in the `build-and-test` job is set the working directory. Add the following text to the `config.yml`:
   ```
        working_directory: ~/CiCdDemo/hello-circle
   ```

6. The next thing we'll do is tell CircleCI to start with a Java image. Add the following text to the `config.yml`:
   ```
        # These next lines define a Docker executor: https://circleci.com/docs/2.0/executor-types/
        # You can specify an image from Docker Hub or use one of our Convenience Images from CircleCI's Developer Hub.
        # Be sure to update the Docker image tag below to the openjdk version of your application.
        # A list of available CircleCI Docker Convenience Images are available here: https://circleci.com/developer/images/image/cimg/openjdk
        docker:
        - image: cimg/openjdk:8.0
   ```

7. Now we'll define the steps in the `build-and-test` job. Add the following text to the `config.yml`:
   ```
        # Add steps to the job
        # See: https://circleci.com/docs/2.0/configuration-reference/#steps
        steps:
        # Check out the code as the first step.
        - checkout:
            path: ~/CiCdDemo
        # Use mvn clean and package as the standard maven build phase
        - run:
            name: Build
            command: mvn -B -DskipTests clean package
        # Then run your tests!
        - run:
            name: Test
            command: mvn test
   ```

8. Finally, we'll define a workflow called `sample` to run the `build-and-test` job. Add the following text to the `config.yml`:
   ```
    # Invoke jobs via workflows
    # See: https://circleci.com/docs/2.0/configuration-reference/#workflows
    workflows:
    sample: # This is the name of the workflow. Feel free to change it to better match your workflow.
        # Inside the workflow, you define the jobs you want to run.
        jobs:
        - build-and-test
   ```

9. Save your changes, and commit them to the local CiCdDemo repository.

10. Push your changes to the remote CiCdDemo repository.

**Note:** There is a completed `config.yml` file in the `starter` folder that you can use.

The completed `config.yml` file should resemble the following:

   ```
    # Use the latest 2.1 version of CircleCI pipeline process engine.
    # See: https://circleci.com/docs/2.0/configuration-reference
    version: 2.1

    # Define a job to be invoked later in a workflow.
    # See: https://circleci.com/docs/2.0/configuration-reference/#jobs
    jobs:
    # Below is the definition of your job to build and test your app. You can rename and customize it as you want.
    build-and-test:
        working_directory: ~/CiCdDemo/hello-circle

        # These next lines define a Docker executor: https://circleci.com/docs/2.0/executor-types/
        # You can specify an image from Docker Hub or use one of our Convenience Images from CircleCI's Developer Hub.
        # Be sure to update the Docker image tag below to the openjdk version of your application.
        # A list of available CircleCI Docker Convenience Images are available here: https://circleci.com/developer/images/image/cimg/openjdk
        docker:
        - image: cimg/openjdk:8.0
        # Add steps to the job
        # See: https://circleci.com/docs/2.0/configuration-reference/#steps
        steps:
        # Check out the code as the first step.
        - checkout:
            path: ~/CiCdDemo
        # Use mvn clean and package as the standard maven build phase
        - run:
            name: Build
            command: mvn -B -DskipTests clean package
        # Then run your tests!
        - run:
            name: Test
            command: mvn test

    # Invoke jobs via workflows
    # See: https://circleci.com/docs/2.0/configuration-reference/#workflows
    workflows:
    sample: # This is the name of the workflow. Feel free to change it to better match your workflow.
        # Inside the workflow, you define the jobs you want to run.
        jobs:
        - build-and-test
   ```

---

© 2022 Trilogy Education Services, a 2U, Inc. brand. All Rights Reserved.
