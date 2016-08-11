package com.example.filter;

import java.io.Serializable;

import com.example.validation.SKU;

public class ProductFilter implements Serializable {
	
	private final static long serialVersionUID = 1L;
	
	private String Sku;
	private String name;
	
	@SKU //validation
	public String getSku() {
		return Sku;
	}
	public void setSku(String sku) {
		Sku = sku == null ? null : sku.toUpperCase();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
