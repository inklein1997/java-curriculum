# Newsfeed DB

## Introduction

In this activity, we will containerize the database for the Newsfeed application.

## Overview

To containerize the newsfeed_db database, we'll follow these steps:

1. Create a Dockerfile.
2. Build a Docker image.
3. Create a container from the image.

## Instructions

### Create a Dockerfile

Open the `db` folder, and examine its contents. Notice a `data` folder that's currently empty. When we run the database in a container later, we'll specify this `data` folder as a custom storage folder. The `backup.sql` file contains the backup data of our database. The `schema.sql` file was previously used to create our database.

> **Remind students:** A Dockerfile is a text document that contains all the commands needed to assemble a Docker image.

In the `db` folder, create a file named `Dockerfile`. The case of the file name is important, and there is no file extension.

Open the Dockerfile, and enter the following text in the file and save the file:

```dockerfile
FROM mysql:8
ENV MYSQL_DATABASE=newsfeed_db
COPY ./backup.sql /docker-entrypoint-initdb.d/
```

A Dockerfile must begin with a `FROM` instruction. It specifies the parent image from which we're building. In this case, the `FROM mysql:8` instruction pulls down the `mysql` version 8 image.

> **Remind students:** In an earlier lesson, we ran containers with `nginx` and `mysql`. In those cases, our `docker container run` command pulled down the latest version of the `nginx` and `mysql` images from Docker Hub.

The `ENV` instruction specifies our environment variables. In this case, we use the `MYSQL_DATABASE` variable to hold the database name.

> **Remind students:** In an earlier lesson, we ran the `mysql` container. In that case, we had to use the `--env` flag and the mandatory `MYSQL_ROOT_PASSWORD` variable in our Docker command to provide the MySQL root password. Likewise, instead of entering the MySQL root password in the Dockerfile, we'll provide it later when we run the `docker container run` command.

Finally the `COPY` instruction copies new files or folders from the source and adds them to the file system of the container. In this case, we'll copy the `backup.sql` data into the database that will run in the container, which exists at `/docker-entrypoint-initdb.d/`.

In the next step, we'll use this Dockerfile to create an image.


### Build a Docker Image

To build a Docker image from a Dockerfile, we use the `docker image build` command. The command syntax is `docker image build [OPTIONS] PATH`. You need to be in the folder that contains the Dockerfile to run the `docker image build` command.

First, make sure that your Docker daemon is running and that your local MySQL server is stopped. The reason is that this container will use the same port.

Next, at your command line, navigate to the `db` folder that contains the Dockerfile. Then run the following Docker command:

```bash
docker image build -t newsfeed-db .
```

> **Important:** Remember the period (.) at the end of the command. A space and then a period follow `newsfeed-db`.

Let's go over the preceding command. The `-t` (or `--tag`) option names the image and optionally tags it. In this case, we name the image `newsfeed-db`. If we wanted to tag it as version 1, we'd use `-t newsfeed-db:v1`.

The period (.) specifies the `PATH`. This means that the Docker daemon will build the image from the files and folders that exist in the current working directory.

