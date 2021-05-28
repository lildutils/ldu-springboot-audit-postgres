package hu.lildutils.springboot.audit.jpa;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import hu.lildutils.springboot.audit.jpa.config.LDuJpaAuditingConfig;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(LDuJpaAuditingConfig.class)
public @interface EnableLDuJpaAuditing {

}
