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

	private String name;
	private String about;

	public void save() {
		System.out.println("About: " + this.about);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Saved!"));
	}
	
	public List<String> completeText(String consulta) {
		List<String> resultados = new ArrayList<String>();
		
		if (consulta.startsWith("tes")) {
			resultados.add("test");
			resultados.add("testing");
			resultados.add("testing auto");
			resultados.add("testing autocomplete");
		}
		
		return resultados;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

}