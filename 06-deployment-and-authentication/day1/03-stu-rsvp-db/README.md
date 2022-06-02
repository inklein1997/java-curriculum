# RSVP DB

## Introduction

In this activity, you will containerize the database for the RSVP service.

## Instructions

1. Create a Dockerfile in the `db` folder that does the following:
    - Uses the `mysql` image
    - Sets the `MYSQL_DATABASE` environment variable to `rsvp`
    - Copies the `backup.sql` script


2. From the command line, build a Docker image with the tag of `rsvp-db` using the Dockerfile you created in the previous step.

3. From the command line, display all Docker images, and verify that the `rsvp-db` image was created.

4. Create a Docker network to make it easier for containers to communicate, as shown here:

```bash
docker network create rsvpnetwork
```

5. Update the following command with the correct information, and then run it to create a container from the Docker image:

```bash
docker container run -d -p 3306:3306 \
--env MYSQL_ROOT_PASSWORD=<your password> \
--volume=<your path to the data directory>:/var/lib/mysql \
--network=rsvpnetwork --name=mysql-db rsvp-db
```

6. From the command line, run the Docker command to display all the running containers, and verify that `rsvp-db` is running.

7. From the command line, enter the `mysql-db` container by running the following command:

```bash
docker container exec -it mysql-db bash
```

8. Once you're in the container, initialize the MySQL Shell, and then enter your MySQL password as follows:

```bash
mysql -u root -p
```

9. From the MySQL Shell, run the `show databases;` command. The response should list `rsvp` as a database, as follows:

```bash
mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| rsvp               |
| performance_schema |
| sys                |
+--------------------+
5 rows in set (0.01 sec)
```

10. Next, switch to the `rsvp` database. Then run the `SELECT * FROM rsvp;` query. A list of the users in our database should appear, as follows:

```bash
mysql> SELECT * FROM rsvp;
+---------+------------+-----------------+
| rsvp_id | guest_name | total_attending |
+---------+------------+-----------------+
|       1 | John       |               2 |
|       2 | Paul       |               2 |
|       3 | George     |               1 |
|       4 | Ringo      |               1 |
+---------+------------+-----------------+
4 rows in set (0.00 sec)
```

This confirms that our database is running correctly in a container with all the data inside.

11. Now quit the MySQL Shell, and exit the container.

---

© 2022 Trilogy Education Services, a 2U, Inc. brand. All Rights Reserved.
