package com.javaexpress.helper;

import com.javaexpress.dto.CategoryDto;
import com.javaexpress.dto.ProductDto;
import com.javaexpress.entity.Category;
import com.javaexpress.entity.Product;

public interface ProductMappingHelper {

	public static Product map(ProductDto productDto) {
		// Convert ProductDto to Product Entity
		Category category = new Category();
		category.setCategoryId(productDto.getCategoryDto().getCategoryId());
		
		return Product.builder()
					.productId(productDto.getProductId())
					.productTitle(productDto.getProductTitle())
					.sku(productDto.getSku())
					.priceUnit(productDto.getPriceUnit())
					.quantity(productDto.getQuantity())
					.category(category)
					.build();
		
	}
	
	public static ProductDto map(Product product) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setCategoryId(product.getCategory().getCategoryId());
		categoryDto.setCategoryTitle(product.getCategory().getCategoryTitle());
		
		return ProductDto.builder()
					.productId(product.getProductId())
					.productTitle(product.getProductTitle())
					.sku(product.getSku())
					.priceUnit(product.getPriceUnit())
					.quantity(product.getQuantity())
					.categoryDto(categoryDto)
					.build();
	}
}
