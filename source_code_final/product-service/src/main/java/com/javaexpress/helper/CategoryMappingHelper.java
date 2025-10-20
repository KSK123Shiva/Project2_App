package com.javaexpress.helper;

import org.springframework.beans.BeanUtils;

import com.javaexpress.dto.CategoryDto;
import com.javaexpress.entity.Category;

public interface CategoryMappingHelper {

	public static Category map(CategoryDto categoryDto) {
		if(categoryDto == null) {
			return null;
		}
		
		Category category = new Category();
		BeanUtils.copyProperties(categoryDto, category);
		
		if(categoryDto.getParentCategoryDto() != null) {
			Category parentCategory = new Category();
			parentCategory.setCategoryId(categoryDto.getParentCategoryDto().getCategoryId());
			category.setParentCategory(parentCategory);
		} else {
			category.setParentCategory(null);
		}
		

		return category;
	}

	public static CategoryDto map(Category category) {
		if(category == null) {
			return null;
		}
		CategoryDto categoryDto = new CategoryDto();
		BeanUtils.copyProperties(category, categoryDto);
		if(category.getParentCategory() != null) {
			CategoryDto parentCategoryDto = new CategoryDto();
			BeanUtils.copyProperties(category.getParentCategory(), parentCategoryDto);
			categoryDto.setParentCategoryDto(parentCategoryDto);
		}
		return categoryDto;
	}
}
