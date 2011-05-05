package net.caimito.courseware.cashregister;

import static org.junit.Assert.*;
import net.caimito.courseware.petstore.Pet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class InventoryAgentTest {

	@Autowired
	private InventoryAgent agent ;
	
	@Autowired
	private FakePetStore petStore ;
	
	@Test
	public void isAvailable() throws InterruptedException {
		Pet harro = new Pet() ;
		harro.setPetName("Harro") ;
		petStore.addPet(harro) ;
		
		agent.inquireAvailability(harro.getPetName()) ;
		
		Thread.sleep(1000) ;
		
		assertTrue(agent.isAvailable(harro.getPetName())) ;
	}
	
}
