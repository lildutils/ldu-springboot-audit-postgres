package com.lildutils.springboot.audit.provider;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class LDuAuditorAwareImpl implements AuditorAware<String>
{
	@Override
	public Optional<String> getCurrentAuditor()
	{
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if( authentication != null && authentication.getPrincipal() != null )
		{
			return Optional.of( "P_" + authentication.getPrincipal() );
		}
		return Optional.of( "P_ANONYMOUS" );
	}

}
