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
import javax.validation.constraints.NotNull;

import com.example.model.Category;
import com.example.model.Product;
import com.example.repository.CategoryRepository;
import com.example.service.registerProductService;
import com.example.util.jsf.FacesUtil;

@Named
@ViewScoped
public class RegisterProductBean implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	
	@Inject //will call a producer that you may configure (refer to: 'com.example.util.jpa.EntityManagerProducer')
	private CategoryRepository categoryRepository;
	
	@Inject
	private registerProductService registerProductService;
	
	private Product product;
	private Category categoryFather; 
	private List<Category> categoriesRoot = new ArrayList<>();
	private List<Category> subcategory = new ArrayList<>();
	
	public RegisterProductBean(){
		clear(); 
	}
	
	public void save(){
		product = registerProductService.save(product);
		clear();
		FacesUtil.addInfoMessage("Product successfuly saved!");
	}
	
	private void clear(){
		product = new Product();
		categoryFather = null;
		subcategory = new ArrayList<>();
	}
	
	public void init(){								
		System.out.println("begin transac...");

		/*Good Practise
		//This is not a good practise to create 'EntityManagerFactory' everytime the method is called. It will demand unnecessary proccess. 
		//Create a class with 'ApplicationScoped' to handle only one time     //Persistence-unit name
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OrderOU");
		*/
					
		if(FacesUtil.isNotPostback()){
			categoriesRoot = categoryRepository.listCategories();
		}
	
	}
	
	public void loadSubcategory(){
		System.out.println("categoryFather: " + categoryFather.getId() + " - " + categoryFather.getDescription());
		subcategory = categoryRepository.subcategoriesOf(categoryFather);
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

	@NotNull
	public Category getCategoryFather() {
		return categoryFather;
	}

	public void setCategoryFather(Category categoryFather) {
		this.categoryFather = categoryFather;
	}

	public List<Category> getSubCategory() {
		return subcategory;
	}

	public void setSubCategory(List<Category> subcategory) {
		this.subcategory = subcategory;
	}
	
	
}
