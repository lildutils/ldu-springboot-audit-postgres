package hu.lildutils.springboot.audit.mongodb;

import java.io.Serializable;

import org.springframework.data.domain.AuditorAware;

public interface LDuAuditorAware<T extends Serializable> extends AuditorAware<T> {

}
