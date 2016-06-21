import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class FormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String country;
	private List<String> countries = new ArrayList<>();
	
	public FormBean(){
		countries.add("Argentina");
		countries.add("Armenia");
		countries.add("Australia");
		countries.add("Austria");
		countries.add("Belgium");
		countries.add("Brazil");
		countries.add("Canada");
		countries.add("Chile");
		countries.add("China");
		countries.add("Costa Rica");
		countries.add("France");
		countries.add("Germany");
		countries.add("Italy");
		countries.add("Ukraine");
		countries.add("United Kingdom");
		countries.add("United State of America");
		countries.add("Uruguay");
		
	}
	
	public void register() {
		
		System.out.println("Country: " + country);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Done!"));
	}
	
	public List<String> suggestion(String text){
		List<String> list = new ArrayList<>();
		for(String country : this.countries){
			if(country.toLowerCase().startsWith(text.toLowerCase())){
				list.add(country);
			}
		}
		return list;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<String> getCountries() {
		return countries;
	}

	public void setCountries(List<String> countries) {
		this.countries = countries;
	}
	
}