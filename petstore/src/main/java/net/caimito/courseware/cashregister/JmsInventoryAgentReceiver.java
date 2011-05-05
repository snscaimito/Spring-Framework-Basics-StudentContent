package net.caimito.courseware.cashregister;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.TextMessage;

import net.caimito.courseware.petstore.PetStore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JmsInventoryAgentReceiver implements MessageListener {

	private static Logger logger = LoggerFactory.getLogger(JmsInventoryAgentReceiver.class) ;
	private PetStore petStore ;
	private ConnectionFactory connectionFactory ;
	private Queue answerQueue ;
	private InventoryAgent inventoryAgent ;
	
	public void setPetStore(PetStore petStore) {
		this.petStore = petStore;
	}
	
	public void setConnectionFactory(ConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}
	
	public void setAnswerQueue(Queue answerQueue) {
		this.answerQueue = answerQueue;
	}
	
	public void setInventoryAgent(InventoryAgent inventoryAgent) {
		this.inventoryAgent = inventoryAgent;
	}
	
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message ;
			
			String messageContent = "" ;
			try {
				messageContent = textMessage.getText() ;
			} catch (JMSException e) {
				logger.error("JMS Exception", e) ;
			}
			
			if (messageContent.contains("Send availability of pet:"))
				processAvailabilityRequest(messageContent) ;
			else if (messageContent.contains("Pet is available:"))
				processAvailabilityAnswer(messageContent) ;
		}
	}

	private void processAvailabilityAnswer(String messageContent) {
		// TODO Auto-generated method stub
		
	}

	private void processAvailabilityRequest(String messageContent) {
		// TODO Auto-generated method stub
		
	}

}
