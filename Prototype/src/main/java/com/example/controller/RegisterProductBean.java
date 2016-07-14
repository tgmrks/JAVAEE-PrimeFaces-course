package com.example.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.example.model.Product;

@Named
@ViewScoped
public class RegisterProductBean implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	
	private Product product;
	
	public RegisterProductBean(){
		product = new Product(); 
	}
	
	public void save(){
		//throw new RuntimeException("testing");
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
