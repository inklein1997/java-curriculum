# Compose Newsfeed

## Introduction

In this activity, we will containerize both the Newsfeed application and database using Docker Compose.

## Instructions

1. Make sure to stop both newsfeed containers, if they are still running. From the command line, enter the following commands:

    ```bash
    docker container stop newsfeed-db
    docker container stop newsfeed-app
    ```

2. Next, in IntelliJ, open the Newsfeed application. In the `app` folder, create a new file, and name it `docker-compose.yml`.

3. Open `docker-compose.yml`. At the beginning of the file, specify the version of the Compose file format. Use version 3, as follows:

    ```yaml
    version: '3'
    ```

4. Update the `.env` file with the correct values for the `newsfeed` database.

5. Next, we'll add the service definitions. A **service definition** specifies a service and then lists the configuration items that are applied to each container started for that service.

    We'll start with the database. The reason is that we need the database to be created and started before the application. So, in the Compose file, starting on a new line after the Compose file format version, add the following service definition:

    ```yaml
    services:
      db:
        image: newsfeed-db
        environment:
          MYSQL_ROOT_PASSWORD: ${DB_PASSWORD}
          MYSQL_DATABASE: ${DB_NAME}
        restart: always
        ports:
          - '3306:3306'
        volumes:
          - <Absolute path to data directory>:/var/lib/mysql
    ```

    We'll now go over this service definition line by line. Take note of how much it resembles the set of command-line options that we use with the `docker run` command.

    > **Note:** As with the SAM template in an earlier module, we need to pay attention to the indentation. Because it's a YAML file, the Compose file is white-space dependent.

    The service definition specifies that we're calling the `db` database container and then lists all its configuration items. First, we list the Docker image on which we base this container. That's the `newsfeed-db` image that we already created.

    Next come the environment variables. We have only two variables: `MYSQL_ROOT_PASSWORD` and `MYSQL_DATABASE`. Instead of hardcoding the password and the database name in the Compose file, we take advantage of the `.env` file, which already has that information. Furthermore, hardcoding any credentials in Dockerfiles or Compose files would pose a security risk. We use string interpolation to assign the `DB_PASSWORD` and `DB_NAME` values from our `.env` file to the environment variables in the Compose file.

    Next, we set the restart policy to `always`. This means that the container will continue trying to restart after being stopped for any reason.

    We then map the ports to 3306.

    Finally, we need to bind-mount a volume. Notice that we use the same syntax that we used for the `--volume` option in the `docker container run` command earlier in the module. Replace `<Absolute path to data directory>` with the absolute path to your `data` directory.

6. Now we can define the application service. To do that, add the following service definition after the `db` service definition:

    ```yaml
      app:
        image: newsfeed-app
        restart: always
        ports:
          - '3001:3001'
        environment:
          DB_PASSWORD: ${DB_PASSWORD}
          DB_DATABASE: ${DB_NAME}
          DB_USER: ${DB_USER}
          DB_HOST: db
        depends_on:
          - db
    ```

    Make sure that `app` is indented and aligned with `db` under `services`.

    We'll now go over this service definition line by line.

    We're calling the `app` application container and then listing all its configuration items. First, we specify the Docker image, which is `newsfeed-app`.

    We set the restart policy to `always` and map the ports to 3001.

    Next come the environment variables. Recall that we have four environment variables for our application to correctly connect to the database. They're the same variables that we used earlier with the `docker container run` command. The only difference is that `DB_HOST` now references the `db` container that we just defined. Because the `.env` file already has these variables, we use string interpolation to assign them to these environment variables.

    Finally, `depends_on` expresses the dependency between services. Our app depends on the database being up and running. This is similar to the way that we used the `--link` option at the command line earlier.

7. Point out that the Compose file resembles the `docker container run` set of command-line options that we used to build the containers. Here's the complete `docker-compose.yml` file:

    ```yaml
    version: '3'
    services:
      db:
        image: newsfeed-db
        environment:
          MYSQL_ROOT_PASSWORD: ${DB_PASSWORD}
          MYSQL_DATABASE: ${DB_NAME}
        restart: always
        ports:
          - '3306:3306'
        volumes:
          - <Absolute path to data directory>:/var/lib/mysql
      app:
        image: newsfeed-app
        restart: always
        ports:
          - '3001:3001'
        environment:
          DB_PASSWORD: ${DB_PASSWORD}
          DB_DATABASE: ${DB_NAME}
          DB_USER: ${DB_USER}
          DB_HOST: db
        depends_on:
          - db
    ```

    > **Deep Dive:** For more information about Docker Compose, refer to the [Compose file version 3 reference](https://docs.docker.com/compose/compose-file/compose-file-v3/) in the Docker documentation.

8. Now we can create and run both containers in one step! To do that, at your command line, run the following command:

    ```bash
    docker compose up -d
    ```

    > **Pro Tip:** With the `-d` option, the new Docker containers will start and run in the background.

    The preceding command creates both containers and gives them generic names, like `app_db_1` and `app_app_1`. In your console, you can observe that the application is up and running. Let's test the routes again using Postman.

    > **Note:** Docker will create both the app and db containers at the same time. The app container will try to connect to the db container. Until the db container has finished initializing you may see errors from the app container. This is expected. The app will continue trying to connect until the db container is available.

9. Open Postman, and then make a `GET` request to any of the API endpoints, like `localhost:3001/api/comments`. The comments should then be displayed, as the following image shows:

    ![A screenshot depicts Postman with a list of comments in JSON format.](./images/300-GET-all-comments.png)

    The Newsfeed application and the database are now both running in containers, and we needed only one command to make that happen!

10. Press CTRL+C to stop the containers.

---

© 2022 Trilogy Education Services, a 2U, Inc. brand. All Rights Reserved.
