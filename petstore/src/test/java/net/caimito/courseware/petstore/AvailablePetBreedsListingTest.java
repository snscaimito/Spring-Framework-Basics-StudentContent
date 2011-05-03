package net.caimito.courseware.petstore;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * As visitor 
 * I want to see all the pet breeds available
 * so that I can narrow down my search for a new pet
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"availablePetBreedsListingTest.xml"})
@DirtiesContext
public class AvailablePetBreedsListingTest {

	@Autowired
	private PetStore store ;
	
	@Test
	public void listAvailablePetBreeds() {
		Collection<String> breeds = store.getAvailablePetBreeds() ;
		assertNotNull("Got a null reference back", breeds) ;
		assertFalse("No pet breeds where found", breeds.isEmpty()) ;
	}

}
