package com.javaexpress.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.dto.CredentialDto;
import com.javaexpress.services.CredentialServiceImpl;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = {"/api/credentials"})
@Slf4j
@RequiredArgsConstructor
public class CredentialController {

	private final CredentialServiceImpl credentialService;
	
	
	@GetMapping("/username/{username}")
	public ResponseEntity<CredentialDto> findByUsername(
			@PathVariable("username") 
			@NotBlank(message = "Input must not blank") 
			@Valid final String username) {
		log.info("*** CredentialDto, resource; update credential with credentialId *");
		return ResponseEntity.ok(this.credentialService.findByUsername(username));
	}
}
