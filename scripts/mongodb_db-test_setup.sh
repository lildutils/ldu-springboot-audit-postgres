#!/bin/sh

main() {
    docker run -d \
        --name mongo-database-server-test \
        -e MONGO_INITDB_ROOT_USERNAME=root \
        -e MONGO_INITDB_ROOT_PASSWORD=p4ssw0RD! \
        -e MONGO_INITDB_DATABASE=test_database \
        -p 127.0.0.1:27017:27017 \
        -p 127.0.0.1:8081:8081 \
        mongo:latest
}

main
