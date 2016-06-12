import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class RegisterPersonBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	public void register() {
		System.out.println("Name: " + this.name);;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}