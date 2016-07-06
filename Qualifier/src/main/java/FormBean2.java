import javax.inject.Named;

@Named("renamedBean")
public class FormBean2 {

	public String getData(){
		return "I was renamend, I can be called with a different name other than my class name :D";
	}

}