# Compose RSVP

## Introduction

In this activity, you will containerize both the RSVP service and database using Docker Compose.

## Instructions

1. Make sure to stop both newsfeed containers, if they are still running. From the command line, enter the following commands:

    ```bash
    docker container stop rsvp-service
    docker container stop rsvp-db
    ```

2. Next, in IntelliJ, open the RSVP service application. In the `app` folder, create a new file, and name it `docker-compose.yml`.

3. Open `docker-compose.yml`. At the beginning of the file, specify the version of the Compose file format. Use version 3, as follows:

    ```yaml
    version: '3'
    ```

4. Update the `.env` file with the correct values for the `rsvp` database.

5. Next, you'll add the service definition for the database. The service definition should resemble the following:

    ```yaml
    services:
        db:
            image: rsvp-db
            environment:
            MYSQL_ROOT_PASSWORD: ${DB_PASSWORD}
            MYSQL_DATABASE: ${DB_NAME}
            restart: always
            ports:
            - '3306:3306'
            volumes:
            - <Absolute path to data directory>:/var/lib/mysql
            networks:
            - rsvpnetwork
    ```

6. Now we can define the application service. To do that, add the following service definition after the `db` service definition:

    ```yaml
        app:
            image: rsvp-service
            restart: always
            ports:
            - '8080:8080'
            environment:
            SPRING_DATASOURCE_URL: jdbc:mysql://db:3306/rsvp?useSSL=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true
            depends_on:
            - db
            networks:
            - rsvpnetwork
    ```

7. Next, we can define the network the containers will use to communicate. To do that, add the following definition after the service definitions:

    ```yaml
    networks:
    rsvpnetwork:
        driver: bridge
    ```

8. Point out that the Compose file resembles the `docker container run` set of command-line options that we used to build the containers. Here's the complete `docker-compose.yml` file:

    ```yaml
    version: '3'

    services:
    db:
        image: rsvp-db
        environment:
        MYSQL_ROOT_PASSWORD: ${DB_PASSWORD}
        MYSQL_DATABASE: ${DB_NAME}
        restart: always
        ports:
        - '3306:3306'
        volumes:
        - <Absolute path to data directory>:/var/lib/mysql
        networks:
        - rsvpnetwork

    app:
        image: rsvp-service
        restart: always
        ports:
        - '8080:8080'
        environment:
        SPRING_DATASOURCE_URL: jdbc:mysql://db:3306/rsvp?useSSL=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true
        depends_on:
        - db
        networks:
        - rsvpnetwork

    networks:
    rsvpnetwork:
        driver: bridge
    ```


9. Now we can create and run the containers all in one step! To do that, at your command line, run the following command:

    ```bash
    docker compose up -d
    ```

10. To check whether our application is running correctly from the container, browse to [http://localhost:8080/rsvps](http://localhost:8080/rsvps). The output should resemble the following:

    ```
    [{"id":29,"guestName":"John","totalAttending":2},{"id":30,"guestName":"Paul","totalAttending":2},{"id":31,"guestName":"George","totalAttending":1},{"id":32,"guestName":"Ringo","totalAttending":1}]
    ```

11. Press CTRL+C to stop the containers.

---

© 2022 Trilogy Education Services, a 2U, Inc. brand. All Rights Reserved.
