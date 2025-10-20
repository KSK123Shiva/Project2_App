package com.javaexpress.helper;

import com.javaexpress.dto.CredentialDto;
import com.javaexpress.dto.UserDto;
import com.javaexpress.model.Credential;
import com.javaexpress.model.User;

public interface CredentialMappingHelper {
	
	public static CredentialDto map(final Credential credential) {
		return CredentialDto.builder()
				.credentailId(credential.getCredentailId())
				.username(credential.getUsername())
				.password(credential.getPassword())
				.roleBasedAuthrority(credential.getRoleBasedAuthrority())
				.isEnabled(credential.getIsEnabled())
				.isAccountNonExpired(credential.getIsAccountNonExpired())
				.isAccountNonLocked(credential.getIsAccountNonLocked())
				.isCredentailsNonExpired(credential.getIsCredentailsNonExpired())
				.userDto(
						UserDto.builder()
							.userId(credential.getUser().getUserId())
							.firstName(credential.getUser().getFirstName())
							.lastName(credential.getUser().getLastName())
							.email(credential.getUser().getEmail())
							.phone(credential.getUser().getPhone())
							.build())
				.build();
	}
	
	public static Credential map(final CredentialDto credentialDto) {
		return Credential.builder()
				.credentailId(credentialDto.getCredentailId())
				.username(credentialDto.getUsername())
				.password(credentialDto.getPassword())
				.roleBasedAuthrority(credentialDto.getRoleBasedAuthrority())
				.isEnabled(credentialDto.getIsEnabled())
				.isAccountNonExpired(credentialDto.getIsAccountNonExpired())
				.isAccountNonLocked(credentialDto.getIsAccountNonLocked())
				.isCredentailsNonExpired(credentialDto.getIsCredentailsNonExpired())
				.user(
						User.builder()
							.userId(credentialDto.getUserDto().getUserId())
							.firstName(credentialDto.getUserDto().getFirstName())
							.lastName(credentialDto.getUserDto().getLastName())
							.email(credentialDto.getUserDto().getEmail())
							.phone(credentialDto.getUserDto().getPhone())
							.build())
				.build();
	}
	
	
	
}






