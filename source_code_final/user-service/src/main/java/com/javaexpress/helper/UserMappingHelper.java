package com.javaexpress.helper;

import org.springframework.beans.BeanUtils;

import com.javaexpress.dto.CredentailDto;
import com.javaexpress.dto.UserDto;
import com.javaexpress.model.Credential;
import com.javaexpress.model.User;

public interface UserMappingHelper {

	public static UserDto map(User user) {
		if(user == null) {
			return null;
		}
		UserDto useDto = new UserDto();
		BeanUtils.copyProperties(user, useDto);
		
		if(user.getCredential() != null) {
			CredentailDto credentailDto = new CredentailDto();
			BeanUtils.copyProperties(user.getCredential(), credentailDto);
			useDto.setCredentailDto(credentailDto);
		}
		return useDto;
	}
	
	public static User map(UserDto userDto) {
		if(userDto == null) {
			return null;
		}
		
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		
		if(userDto.getCredentailDto() != null) {
			Credential credential = new Credential();
			BeanUtils.copyProperties(userDto.getCredentailDto(),credential);
			
			credential.setUser(user);
			user.setCredential(credential);
		}
		return user;
	}
}
