package com.javaexpress.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.dto.CategoryDto;
import com.javaexpress.dto.ProductDto;
import com.javaexpress.entity.Product;
import com.javaexpress.helper.CategoryMappingHelper;
import com.javaexpress.helper.ProductMappingHelper;
import com.javaexpress.repository.CategoryRepository;
import com.javaexpress.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public ProductDto save(ProductDto productDto) {
		log.info("ProductService :: save");
		Product product  = ProductMappingHelper.map(productDto);
		var dbCategory = categoryRepository.findById(productDto.getCategoryDto().getCategoryId())
			.orElseThrow(() -> new RuntimeException("Category Not Found in DB"));
		product.setCategory(dbCategory);
		
		var savedProduct  = productRepository.save(product);
		return ProductMappingHelper.map(savedProduct);
		
	}
	
	
	public List<ProductDto> findAll() {
		log.info("*** ProductDto List, service; fetch all categorys *");
		return this.productRepository.findAll()
				.stream()
					.map(ProductMappingHelper::map)
					.distinct()
					.collect(Collectors.toUnmodifiableList());
	}
	
	public ProductDto findByID(Integer productId) {
		log.info("ProductService :: findById");
		return productRepository.findById(productId)
				.map(ProductMappingHelper::map)
				.orElseThrow(() -> new RuntimeException("Product Not Found in Db"));
	}
	
	public void deleteById(Integer productId) {
		log.info("ProductService :: deleteById");
		var dbProduct  = productRepository.findById(productId);
		productRepository.delete(dbProduct.get());
	}
	
}
