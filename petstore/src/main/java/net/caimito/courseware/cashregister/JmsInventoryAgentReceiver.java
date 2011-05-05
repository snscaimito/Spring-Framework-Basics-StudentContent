package net.caimito.courseware.cashregister;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import net.caimito.courseware.petstore.PetStore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class JmsInventoryAgentReceiver implements MessageListener {

	private static Logger logger = LoggerFactory.getLogger(JmsInventoryAgentReceiver.class) ;
	private PetStore petStore ;
	private ConnectionFactory connectionFactory ;
	private Queue answerQueue ;
	private InventoryAgent inventoryAgent ;
	private JmsTemplate jmsTemplate ;
	
	public void setPetStore(PetStore petStore) {
		this.petStore = petStore;
	}
	
	public void setConnectionFactory(ConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
		jmsTemplate = new JmsTemplate(connectionFactory) ;
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
		logger.info("Processing answer") ;
		logger.info("Answer was: " + messageContent) ;
		
		inventoryAgent.setAvailable("Harro") ;
	}

	private void processAvailabilityRequest(String messageContent) {
		logger.info(String.format("Received request: %s", messageContent)) ;
		logger.info("Faking availability") ;
		
		jmsTemplate.send(answerQueue, new MessageCreator() {
			
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("Pet is available: <missing pet name>") ;
			}
		}) ;
	}

}
