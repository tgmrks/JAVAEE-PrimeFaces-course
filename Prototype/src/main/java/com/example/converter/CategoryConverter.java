package com.example.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.hibernate.jdbc.Expectations;

import com.example.model.Category;
import com.example.repository.CategoryRepository;
import com.example.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Category.class)
public class CategoryConverter implements Converter{

	//@Inject <--does'nt work --> workaroun: 'com.example.util.cdi.CDIServiceLocator' 
	private  CategoryRepository categoryRepository; 
	
	public CategoryConverter(){
		categoryRepository = CDIServiceLocator.getBean(CategoryRepository.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Category returning = null;
		if(value != null){
			Long id = new Long(value);
			returning = categoryRepository.byId(id);
		}
		return returning;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
					Category category = (Category) value;
					return category.getId().toString();
		}
		return "";
	}

}
