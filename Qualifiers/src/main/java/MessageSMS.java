
@Urgent
public class MessageSMS implements Messenger{

	@Override
	public void sendMessage(String msg) {
		System.out.println("SMS: " + msg);
		
	}

}
