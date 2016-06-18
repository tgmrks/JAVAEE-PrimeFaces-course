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
	
	public static final String ASIA = "Asia";
	public static final String AMERICA = "America";
	public static final String EUROPE = "Europe";

	private String profession;
	
	private String land;
	private List<String> lands = new ArrayList<>();
	private String country;
	private List<String> countries = new ArrayList<>();
	
	public FormBean(){
		lands.add(ASIA);
		lands.add(EUROPE);
		lands.add(AMERICA);
	}
	
	public void register() {
		System.out.println("Profession: " + this.profession);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Done! You Selected: " + this.profession));
	}
	
	public void register2() {
		System.out.println("Continent: " + this.land);
		System.out.println("Country: " + this.country);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Done! You selected: " + this.country));
	}
	
	public void loadCountry(){
		countries.clear();
		
		if(ASIA.equals(land)){
			countries.add("China");
			countries.add("Japan");
			countries.add("South Corea");
		}
		else if(AMERICA.equals(land)){
			countries.add("United States of America");
			countries.add("Canada");
			countries.add("Mexico");
			countries.add("Brazil");
			countries.add("Argentina");
		}
		else if(EUROPE.equals(land)){
			countries.add("France");
			countries.add("German");
			countries.add("England");
			countries.add("Italy");
			countries.add("Portugal");
			countries.add("Spain");
		}
	}
	
	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	public List<String> getLands() {
		return lands;
	}

	public void setLands(List<String> lands) {
		this.lands = lands;
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