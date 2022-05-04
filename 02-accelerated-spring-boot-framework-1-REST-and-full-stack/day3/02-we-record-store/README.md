# Record Store Validation and Error Handling

### Introduction

In this activity, you will practice your new knowledge of error handling. You will use the code from the Record Store API project in Lessons 1.4.5 and 1.4.6 (see the following starter code).

### Instructions

1. Start by refactoring your tests and code to adjust for the new "year" property added to the Record DTO.
2. Add tests to check for the following expected failures:
   - An invalid Request Body should return a 422 Unprocessable Entity status code.
   - In the /records/{id} PUT request, if the ID in the parameter does not match the ID in the request body, the request should return a 422 Unprocessable Entity status code.
   - **Note:** We can check for expected failures in the same way as testing void methods—by just asserting an expected status code.
3. Add an error handler class with methods to handle the following Exceptions:
   - MethodArgumentNotValidException, which returns 422 Unprocessable Entity status code.
   - IllegalArgumentsException, which returns 422 Unprocessable Entity status code.
4. Implement the necessary changes to your Record Store Controller class to pass the tests you've just written.

### Challenge

1. Add tests to check for a 404 Not Found status code when a GET request made to /records/{id} does not find a matching Record.
2. Add an additional Exception handler method to return a 404 Not Found.
3. Implement the code to pass the new test.

**HINT:** You may find it easiest to complete the challenge by creating a new Exception that extends RuntimeException.


---

© 2022 Trilogy Education Services, a 2U, Inc. brand. All Rights Reserved.
