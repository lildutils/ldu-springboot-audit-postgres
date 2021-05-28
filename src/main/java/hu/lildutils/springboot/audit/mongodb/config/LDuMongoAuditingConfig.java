package hu.lildutils.springboot.audit.mongodb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import hu.lildutils.springboot.audit.LDuAuditorAware;
import hu.lildutils.springboot.audit.impl.LDuAuditorAwareImpl;

@Configuration
@EnableMongoAuditing(auditorAwareRef = "lduAuditorAware")
public class LDuMongoAuditingConfig {

	@Bean("lduAuditorAware")
	public LDuAuditorAware<String> getLDuAuditorAwareImpl() {
		return new LDuAuditorAwareImpl();
	}

}
