# Hello Circle 3

## Introduction

In this activity, we will commit code changes to trigger a simple CI/CD pipeline using CircleCI.


## Instructions

1. Log in to [CircleCI](https://circleci.com/) and navigate to the `CiCdDemo` pipeline.
   - Keep this browser window open as we make changes so we can view the pipeline run.

2. Open the `hello-circle` project in IntelliJ, edit the `com.trilogyed.hellocircle.controller.HelloCircleControllerTest` class, and add the following test:

    ```java
    @Test
    public void shouldReturnAnswer() throws Exception {
        // arrange and act
        mockMvc.perform(get("/answer"))
                .andDo(print())
                .andExpect(status().isOk())

                // assert
                .andExpect(content().string("The answer is 42!"));
    }
    ```

3. Save your changes and commit them to the local CiCdDemo repo.

4. Push your changes to the remote CiCdDemo repo.

5. In the browser window for the `CiCdDemo` pipeline, the pipeline will run and fail because the test fails.

6. In IntelliJ, edit the `com.trilogyed.hellocircle.controller.HelloCircleController` class, and add the following endpoint:

    ```java
    @GetMapping(value = "/answer")
    public String getAnswer(){
        return "The answer is 42!";
    }
    ```

7. Save your changes and commit them to the local CiCdDemo repo.

8. Push your changes to the remote CiCdDemo repo.

9. In the browser window for the `CiCdDemo` pipeline, the pipeline will run and complete successfully because all of the tests now pass.

---

© 2022 Trilogy Education Services, a 2U, Inc. brand. All Rights Reserved.
