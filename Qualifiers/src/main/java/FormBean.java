import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class FormBean {

	@Inject @Urgent //@Default to use 'MessageEmail'
	private Messenger messenger;
	
	private String text;
	
	public void send(){
		System.out.println("passei aqui no formBean");
		messenger.sendMessage(this.text);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
