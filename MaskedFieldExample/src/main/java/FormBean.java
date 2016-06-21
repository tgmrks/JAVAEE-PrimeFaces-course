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

	private String phone;
	
	public void register() {
		
		System.out.println("Result: " + phone);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Done!"));
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}