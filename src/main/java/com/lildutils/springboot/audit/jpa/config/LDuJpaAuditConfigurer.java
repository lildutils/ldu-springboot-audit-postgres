package com.lildutils.springboot.audit.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.lildutils.springboot.audit.provider.LDuAuditorAwareImpl;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class LDuJpaAuditConfigurer
{
	@Bean("auditorProvider")
	public AuditorAware<String> getAuditorProvider()
	{
		return new LDuAuditorAwareImpl();
	}

}
