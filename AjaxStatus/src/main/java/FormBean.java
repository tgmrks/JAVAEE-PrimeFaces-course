import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class FormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String login;
	private String name;

	public void checkLogin() {
		FacesMessage msg = null;
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if ("john".equalsIgnoreCase(this.login)) {
			msg = new FacesMessage("Login already in use.");
			msg.setSeverity(FacesMessage.SEVERITY_WARN);
		} else {
			msg = new FacesMessage("Login available.");
		}
		
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void register() {
		System.out.println("Login: " + this.login);
		System.out.println("Name: " + this.name);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Done!"));
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}