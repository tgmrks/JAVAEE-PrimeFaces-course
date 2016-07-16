package com.example.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.model.Category;
import com.example.model.Product;

@Named
@ViewScoped
public class RegisterProductBean implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	
	@Inject //will call a producer that you may configure (refer to: 'com.example.util.jpa.EntityManagerProducer')
	private EntityManager manager;
	private Product product;
	
	private List<Category> categoriesRoot = new ArrayList<>();
	
	public RegisterProductBean(){
		product = new Product(); 
	}
	
	public void save(){
		//throw new RuntimeException("testing");
	}
	
	public void init(){								
		System.out.println("begin transac...");

		/*Good Practise
		//This is not a good practise to create 'EntityManagerFactory' everytime the method is called. It will demand unnecessary proccess. 
		//Create a class with 'ApplicationScoped' to handle only one time     //Persistence-unit name
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OrderOU");
		*/
							//That's not the name of your table, but your class	
		categoriesRoot = manager.createQuery("from Category", Category.class).getResultList();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Category> getCategoriesRoot() {
		return categoriesRoot;
	}
	
}
