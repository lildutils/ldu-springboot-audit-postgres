#!/bin/sh

main() {
    docker container kill mongo-database-server-test
    docker container rm mongo-database-server-test
}

main
