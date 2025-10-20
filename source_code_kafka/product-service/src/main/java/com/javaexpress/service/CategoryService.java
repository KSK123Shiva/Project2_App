package com.javaexpress.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.dto.CategoryDto;
import com.javaexpress.entity.Category;
import com.javaexpress.helper.CategoryMappingHelper;
import com.javaexpress.repository.CategoryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public CategoryDto save(CategoryDto categoryDto) {
		log.info("CategoryService :: save");
		
		Category parentCategory = null;
		if(categoryDto.getParentCategoryDto()!=null) {
			Integer id = categoryDto.getParentCategoryDto().getCategoryId();
			parentCategory = categoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Parent Category Not Found"));
		}
		Category category = CategoryMappingHelper.map(categoryDto);
		
		if(parentCategory != null) {
			category.setParentCategory(parentCategory);
		}
		
		return CategoryMappingHelper.map(categoryRepository.save(category));
	}
	
	public List<CategoryDto> findAll() {
		log.info("*** CategoryDto List, service; fetch all categorys *");
		return this.categoryRepository.findAll()
				.stream()
					.map(CategoryMappingHelper::map)
					.distinct()
					.collect(Collectors.toUnmodifiableList());
	}

}