> **Deep Dive:** For more information about how to build a Docker image, refer to [docker build](https://docs.docker.com/engine/reference/commandline/build/) in the Docker documentation.

Next, we'll check whether the Docker image was successfully created.

> **Pause:**
>
> **Question:** What's the Docker command to display all the Docker images?
>
> **Answer:** The Docker command to display all the Docker images is `docker images`.

Run the command to display all the Docker images. The resulting list should include the `newsfeed-db` image and resemble the following:

```bash
// docker images
REPOSITORY    TAG       IMAGE ID       CREATED          SIZE
newsfeed-db   latest    df798f71b747   52 seconds ago   556MB
```

Now we can use the Docker image to create a container.


### Create a Container from the Docker Image

Now that we're familiar with how to create containers, we need to add a new option to the `docker container run` command: the `--volume` option.

The `--volume` syntax includes three fields but requires only two. The first field is the path to the file or folder on the host machine. Remember that this needs to be the absolute path. The second field is the path to where the file or folder is mounted in the container. A colon (:) separates these two fields. The third, optional field is a comma-separated list of configuration options.

In our case, we'll use only the first two fields. Let's discuss the second field first. We want our local `data` folder to be mounted in the `/var/lib/mysql` custom storage folder in the container. So, we'll use that for the second field. For the first field, we need to find the absolute path of our `data` folder. Copy and paste the absolute path into the option so that it resembles the following:

```bash
--volume=/Users/username/newsfeed/db/data:/var/lib/mysql
```

Now add the new option to the `docker container run` command so that it appears as follows:

```bash
docker container run -d -p 3306:3306 \
--env MYSQL_ROOT_PASSWORD=<your password> \
--volume=<your path to the data directory>:/var/lib/mysql \
--name=newsfeed-db newsfeed-db
```

> **Pro Tip:** For readability, we use the backslashes (\\) to break apart long commands.

Let's now go over the preceding command. We're creating a container to run in detached mode. We set the port to 3306 and provide the MySQL password. We mount our `data` folder in the `/var/lib/mysql` folder in the container. We name our container `newsfeed-db`. Finally, we use the `newsfeed-db` image for this container.


## Exercising the System

Next, we'll check whether the container was created and whether it's now running correctly.

> **Pause:**
>
> **Question:** What's the Docker command to display all the running Docker containers?
>
> **Answer:** The Docker command to display all the running Docker containers is `docker ps` or `docker container ls`.

Run the Docker command to display all the running Docker containers. In the response, you should observe the `newsfeed-db` container running. This response should resemble the following:

```bash
CONTAINER ID   IMAGE         COMMAND                  CREATED       STATUS       PORTS                                                  NAMES
642e9730f82b   newsfeed-db   "docker-entrypoint.s…"   2 hours ago   Up 2 hours   0.0.0.0:3306->3306/tcp, :::3306->3306/tcp, 33060/tcp   newsfeed-db
```

As mentioned in an earlier lesson, the best way to check whether our database is running correctly in the container is to enter the container and then run a few queries in the MySQL Shell, so let’s do that now.

First, enter the `newsfeed-db` container by running the following command:

```bash
docker container exec -it newsfeed-db bash
```

> **Remind students:** The `docker container exec` command runs a command in a running container. We use the `-it` option to run in interactive mode. We specify the container that we want to run the command. In the preceding command, this is our `newsfeed-db` container. Finally, the command that we want to run in the container is `bash`.

Once you're in the container, initialize the MySQL Shell, and then enter your MySQL password as follows:

```bash
mysql -u root -p
```

Next, run the `show databases;` command. The response should list `newsfeed_db` as a database, as follows:

```bash
mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| newsfeed_db        |
| performance_schema |
| sys                |
+--------------------+
5 rows in set (0.01 sec)
```

Next, switch to the `newsfeed_db` database. Then run the `SELECT * FROM user;` query. A list of the users in our database should appear, as follows:

```bash
mysql> SELECT * FROM user;
+----+---------------+---------------------------+--------------------------------------------------------------+
| id | username      | email                     | password                                                     |
+----+---------------+---------------------------+--------------------------------------------------------------+
|  1 | msprague5     | larnout5@imdb.com         | $2b$10$w1ouuW6RqXP8p4B0YGNYsOuZj0g1JdNltxCqCGluzZ0WKXb2qjXxe |
|  2 | djiri4        | gmidgley4@weather.com     | $2b$10$b5WyFpiYxTYy/SfUtB81rOhu0PJ/iK72g7taYDEF/oYChWD/MSnai |
|  3 | iboddam2      | cstoneman2@last.fm        | $2b$10$NPtOvwvJn0u2Gp085rx7PeJTdnXlmkgttA2gUTdJm79CJnXY7yKYO |
|  4 | dstanmer3     | ihellier3@goo.ne.jp       | $2b$10$zHg5QU31/0tTPuxts8.0G.nu1ANnxBmU7td398Jqw4dxMHjPokdDe |
|  5 | mpergens6     | hnapleton6@feedburner.com | $2b$10$SfM7cMiAUxPKPesnHCuvJOknBOPGus7/E1N2VuVES.NOyq5LO0XUm |
|  6 | tpenniell7    | kperigo7@china.com.cn     | $2b$10$JdO4dHlue5aV2xnjmHApsOzoSTlA2XyIaZbOpiZQt/1X0IvR7kTYW |
|  7 | msabbins8     | lmongain8@google.ru       | $2b$10$2z1OFlITXYmgewz56fj6ReMH5AIcgDlVjpz5FAK4o6wtUHr7eDwji |
|  8 | jmacarthur9   | bsteen9@epa.gov           | $2b$10$3xg49SCM3qHNgpf0AnB10eYpO4ga9ZEtnMeDDDCEwTOLylNrD1Xyi |
|  9 | alesmonde0    | nwestnedge0@cbc.ca        | $2b$10$tHU8FVgwIf3Nm8opiw2sDObc65qHPeWqNvAKCjQuT.VfMbGpF75Fq |
| 10 | jwilloughway1 | rmebes1@sogou.com         | $2b$10$bh85ivGtaD5RzEweoQHPjugcgAs7gfzI5kd5fKt3tHu8M4.ex4OJy |
+----+---------------+---------------------------+--------------------------------------------------------------+
10 rows in set (0.00 sec)
```

This confirms that our database is running correctly in a container with all the data inside.

Now, quit the MySQL Shell and exit the container.

---

© 2022 Trilogy Education Services, a 2U, Inc. brand. All Rights Reserved.
