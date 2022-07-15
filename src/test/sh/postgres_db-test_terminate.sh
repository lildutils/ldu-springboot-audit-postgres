#!/bin/sh

main() {
    docker container kill postgres-database-server-test
    docker container rm postgres-database-server-test
}

main
