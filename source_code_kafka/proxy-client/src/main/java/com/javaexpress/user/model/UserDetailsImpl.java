package com.javaexpress.user.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class UserDetailsImpl implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final CredentialDto credential;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		log.info("getAuthorities {}",credential.getRoleBasedAuthrority().name());
		return List.of(new SimpleGrantedAuthority(credential.getRoleBasedAuthrority().name()));
	}

	@Override
	public String getPassword() {
		log.info("getPassword {}",credential.getPassword());
		return credential.getPassword();
	}

	@Override
	public String getUsername() {
		log.info("getUsername {}",credential.getUsername());
		return credential.getUsername();
	}

	
	
}
