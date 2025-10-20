package com.javaexpress.user.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class CredentialDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer credentailId;
	
	private String username;
	
	private String password;
	
	private RoleBasedAuthrority roleBasedAuthrority;
	
	private Boolean isEnabled;
	
	private Boolean isAccountNonExpired;
	
	private Boolean isAccountNonLocked;
	
	private Boolean isCredentailsNonExpired;
	
	@JsonProperty("user")
	@JsonInclude(value=Include.NON_NULL)
	private UserDto userDto;
	
}
