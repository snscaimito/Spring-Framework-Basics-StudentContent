package net.caimito.courseware.petstore;

import static org.easymock.classextension.EasyMock.* ;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import net.caimito.courseware.petstore.fixtures.PetStoreFixtures;

import org.junit.Test;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class ReminderTest {
	
	private static Calendar today = Calendar.getInstance() ;

	@Test
	public void sendPickupReminder() {
		Customer customer = new Customer("John Doe", "john.doe@somewhere.org") ;
		
		Collection<Pet> petsScheduledForToday = new ArrayList<Pet>() ;
		Pet germanShepherd = PetStoreFixtures.getGermanShepherd() ;
		germanShepherd.setCustomer(customer) ;
		petsScheduledForToday.add(germanShepherd) ;
		
		DateTimeHelper dateTimeHelper = createMock(DateTimeHelper.class) ;
		expect(dateTimeHelper.getToday()).andReturn(getSimulatedToday()) ;
		
		PetStore petStore = createMock(PetStore.class) ;
		expect(petStore.findPetsScheduledForPickup(getSimulatedToday())).andReturn(petsScheduledForToday) ;
		
		replay(dateTimeHelper) ;
		replay(petStore) ;
		
		MailSender mailSender = createMock(MailSender.class) ;
		mailSender.send((SimpleMailMessage)anyObject()) ;
		replay(mailSender) ;
		
		ReminderService rs = new ReminderServiceImpl() ;
		((ReminderServiceImpl)rs).setDateTimeHelper(dateTimeHelper) ;
		((ReminderServiceImpl)rs).setPetStore(petStore) ;
		((ReminderServiceImpl)rs).setMailSender(mailSender) ;
		((ReminderServiceImpl)rs).setTemplateMessage(new SimpleMailMessage()) ;
		
		rs.sendReminder() ; // this will be called by the scheduler. Needs to be a method without arguments
		
		verify(dateTimeHelper) ;
		verify(petStore) ;
		verify(mailSender) ;
	}

	private Calendar getSimulatedToday() {
		return today;
	}
}
