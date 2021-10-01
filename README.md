# ldu-springboot-audit

## About

To get more informations about this library, or if you have any question or suggestion, please send an email to [me](mailto:lildworks@gmail.com), or visit the [Official website](https://www.lildutils.hu/projects/ldu-springboot/ldu-springboot-audit)

* [Official Gradle documentation](https://docs.gradle.org)
* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.2/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.2/gradle-plugin/reference/html/#build-image)

## Prerequisites

* [Git](https://git-scm.com/download) - ^2.20.1
* [Gradle](https://gradle.org/releases/) - ^7.1.1
* [AdoptOpenJDK](https://adoptopenjdk.net/index.html) - ^JDK11
* [SpringBoot](https://start.spring.io) - ^2.4.5

## Projects

### ldu-springboot-audit/MySQL

#### Connection configuration for MySQL Database Server with Spring Data & JPA:

```properties
spring.sql.init.mode=always
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/databaseName?useUnicode=yes&characterEncoding=UTF-8
spring.datasource.username=root
spring.datasource.password=p4ssw0RD!

spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true
spring.jpa.database-platform=mysql
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL57InnoDBDialect
spring.jpa.properties.hibernate.dialect.storage_engine=innodb
spring.jpa.properties.hibernate.hbm2ddl.auto=update
spring.jpa.hibernate.ddl-auto=update
spring.jpa.generate-ddl=true
spring.jpa.open-in-view=false
spring.jpa.show-sql=false
```

#### Dependencies:

```gradle
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-data-jdbc'
	implementation 'org.springframework.boot:spring-boot-starter-security'
    runtimeOnly 'mysql:mysql-connector-java'
}
```

### ldu-springboot-audit/Postgres

#### Connection configurations for Postgres Database Server with Spring Data & JPA:

```properties
spring.sql.init.mode=always
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/databaseName?useUnicode=yes&characterEncoding=UTF-8
spring.datasource.username=
spring.datasource.password=

spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true
spring.jpa.database-platform=psql
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.hbm2ddl.auto=update
spring.jpa.hibernate.ddl-auto=update
spring.jpa.generate-ddl=true
spring.jpa.open-in-view=false
spring.jpa.show-sql=false
```

#### Dependencies:

```gradle
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-data-jdbc'
	implementation 'org.springframework.boot:spring-boot-starter-security'
	runtimeOnly 'org.postgresql:postgresql'
}
```

### ldu-springboot-audit/MongoDB

#### Connection configuration for Mongo Database Server with Spring Data:

```properties
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.authentication-database=databaseName
spring.data.mongodb.username=
spring.data.mongodb.password=
spring.data.mongodb.database=databaseName
```

#### Dependencies:

```gradle
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-data-mongodb'
	implementation 'org.springframework.boot:spring-boot-starter-security'
	implementation group: 'javax.persistence', name: 'javax.persistence-api', version: '2.2'
	implementation group: 'javax.validation', name: 'validation-api', version: '2.0.1.Final'
}
```

## Development

### Download dependencies

```sh
./gradlew --refresh-dependencies
```

### Run application

```sh
./gradlew bootRun --args="--spring.profiles.active=$USER"
```

### Run application for remote debugging

```sh
./gradlew bootRun -Dagentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=0.0.0.0:$remoteDebugPort --args="--spring.profiles.active=${USER}"
```

### Code Analyze

```sh
./gradlew check
```

## Test

```sh
./gradlew test
```

## Build

```sh
./gradlew build
```

## 

Thanks :)
