package com.javaexpress.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.javaexpress.user.model.UserDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@FeignClient(name="USER-SERVICE",contextId = "userClientService",path="/api/users",
	dismiss404 = true)
//@FeignClient(name="user-service",path="/api/users")
public interface UserClientService {

	@PostMapping
	public ResponseEntity<UserDto> save(@RequestBody 
					@NotNull(message = "Input must not be null")
					@Valid UserDto userDto);
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> findById(@PathVariable Integer userId);
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> update(@PathVariable Integer userId,
			@RequestBody UserDto userDto );
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Boolean> delete(@PathVariable Integer userId);
	
	@GetMapping("/username/{username}")
	public ResponseEntity<UserDto> findByUsername(@PathVariable String username);
}
