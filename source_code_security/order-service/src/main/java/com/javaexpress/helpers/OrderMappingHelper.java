package com.javaexpress.helpers;

import com.javaexpress.dto.CartDto;
import com.javaexpress.dto.OrderDto;
import com.javaexpress.entities.Cart;
import com.javaexpress.entities.Order;

public class OrderMappingHelper {

	public static OrderDto map(Order order) {
		
		return OrderDto.builder()
				.orderId(order.getOrderId())
				.orderDate(order.getOrderDate())
				.orderDesc(order.getOrderDesc())
				.orderFee(order.getOrderFee())
				.cartDto(CartDto.builder()
						.cartId(order.getCart().getCartId())
						.build())
				.build();
		
	}
	
	public static Order map(OrderDto orderDto) {
		
		return Order.builder()
				.orderId(orderDto.getOrderId())
				.orderDate(orderDto.getOrderDate())
				.orderDesc(orderDto.getOrderDesc())
				.orderFee(orderDto.getOrderFee())
				.cart(Cart.builder().cartId(orderDto.getCartDto().getCartId()).build())
				.build();
				
				
				
				
	}
}
