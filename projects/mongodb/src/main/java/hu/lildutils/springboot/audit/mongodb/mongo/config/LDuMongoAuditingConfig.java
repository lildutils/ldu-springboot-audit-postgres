package hu.lildutils.springboot.audit.mongodb.mongo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import hu.lildutils.springboot.audit.mongodb.LDuAuditorAware;
import hu.lildutils.springboot.audit.mongodb.impl.LDuAuditorAwareImpl;

@Configuration
@EnableMongoAuditing(auditorAwareRef = "lduMongoAuditorProvider")
public class LDuMongoAuditingConfig {

    @Bean("lduMongoAuditorProvider")
    public LDuAuditorAware<String> getLDuMongoAuditorProvider() {
        return new LDuAuditorAwareImpl();
    }

}
