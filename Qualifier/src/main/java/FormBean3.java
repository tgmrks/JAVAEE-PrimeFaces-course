import javax.inject.Inject;
import javax.inject.Named;

@Named("injectingBean")
public class FormBean3 {
	
	@Inject
	private InjectionExample ie;
	
	public String getData(){
		return "I'm an example of Injection, here is an injected calculation: 2 x 2.7 = " + ie.calc(2, 2.7);
	}

}