package com.javaexpress.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.user.model.UserDto;
import com.javaexpress.user.service.UserClientService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/users")
@Slf4j
public class UserController {

	@Autowired
	private UserClientService userClientService;

	@PostMapping
	public ResponseEntity<UserDto> save(@RequestBody 
					@NotNull(message = "Input must not be null")
					@Valid UserDto userDto) {
		log.info("Proxy Client :: UserController");
		return userClientService.save(userDto);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> findById(@PathVariable Integer userId) {
		log.info("UserController :: fetch user details");
		return userClientService.findById(userId);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> update(@PathVariable Integer userId,
			@RequestBody UserDto userDto ) {
		log.info("UserController :: update");
		return userClientService.update(userId, userDto);
	}
	
	
	@GetMapping("/username/{username}")
	public ResponseEntity<UserDto> findByUsername(@PathVariable String username) {
		log.info("UserController :: findByUsername");
		return userClientService.findByUsername(username);
	}

}
