package com.javaexpress.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
public class AddressDto implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private Integer addressId;
	private String fullAddress;
	private String postalCode;
	private String city;
	
	@JsonProperty("user")
	@JsonInclude(value=Include.NON_NULL)
	private UserDto userDto;
}
