# RSVP

## Introduction

In this activity, we will containerize the RSVP service.


## Instructions

1. Update the `application.properties` file to change the connection string to resemble the following:

    ```
    spring.datasource.url: jdbc:mysql://mysql-db:3306/rsvp?useSSL=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true
    ```

    >Notice that we are using the container name of `mysql-db` instead of `localhost` for the connection string.

2. Create a Dockerfile in the `app` folder that does the following:
    - Uses the `openjdk:8-jdk-alpine` image
    - Copies the `.jar` file for the service

3. From the command line, build a Docker image with the tag of `rsvp-service` using the Dockerfile you created in the previous step.

4. From the command line, display all Docker images, and verify that the `rsvp-service` image was created.

5. From the command line, create and run a container from the Docker image using the following command:

    ```bash
    docker run -d -p 8080:8080 --network=rsvpnetwork --name rsvp-service rsvp-service
    ```

6. To check whether our application is running correctly from the container, browse to [http://localhost:8080/rsvps](http://localhost:8080/rsvps). The output should resemble the following:

    ```
    [{"id":29,"guestName":"John","totalAttending":2},{"id":30,"guestName":"Paul","totalAttending":2},{"id":31,"guestName":"George","totalAttending":1},{"id":32,"guestName":"Ringo","totalAttending":1}]
    ```

---

© 2022 Trilogy Education Services, a 2U, Inc. brand. All Rights Reserved.
