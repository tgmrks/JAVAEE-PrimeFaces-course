import javax.inject.Named;

@Named
public class FormBean {

	public String getData(){
		return "I use @Named, thus, the name of the class is the name of the bean :)";
	}

}