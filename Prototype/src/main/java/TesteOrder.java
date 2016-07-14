import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.example.model.Address;
import com.example.model.Client;
import com.example.model.DeliverAddress;
import com.example.model.Order;
import com.example.model.OrderItem;
import com.example.model.PaymentForm;
import com.example.model.PersonType;
import com.example.model.Product;
import com.example.model.StatusOrder;
import com.example.model.User;
import com.sun.faces.util.Cache.Factory;


public class TesteOrder {

	public static void main(String[] args){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OrderOU");//defined in 'persistence.xml'
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		

		Client client = manager.find(Client.class, 0L);
		Product product = manager.find(Product.class, 0L);
		User seller = manager.find(User.class, 0L);
		
		DeliverAddress deliverAdd = new DeliverAddress();
		deliverAdd.setAddress("Market Street");
		deliverAdd.setNum("1000");
		deliverAdd.setCity("Uberlândia");
		deliverAdd.setState("MG");
		deliverAdd.setZip("38400-123");
		
		Order order = new Order();
		order.setClient(client);
		order.setCreateDate(new Date());
		order.setDeliveredDate(new Date());
		order.setPaymentForm(PaymentForm.CREDIT_CARD);
		order.setNotes("Open up to 18h");
		order.setStatus(StatusOrder.BUDGET);
		order.setDescountValue(0.0);
		order.setShipimentValue(0.0);
		order.setTotalValue(0.0);
		order.setSeller(seller);
		order.setDeliverAddress(deliverAdd);
		
		OrderItem item = new OrderItem();
		item.setProduct(product);
		item.setQtd(10);
		item.setUnitValue(2.32);
		item.setOrder(order);
		
		order.getItens().add(item);
		
		
		manager.persist(order);
		
		trx.commit();
	}
}
