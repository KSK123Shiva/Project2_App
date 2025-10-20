package com.javaexpress.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.javaexpress.user.model.CredentialDto;

@FeignClient(name="USER-SERVICE",contextId = "credentialClientService",
	path="/api/credentials",dismiss404 = true)
public interface CredentialClientService {

	@GetMapping("/username/{username}")
	public ResponseEntity<CredentialDto> findByUsername(
			@PathVariable("username") final String username) ;
	
}
