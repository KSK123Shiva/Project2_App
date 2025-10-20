package com.javaexpress.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.auth.model.AuthenticationRequest;
import com.javaexpress.auth.model.AuthenticationResponse;
import com.javaexpress.auth.service.AuthenticationService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/authenticate")
@Slf4j
public class AuthenticationController {

	@Autowired
	private AuthenticationService autehAuthenticationService;
	
	@PostMapping
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
		log.info("Authentication Controller,process with request {} ",request);
		return ResponseEntity.ok(autehAuthenticationService.authenticate(request));
	}
}
