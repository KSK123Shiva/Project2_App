package com.javaexpress.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderItemDto {

	private Integer productId;
	private Integer orderId;
	private Integer orderQuantity;
	
	@JsonProperty("product")
	@JsonInclude(Include.NON_NULL)
	private ProductDto productDto;
	
	@JsonProperty("order")
	@JsonInclude(Include.NON_NULL)
	private OrderDto orderDto;
	
}
