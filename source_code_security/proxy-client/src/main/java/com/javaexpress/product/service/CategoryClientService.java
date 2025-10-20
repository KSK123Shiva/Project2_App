package com.javaexpress.product.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.javaexpress.product.model.CategoryDto;

@FeignClient(name="PRODUCT-SERVICE",contextId = "categoryClientService",path="/api/categories")
public interface CategoryClientService {

	@PostMapping
	public ResponseEntity<CategoryDto> save(@RequestBody CategoryDto categoryDto);
	
	@GetMapping
	public ResponseEntity<List<CategoryDto>> findAll();
	
}
