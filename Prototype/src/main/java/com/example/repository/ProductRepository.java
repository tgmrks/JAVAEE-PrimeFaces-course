package com.example.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.apache.commons.lang3.StringUtils;

import com.example.filter.ProductFilter;
import com.example.model.Category;
import com.example.model.Product;

public class ProductRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Product save(Product product){
		return product = manager.merge(product);
	}
	
	public Product bySKU(String sku){
		try {
			return manager.createQuery("from Product where upper(sku) = :sku", Product.class)
				.setParameter("sku", sku.toUpperCase())
				.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Product> filtered(ProductFilter filter){
		
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Product.class);
		
		if(StringUtils.isNotBlank(filter.getSku()))
			criteria.add(Restrictions.eq("sku", filter.getSku()));
		
		if(StringUtils.isNotBlank(filter.getName()))
			criteria.add(Restrictions.ilike("name", filter.getName(), MatchMode.ANYWHERE));
		
		return criteria.addOrder(Order.asc("name")).list();
	}

	public Product byId(Long id) {
		return manager.find(Product.class, id);
	}

}
