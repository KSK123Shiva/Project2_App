package com.javaexpress.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javaexpress.user.model.CredentialDto;
import com.javaexpress.user.model.UserDetailsImpl;
import com.javaexpress.user.service.CredentialClientService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private CredentialClientService credentialClientService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("UserDetailsServiceImpl  loadUserByUsername executed {}",username);
		CredentialDto result = credentialClientService.findByUsername(username).getBody();
		return new UserDetailsImpl(result);
	}

	
}
