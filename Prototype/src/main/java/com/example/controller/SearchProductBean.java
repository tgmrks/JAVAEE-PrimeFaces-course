package com.example.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class SearchProductBean implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	private List<Integer> filteredProducts;
	
	public SearchProductBean() {
		filteredProducts = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			filteredProducts.add(i);
		}
	}

	public List<Integer> getFilteredProducts() {
		return filteredProducts;
	}

}
