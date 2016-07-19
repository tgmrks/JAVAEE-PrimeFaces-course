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
		return manager.createQuery("from Category", Category.class).getResultList();
	}
	
	public Category byId(Long id){      
		return manager.find(Category.class, id);
	} 

}
