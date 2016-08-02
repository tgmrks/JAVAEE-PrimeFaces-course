package com.example.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.example.model.Category;

public class CategoryRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public List<Category> listCategories(){       //That's not the name of your table, but your class
		return manager.createQuery("from Category where categoryFather is null", Category.class).getResultList();
	}
	
	public List<Category> subcategoriesOf(Category categoryFather){
		return manager.createQuery("from Category where categoryFather = :root", 
				Category.class).setParameter("root", categoryFather).getResultList();
	}	
	
	public Category byId(Long id){      
		return manager.find(Category.class, id);
	} 

}
