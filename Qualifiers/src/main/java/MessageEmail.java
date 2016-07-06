import javax.enterprise.inject.Default;

@Default
public class MessageEmail implements Messenger{

	@Override
	public void sendMessage(String msg) {
		System.out.println("E-mail: " + msg);
		
	}

}
