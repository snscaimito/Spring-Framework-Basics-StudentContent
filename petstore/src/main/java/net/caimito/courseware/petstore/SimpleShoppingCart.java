package net.caimito.courseware.petstore;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SimpleShoppingCart implements ShoppingCart {

	private static Logger logger = LoggerFactory.getLogger(SimpleShoppingCart.class) ;
	private SimpleMailMessage templateMessage ;
	private Pet pet ;
	private MailSender mailSender;
	
	public void setTemplateMessage(SimpleMailMessage templateMessage) {
		this.templateMessage = templateMessage;
	}
	
	public void checkout(Customer customer) {
		
		// do other things for the checkout process
		
		sendConfirmation(customer) ;
	}

	private void sendConfirmation(Customer customer) {
		String messagePartOne = "Dear " + customer.getCustomerName() + ", thank you for placing your order. \r\n" ;
		String messagePartTwo = String.format("The pet %s will be waiting for you to pick it up", pet.getPetName()) ;
		
		SimpleMailMessage msg = new SimpleMailMessage(templateMessage) ;
		msg.setTo(customer.getCustomerEmail()) ;
		msg.setText(messagePartOne + "\r\n" + messagePartTwo) ;
		
		try {
			mailSender.send(msg) ;
		} catch (MailException e) {
			throw new PetStoreException("Cannot email to " + customer.getCustomerEmail(), e) ;
		}
	}

	public void addPet(Pet pet) {
		this.pet = pet ;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender ;
	}

}
