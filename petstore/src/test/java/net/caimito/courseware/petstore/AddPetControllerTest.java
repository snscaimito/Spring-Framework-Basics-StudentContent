package net.caimito.courseware.petstore;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

public class AddPetControllerTest {

	@Test
	public void setupForm() {
		AddPetController addPetController = new AddPetController() ;
		
		Model model = new ExtendedModelMap() ;
		String result = addPetController.setupForm(model) ;
		assertEquals("addPet", result) ;
		assertTrue(model.containsAttribute("pet")) ;
	}
}
