package net.caimito.courseware.cashregister;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class JmsInventoryAgent implements InventoryAgent {

	private Logger logger = LoggerFactory.getLogger(JmsInventoryAgent.class) ;
	private ConnectionFactory connectionFactory ;
	private Queue requestQueue ;
	private JmsTemplate jmsTemplate ;
	private List<String> availablePets = new ArrayList<String>() ;
	
	public void setConnectionFactory(ConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
		jmsTemplate = new JmsTemplate(connectionFactory) ;
	}
	
	public void setRequestQueue(Queue requestQueue) {
		this.requestQueue = requestQueue;
	}
	
	public void inquireAvailability(final String petName) {
		jmsTemplate.send(requestQueue, new MessageCreator() {
			
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(String.format("Send availability of pet: %s", petName)) ;
			}
		}) ;
		logger.info(String.format("Sent availability request for pet '%s'", petName)) ;
	}

	public boolean isAvailable(String petName) {
		return availablePets.contains(petName);
	}

	public void retrieveFromShelter(String petName) {
		// TODO Auto-generated method stub

	}

	public void removeFromInventory(Collection<String> petNames) {
		// TODO Auto-generated method stub

	}

	public void setAvailable(String petName) {
		logger.info(String.format("Setting availability of %s", petName)) ;
		availablePets.add(petName) ;
	}

}
