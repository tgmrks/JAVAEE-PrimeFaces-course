import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class FormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date date;

	public void register() {
		System.out.println("Selected Date: " + this.date);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Done!"));
	}

	public Date getDateNow(){
		return new Date();
	}
	
	public Date getDatePast(){
		Date today = new Date();
		return new Date(today.getTime() - (1000 * 60 * 60 * 48));
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}