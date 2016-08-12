package com.example.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.hibernate.jdbc.Expectations;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import com.example.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Product.class)
public class ProductConverter implements Converter{

	//@Inject <--does'nt work --> workaroun: 'com.example.util.cdi.CDIServiceLocator' 
	private  ProductRepository productRepository; 
	
	public ProductConverter(){
		productRepository = CDIServiceLocator.getBean(ProductRepository.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Product returning = null;
		if(value != null && !value.equals("")){
			Long id = new Long(value);
			returning = productRepository.byId(id);
		}
		return returning;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
					Product product = (Product) value;
					return product.getId() != null ? product.getId().toString() : null;
		}
		return "";
	}

}
