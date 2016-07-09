import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.example.model.Address;
import com.example.model.Client;
import com.example.model.PersonType;
import com.sun.faces.util.Cache.Factory;


public class Teste {

	public static void main(String[] args){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OrderOU");//defined in 'persistence.xml'
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		Client client = new Client();
		client.setName("John Doe  II");
		client.setEmail("john.doe@test.com");
		client.setDocument("123.456.789-12");
		client.setType(PersonType.NATURAL);
		
		Address address = new Address();
		address.setAddress("1st Street");
		address.setNum("1024");
		address.setCity("Campinas");
		address.setState("SP");
		address.setZip("15000-000");
		address.setClient(client);
		
		client.getAddresses().add(address);
		
		manager.persist(client);
		
		trx.commit();
	}
}
