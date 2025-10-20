package com.javaexpress.auth.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.javaexpress.auth.model.AuthenticationRequest;
import com.javaexpress.auth.model.AuthenticationResponse;
import com.javaexpress.jwt.JwtUtilImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {

	private final AuthenticationManager authenticationManager;
	private final UserDetailsServiceImpl userDetailsServiceImpl;
	private final JwtUtilImpl jwtUtilImpl;
	
	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		log.info("AuthenticationService :: authenticate user service");
		try {
			UsernamePasswordAuthenticationToken result = 
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
			authenticationManager.authenticate(result);
		} catch (BadCredentialsException e) {
			throw new IllegalArgumentException("Bad Credntials");
		}
		UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(request.getUsername());
		return new AuthenticationResponse(jwtUtilImpl.generateToken(userDetails));
	}

}
