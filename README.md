# ldu-springboot-audit/postgres

## About

To get more informations about this library visit the [Official Site](https://lildutils.hu/libs/ldu-springboot/ldu-springboot-audit/postgres).

### Reference Documentation

For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/html/#build-image)

### Additional Links

These additional references should also help:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

---
## Usage

### Dependencies

```groovy
dependencies {
  implementation 'org.springframework.boot:spring-boot-starter'
  implementation 'org.springframework.boot:spring-boot-starter-security'
  implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
  implementation 'org.springframework.boot:spring-boot-starter-data-jdbc'
  testImplementation 'org.springframework.boot:spring-boot-starter-test'
  runtimeOnly 'org.postgresql:postgresql'
}
```

### Configurations

```properties
##Connection configurations for Postgres Database Server with Spring Data & JPA:
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

---
## Development

### Prerequisites

* [Git](https://git-scm.com/download) - git version 2.30.2
* [AdoptOpenJDK](https://adoptopenjdk.net/index.html) - openjdk version "17.0.3" 2022-04-19
* [Gradle](https://gradle.org/releases/) - Gradle 7.4.1
* [SpringBoot](https://spring.io/projects/spring-boot) - SpringBoot 2.7.1

```sh
./gradlew check -x test -x build --refresh-dependencies --warning-mode all
```

#### [Checkstyle Gradle Plugin](https://docs.gradle.org/current/userguide/checkstyle_plugin.html)

```groovy
// 1) apply plugin
plugins {
  id 'checkstyle'
}

// 2) configure task
checkstyle {
  configDirectory = file("$rootProject.projectDir/config/checkstyle")
  configFile      = file("$rootProject.projectDir/config/checkstyle/checkstyle.xml")
}

// 3) configure HTML reports
tasks.withType(Checkstyle) {
  reports {
    xml.required      = false
    html.required     = true
    html.destination  file("$rootProject.projectDir/docs/latest/html/reports/checkstyle/index.html")
  }
}
```

---
## Test

```sh
./gradlew test -x check -x build --refresh-dependencies --warning-mode all
```

---
## Build

```sh
./gradlew build -x check -x test --refresh-dependencies --warning-mode all
```

---
## Documentations

### JavaDoc

```sh
./gradlew javadoc --refresh-dependencies --warning-mode all
```

### Changelog

```sh
./gradlew changelog --refresh-dependencies --warning-mode all
```

#### [Changelog Gradle Plugin](https://github.com/tomasbjerre/git-changelog-gradle-plugin)

```groovy
// 1) apply plugin
plugins {
  id 'se.bjurr.gitchangelog.git-changelog-gradle-plugin' version '1.73.0'
}

// 2) configure task
task changelog(type: se.bjurr.gitchangelog.plugin.gradle.GitChangelogTask) {
  fromRepo        = file(".");
  toRef           = "$project.version";
  file            = file("$rootProject.projectDir/CHANGELOG.md");
  templateContent = file("$rootProject.projectDir/config/changelog/changelog.mustache").getText('UTF-8');

  /* This will ignore the following commit messages if it starts with: */
  // - DEBUG: or debug:
  // - REL: or rel:
  // - RELEASE: or release:
  // - CHANGELOG: or changelog:
  // - CHORE: or chore:
  // - IMPR: or impr:
  // - Merge tag
  // - Merge branch
  ignoreCommitsIfMessageMatches = ".*((DEBUG:)|(debug:)|(REL:)|(rel:)|(RELEASE:)|(release:)|(CHANGELOG:)|(changelog:)|(CHORE:)|(chore:)|(IMPR:)|(impr:)|(Merge tag)|(Merge branch)).*";
}
```

---
If you have any questions or suggestions about this project, or if you find any vulnerability in the code, or on the website please contact me [here](mailto:lildworks@gmail.com).

Thanks :)
