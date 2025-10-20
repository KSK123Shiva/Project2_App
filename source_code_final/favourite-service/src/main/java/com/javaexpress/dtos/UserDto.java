package com.javaexpress.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class UserDto {

	private Integer userId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;

	@JsonInclude(Include.NON_NULL)
	private Set<FavouriteDto> favouriteDtos;
}
