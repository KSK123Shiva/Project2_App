package com.javaexpress.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.product.model.ProductDto;
import com.javaexpress.product.service.ProductClientService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/products")
@Slf4j
public class ProductController {

	@Autowired
	private ProductClientService productClientService;
	
	@PostMapping
	public ResponseEntity<ProductDto> save(@RequestBody ProductDto productDto) {
		log.info("Product Controller save");
		return productClientService.save(productDto);
	}
	
}
