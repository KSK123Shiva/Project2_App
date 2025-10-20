package com.javaexpress.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.user.model.CredentialDto;
import com.javaexpress.user.service.CredentialClientService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = {"/api/credentials"})
@Slf4j
public class CredentialController {

	@Autowired
	private  CredentialClientService credentialClientService;
	
	@GetMapping("/username/{username}")
	public ResponseEntity<CredentialDto> findByUsername(
			@PathVariable("username") final String username) {
		log.info("*** CredentialDto, resource; update credential with credentialId *");
		return credentialClientService.findByUsername(username);
	}
}
