package com.javaexpress.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.dto.CredentialDto;
import com.javaexpress.helper.CredentialMappingHelper;
import com.javaexpress.repository.CredentailsRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class CredentialServiceImpl {
	
	@Autowired
	private CredentailsRepository credentailsRepository;

	public CredentialDto findByUsername(final String username) {
		return CredentialMappingHelper.map(credentailsRepository.findByUsername(username)
				.orElseThrow(() -> 
				new RuntimeException(String.format("#### Credential with username: %s not found! ####", username))));
	}
	
}
