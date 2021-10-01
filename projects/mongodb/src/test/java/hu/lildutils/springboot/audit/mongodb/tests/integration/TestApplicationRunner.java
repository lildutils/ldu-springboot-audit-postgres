package hu.lildutils.springboot.audit.mongodb.tests.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
class TestApplicationRunner {

    public static void main(final String[] args) {
        SpringApplication.run(TestApplicationRunner.class, args);
    }

}
