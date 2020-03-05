package com.lildutils.springboot.audit.mongodb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import com.lildutils.springboot.audit.provider.LDuAuditorAwareImpl;

@Configuration
@EnableMongoAuditing(auditorAwareRef = "auditorProvider")
public class LDuMongoAuditConfigurer
{
	@Bean("auditorProvider")
	public AuditorAware<String> getAuditorProvider()
	{
		return new LDuAuditorAwareImpl();
	}

}
