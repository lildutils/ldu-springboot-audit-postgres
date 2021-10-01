package hu.lildutils.springboot.audit.mysql.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import hu.lildutils.springboot.audit.mysql.LDuAuditorAware;
import hu.lildutils.springboot.audit.mysql.impl.LDuAuditorAwareImpl;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "lduJpaAuditorProvider")
public class LDuJpaAuditingConfig {

    @Bean("lduJpaAuditorProvider")
    public LDuAuditorAware<String> getLDuJpaAuditorProvider() {
        return new LDuAuditorAwareImpl();
    }

}
