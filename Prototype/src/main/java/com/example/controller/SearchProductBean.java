package com.example.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.filter.ProductFilter;
import com.example.model.Product;
import com.example.repository.ProductRepository;

@Named
@ViewScoped
public class SearchProductBean implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Inject
	private ProductRepository productRepository;
	
	private ProductFilter filter;

	private List<Product> filteredProducts;
	
	public SearchProductBean(){
		filter = new ProductFilter();
	}

	public void search(){
		filteredProducts = productRepository.filtered(filter);
	}
	
	public List<Product> getFilteredProducts() {
		return filteredProducts;
	}

	public ProductFilter getFilter() {
		return filter;
	}

}
