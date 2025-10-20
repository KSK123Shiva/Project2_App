package com.javaexpress.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum RoleBasedAuthrority {

	ROLE_USER("USER"),
	ROLE_ADMIN("ADMIN");
	
	private final String role;
}
