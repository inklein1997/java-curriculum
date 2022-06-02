# Pulls from DockerHub MySQL image that has tag 8 on it
FROM mysql:8

# Environment Variable
ENV MYSQL_DATABASE=newsfeed_db

# Runs backup.sql after build and copies
COPY ./backup.sql /docker-entrypoint-initdb.d/