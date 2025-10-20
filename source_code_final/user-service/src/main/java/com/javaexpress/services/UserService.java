package com.javaexpress.services;

import java.util.List;

import com.javaexpress.dto.UserDto;

public interface UserService {

	UserDto save(UserDto userDto);
	UserDto findById(Integer userId);
	List<UserDto> findAll();
	UserDto update(Integer userId,UserDto userDto);
	void deleteById(Integer userId);
	UserDto findByUsername(String username);
}
