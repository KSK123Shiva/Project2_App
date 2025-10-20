package com.javaexpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.dto.OrderDto;
import com.javaexpress.service.OrderServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/orders")
@Slf4j
public class OrderController {

	@Autowired
	private OrderServiceImpl ordreServiceImpl;
	
	@PostMapping
	public ResponseEntity<OrderDto> save(@RequestBody OrderDto orderDto) {
		return ResponseEntity.ok(ordreServiceImpl.save(orderDto));
	}
	

	@GetMapping("/{orderId}")
	public ResponseEntity<OrderDto> findById(@PathVariable("orderId") Integer orderId) {
		log.info("*** OrderDto, resource; fetch order by id *");
		return ResponseEntity.ok(ordreServiceImpl.findById(orderId));
	}
}
