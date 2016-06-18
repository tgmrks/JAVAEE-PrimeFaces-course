import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class FormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String profession;
	
	public void register() {
		System.out.println("Profession: " + this.profession);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Done!"));
	}
	
	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

}