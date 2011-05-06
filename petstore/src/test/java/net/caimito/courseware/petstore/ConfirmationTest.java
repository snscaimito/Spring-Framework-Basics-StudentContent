package net.caimito.courseware.petstore;

import static org.easymock.classextension.EasyMock.* ;
import org.junit.Test;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class ConfirmationTest {

	@Test
	public void sendConfirmation() {
		Pet pet = new Pet() ;
		pet.setPetName("Harro") ;
		
		MailSender mailSender = createMock(MailSender.class) ;
		mailSender.send((SimpleMailMessage)anyObject()) ;
		replay(mailSender) ;
		
		Customer customer = new Customer("John Doe", "john.doe@somewhere.org") ;
		ShoppingCart cart = new SimpleShoppingCart() ;
		((SimpleShoppingCart)cart).setTemplateMessage(new SimpleMailMessage()) ;
		((SimpleShoppingCart)cart).setMailSender(mailSender) ;
		cart.addPet(pet) ;
		
		cart.checkout(customer) ;
		
		verify(mailSender) ;
	}

	@Test(expected=PetStoreException.class)
	public void failTosendConfirmation() {
		Pet pet = new Pet() ;
		
		MailSender mailSender = createMock(MailSender.class) ;
		mailSender.send((SimpleMailMessage)anyObject()) ;
		expectLastCall().andThrow(new MailSendException("Simulated failure")) ;
		replay(mailSender) ;
		
		Customer customer = new Customer("John Doe", "john.doe@somewhere.org") ;
		ShoppingCart cart = new SimpleShoppingCart() ;
		((SimpleShoppingCart)cart).setTemplateMessage(new SimpleMailMessage()) ;
		((SimpleShoppingCart)cart).setMailSender(mailSender) ;
		cart.addPet(pet) ;
		
		cart.checkout(customer) ;
	}

}
