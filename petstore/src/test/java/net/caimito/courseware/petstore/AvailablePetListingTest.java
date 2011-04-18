package net.caimito.courseware.petstore;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * As visitor 
 * I want to see a listing of all available pets 
 * so that I can pick one to buy
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"availablePetsListingTest.xml"})
@DirtiesContext
public class AvailablePetListingTest {

	@Autowired
	private PetStore store ;
	
	@Test
	public void listAvailablePets() {
		Collection<Pet> pets = store.getAvailablePets() ;
		assertNotNull("Got a null reference back", pets) ;
		assertFalse("No pets where found", pets.isEmpty()) ;
	}
}
