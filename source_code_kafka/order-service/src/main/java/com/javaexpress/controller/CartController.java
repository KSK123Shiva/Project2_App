package com.javaexpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.dto.CartDto;
import com.javaexpress.service.CartServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/carts")
@Slf4j
public class CartController {

	@Autowired
	private CartServiceImpl cartServiceImpl;
	
	@PostMapping
	public ResponseEntity<CartDto> save(@RequestBody CartDto cartDto) {
		log.info("CartController :: save");
		return ResponseEntity.ok(cartServiceImpl.save(cartDto));
	}
	
	@GetMapping("{cartId}")
	public ResponseEntity<CartDto> findById(@PathVariable Integer cartId){
		log.info("CartController :: findById");
		return ResponseEntity.ok(cartServiceImpl.findById(cartId));
	}
	
}
