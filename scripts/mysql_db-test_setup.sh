#!/bin/sh

main() {
    docker run -d \
        --name mysql-database-server-test \
        -e MYSQL_ROOT_USER=root \
        -e MYSQL_ROOT_PASSWORD=p4ssw0RD! \
        -e MYSQL_DATABASE=test_database \
        -p 127.0.0.1:3306:3306 \
        -p 127.0.0.1:33060:33060 \
        mysql:latest
}

main
