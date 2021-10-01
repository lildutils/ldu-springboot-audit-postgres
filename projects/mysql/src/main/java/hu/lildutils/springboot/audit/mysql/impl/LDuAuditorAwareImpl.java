package hu.lildutils.springboot.audit.mysql.impl;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import hu.lildutils.springboot.audit.mysql.LDuAuditorAware;

public class LDuAuditorAwareImpl implements LDuAuditorAware<String> {
    public static final String AUDITOR_PRINCIPAL_PREFIX = "P_";
    public static final String AUDITOR_ANONYMOUS = "P_ANONYMOUS";

    @Override
    public Optional<String> getCurrentAuditor() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() != null) {
            return Optional.of(AUDITOR_PRINCIPAL_PREFIX + authentication.getPrincipal());
        }
        return Optional.of(AUDITOR_ANONYMOUS);
    }

}
