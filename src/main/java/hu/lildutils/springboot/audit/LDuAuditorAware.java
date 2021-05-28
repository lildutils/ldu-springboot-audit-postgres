package hu.lildutils.springboot.audit;

import java.io.Serializable;

import org.springframework.data.domain.AuditorAware;

public interface LDuAuditorAware<T extends Serializable> extends AuditorAware<T> {

}
