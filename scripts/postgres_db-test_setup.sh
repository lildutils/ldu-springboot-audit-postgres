#!/bin/sh

main() {
    docker run -d \
        --name postgres-database-server-test \
        -e POSTGRES_USER=root \
        -e POSTGRES_PASSWORD=p4ssw0RD! \
        -e POSTGRES_DB=test_database \
        -p 127.0.0.1:5432:5432 \
        postgres:latest
}

main
