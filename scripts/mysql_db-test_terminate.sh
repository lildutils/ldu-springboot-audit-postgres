#!/bin/sh

main() {
    docker container kill mysql-database-server-test
    docker container rm mysql-database-server-test
}

main
