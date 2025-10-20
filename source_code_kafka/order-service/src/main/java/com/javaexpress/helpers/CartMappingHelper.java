package com.javaexpress.helpers;

import org.springframework.beans.BeanUtils;

import com.javaexpress.dto.CartDto;
import com.javaexpress.dto.UserDto;
import com.javaexpress.entities.Cart;

public interface CartMappingHelper {

	public static CartDto map(Cart cart) {
		
		CartDto cartDto = new CartDto();
		BeanUtils.copyProperties(cart, cartDto);
		
		UserDto userDto = new UserDto();
		userDto.setUserId(cart.getUserId());
		cartDto.setUserDto(userDto);
		
		return cartDto;
	}
	
	public static Cart map(CartDto cartDto) {
		Cart cart = new Cart();
		BeanUtils.copyProperties(cartDto, cart);
		return cart;
	}
}
