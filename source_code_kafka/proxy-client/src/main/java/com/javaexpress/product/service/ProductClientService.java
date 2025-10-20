package com.javaexpress.product.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.javaexpress.product.model.ProductDto;

@FeignClient(name="PRODUCT-SERVICE",contextId = "productClientService",path="/api/products")
public interface ProductClientService {

	@PostMapping
	public ResponseEntity<ProductDto> save(@RequestBody ProductDto productDto);
	
}
