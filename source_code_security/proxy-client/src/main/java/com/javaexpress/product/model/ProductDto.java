package com.javaexpress.product.model;

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
public class ProductDto {

	private Integer productId;

	private String productTitle;

	private String sku;

	private Double priceUnit;

	private Integer quantity;

	@JsonProperty("category")
	@JsonInclude(Include.NON_NULL)
	private CategoryDto categoryDto;
}
