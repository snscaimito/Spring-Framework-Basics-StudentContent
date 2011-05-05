package net.caimito.courseware.petstore;

import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class PetStoreControllerTest {

	@Test
	public void sortBreedsAscending() {
		Collection<String> petBreeds = Arrays.asList("German Shepherd", "Rottweiler") ;
		
		PetRepository petRepository = createMock(PetRepository.class) ;
		expect(petRepository.findAvailablePetBreedsSorted(SortOrder.ASCENDING)).andReturn(petBreeds) ;
		replay(petRepository) ;
		
		PetStore petStore = new PetStoreImpl() ;
		petStore.setPetRepository(petRepository) ;
		
		PetStoreController controller = new PetStoreController() ;
		controller.setPetStore(petStore) ;
		
		ModelAndView mav = controller.availableBreedsSorted("ASC") ;
		assertNotNull(mav) ;
		Collection<String> breeds = (Collection<String>) mav.getModelMap().get("breeds") ;
		assertNotNull(breeds) ;
		assertEquals("German Shepherd", breeds.toArray(new String[0])[0]) ;
		assertEquals("Rottweiler", breeds.toArray(new String[0])[1]) ;
	}

	@Test
	public void sortBreedsDecending() {
		Collection<String> petBreeds = Arrays.asList("Rottweiler", "German Shepherd") ;
		
		PetRepository petRepository = createMock(PetRepository.class) ;
		expect(petRepository.findAvailablePetBreedsSorted(SortOrder.DECENDING)).andReturn(petBreeds) ;
		replay(petRepository) ;
		
		PetStore petStore = new PetStoreImpl() ;
		petStore.setPetRepository(petRepository) ;
		
		PetStoreController controller = new PetStoreController() ;
		controller.setPetStore(petStore) ;
		
		ModelAndView mav = controller.availableBreedsSorted("DESC") ;
		assertNotNull(mav) ;
		Collection<String> breeds = (Collection<String>) mav.getModelMap().get("breeds") ;
		assertNotNull(breeds) ;
		assertEquals("Rottweiler", breeds.toArray(new String[0])[0]) ;
		assertEquals("German Shepherd", breeds.toArray(new String[0])[1]) ;
	}
}
