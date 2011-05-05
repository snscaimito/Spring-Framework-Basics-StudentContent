package net.caimito.courseware.cashregister;

import java.util.Collection;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

public class JmsInventoryAgent implements InventoryAgent {

	private ConnectionFactory connectionFactory ;
	private Queue requestQueue ;
	
	public void setConnectionFactory(ConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}
	
	public void setRequestQueue(Queue requestQueue) {
		this.requestQueue = requestQueue;
	}
	
	public void inquireAvailability(String petName) {
		// TODO Auto-generated method stub

	}

	public boolean isAvailable(String petName) {
		// TODO Auto-generated method stub
		return false;
	}

	public void retrieveFromShelter(String petName) {
		// TODO Auto-generated method stub

	}

	public void removeFromInventory(Collection<String> petNames) {
		// TODO Auto-generated method stub

	}

}
