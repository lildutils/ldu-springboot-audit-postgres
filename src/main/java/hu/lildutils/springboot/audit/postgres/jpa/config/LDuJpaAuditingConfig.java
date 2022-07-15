package hu.lildutils.springboot.audit.postgres.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import hu.lildutils.springboot.audit.postgres.LDuAuditorAware;
import hu.lildutils.springboot.audit.postgres.impl.LDuAuditorAwareImpl;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "lduJpaAuditorProvider")
public class LDuJpaAuditingConfig {

    @Bean("lduJpaAuditorProvider")
    public LDuAuditorAware<String> getLDuJpaAuditorProvider() {
        return new LDuAuditorAwareImpl();
    }

}
