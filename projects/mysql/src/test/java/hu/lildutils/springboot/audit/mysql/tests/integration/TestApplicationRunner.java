package hu.lildutils.springboot.audit.mysql.tests.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
class TestApplicationRunner {

    public static void main(final String[] args) {
        SpringApplication.run(TestApplicationRunner.class, args);
    }

}
