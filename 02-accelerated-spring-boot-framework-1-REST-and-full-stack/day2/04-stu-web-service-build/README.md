# Spring Boot and REST Web Service Build 

## Structure

Your solution must have the following structural elements:

- Your solution must be in an IntelliJ project called `WebServiceBuild`.
- Your project must be built using Spring Boot and Spring MVC. Initialize your project using `start.spring.io`.
- Your project must have a series of tests using MockMvc.
- Your project must store quote, word, and Magic 8-ball data in a list as shown in the Record Store service in this module.
- Your REST API must be documented with Swagger. Save the `.yaml` file in the root of your project directory.

## Requirements/Features

This web service is a quote-of-the-day, word-of-the-day, and magic 8-ball service. You must implement and document the following REST APIs:

- Quote API:
  - URI: /quote
  - Method: GET
  - Request Body: None
  - Response Body: Quote
- Quote Object instance variables:
  - id
  - author
  - quote
- Word API
  - URI: /word
  - Method: GET
  - Request Body: None
  - Response Body: Definition
- Definition Object instance variables:
  - id
  - word
  - definition
- Magic 8-ball API:
  - URI: /magic
  - Method: POST
  - Request Body: Answer 
    - (For the sake of the exercise, assume only the question field of the Answer object is present in the JSON request 
      body.)
  - Response Body: Answer
- Answer Object instance variables:
  - id
  - question
  - answer


### Additional Requirements

- Your service must contain at least 10 quotes. Quotes must be served up at random.
- Your service must contain at least 10 words and their corresponding definitions. Words and definitions must be served up at random.
- Your service must contain at least six different magic 8-ball responses. Answers from 8-ball must be served up at random.


---

© 2021 Trilogy Education Services, a 2U, Inc. brand. All Rights Reserved.
