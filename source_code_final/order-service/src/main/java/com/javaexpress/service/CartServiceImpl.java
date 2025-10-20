package com.javaexpress.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.dto.CartDto;
import com.javaexpress.feignclients.UserFeignClient;
import com.javaexpress.helpers.CartMappingHelper;
import com.javaexpress.repository.CartRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CartServiceImpl {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	public CartDto save(CartDto cartDto) {
		log.info("CartServiceImpl :: save");
		return CartMappingHelper.map(
				cartRepository.save(
						CartMappingHelper.map(cartDto)));
	}
	
	
	public CartDto findById(Integer cartId) {
		log.info("CartServiceImpl findById");
		return cartRepository.findById(cartId)
				.map(CartMappingHelper::map)
				.map(c -> {
					c.setUserDto(userFeignClient.findById(c.getUserId()).getBody());
					return c;
				})
				.orElseThrow(() -> new RuntimeException("Cart Id Not Found in DB"));
	}
	
}
