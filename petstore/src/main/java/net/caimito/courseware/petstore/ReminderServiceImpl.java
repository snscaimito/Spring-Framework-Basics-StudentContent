package net.caimito.courseware.petstore;

import java.util.Calendar;
import java.util.Collection;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class ReminderServiceImpl implements ReminderService {

	private PetStore petStore ;
	private DateTimeHelper dateTimeHelper ;
	private MailSender mailSender ;
	private SimpleMailMessage templateMessage ;
	
	public void sendReminder() {
		Calendar today = dateTimeHelper.getToday() ;
		Collection<Pet> petsScheduledForPickup = petStore.findPetsScheduledForPickup(today) ;
		
		for (Pet pet : petsScheduledForPickup)
			sendReminder(pet.getCustomer(), pet) ;
	}

	private void sendReminder(Customer customer, Pet pet) {
		String messagePartOne = "Dear " + customer.getCustomerName() + ", thank you for placing your order. \r\n" ;
		String messagePartTwo = String.format("This is a reminder. The pet %s will be waiting for you to pick it up", pet.getPetName()) ;
		
		SimpleMailMessage msg = new SimpleMailMessage(templateMessage) ;
		msg.setTo(customer.getCustomerEmail()) ;
		msg.setText(messagePartOne + "\r\n" + messagePartTwo) ;
		
		try {
			mailSender.send(msg) ;
		} catch (MailException e) {
			throw new PetStoreException("Cannot email to " + customer.getCustomerEmail(), e) ;
		}	}
	
	public void setDateTimeHelper(DateTimeHelper dateTimeHelper) {
		this.dateTimeHelper = dateTimeHelper;
	}
	
	public void setPetStore(PetStore petStore) {
		this.petStore = petStore;
	}
	
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void setTemplateMessage(SimpleMailMessage templateMessage) {
		this.templateMessage = templateMessage;
	}

}
