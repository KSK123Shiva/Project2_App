package com.javaexpress.product.model;

import java.util.Set;

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
public class CategoryDto {

	private Integer categoryId;

	private String categoryTitle;
	
	@JsonInclude(Include.NON_NULL)
	private Set<CategoryDto> subCategoriesDto;
	
	@JsonProperty("parentCategory")
	@JsonInclude(Include.NON_NULL)
	private CategoryDto parentCategoryDto;
	
	@JsonInclude(Include.NON_NULL)
	private Set<ProductDto> productsDtos;
}
