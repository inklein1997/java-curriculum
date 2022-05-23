# Quote Service v2

## Introduction

In this activity, we will:

- Create a Eureka service registry from scratch.

- Create and register a MagicEightBall Service with the service registry.

- Modify the existing Quote Service to use the service registry to locate and call the MagicEightBall Service.

## Requirements

### Service Registry

1. Create a new Eureka service registry project called `firstname-lastname-service-registry` using the Spring Initializr following the steps outlined in the lesson.

2. Use the following configuration settings for the service registry:

   - Run on port 8761.

   - Set the hostname to `localhost`.

   - All other settings should match those in your cheatsheet for this lesson.

### Cloud Config Server

- Use the cloud configuration server created in the first version of this project to serve up config files to both the Quote service and the MagicEightBall service.

### MagicEightBall Service

1. Create a new Spring Boot web service project called `firstname-lastname-magic-eight-ball-service` using the Spring Intitializr. This web service must include support for the service to register with the Eureka service registry.

2. The service must register with the Eureka service registry.

3. The service must run on port 3344.

4. The service must have the following endpoint:

```java
URI: /answer
HTTP Method: GET
Request Body: None
Response Body: Answer (String)
```

4. The endpoint should randomly return one of the following answers:

   - No

   - Yes

   - Looking cloudy

   - Not sure

   - Absolutely!

   - Ask again

   - Ummm

   - Not a chance

### Quote Service Modifications

1. Add the following endpoint to version 1 of the Random Quote Service:

   ```java
   URI: /answerme
   HTTP Method: GET
   Request Body: None
   Response Body: Answer (String)
   ```

2. This endpoint must do the following:

   - Call the MagicEightBall Service `/answer` endpoint and return the result to the caller.

---

© 2022 Trilogy Education Services, a 2U, Inc. brand. All Rights Reserved.
