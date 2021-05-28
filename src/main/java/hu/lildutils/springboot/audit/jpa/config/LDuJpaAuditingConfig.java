package hu.lildutils.springboot.audit.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import hu.lildutils.springboot.audit.LDuAuditorAware;
import hu.lildutils.springboot.audit.impl.LDuAuditorAwareImpl;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "lduAuditorAware")
public class LDuJpaAuditingConfig {

    @Bean("lduAuditorAware")
    public LDuAuditorAware<String> getLDuAuditorAwareImpl() {
        return new LDuAuditorAwareImpl();
    }

}
