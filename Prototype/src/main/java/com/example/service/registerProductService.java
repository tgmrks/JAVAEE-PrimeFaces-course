package com.example.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import com.example.util.jpa.Transactional;

public class registerProductService implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private ProductRepository productRepository;
	
	@Transactional //needed tags in META-INF/beans.xml
	public Product save(Product product){
		
		Product existing = productRepository.bySKU(product.getSku());
		
		if(existing != null && !existing.equals(product)){
			throw new BusinessRuleExpection("Product with SKU already registered.");
		}
		
		return productRepository.save(product);
	}

}
