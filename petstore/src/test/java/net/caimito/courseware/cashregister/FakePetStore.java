package net.caimito.courseware.cashregister;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import net.caimito.courseware.petstore.Pet;
import net.caimito.courseware.petstore.PetStore;
import net.caimito.courseware.petstore.SortOrder;

public class FakePetStore implements PetStore {

	private Map<String, Pet> pets = new HashMap<String, Pet>() ;
	
	public Collection<Pet> getAvailablePets() {
		return pets.values();
	}

	public Collection<String> getAvailablePetBreeds() {

		return null;
	}

	public Collection<String> getAvailablePetBreedsSorted(SortOrder sortOrder) {
		return null;
	}

	public void addPet(Pet pet) {
		pets.put(pet.getPetName(), pet) ;
	}

	public Pet findPet(Long id) {
		return null;
	}
	
	public Pet findPetByName(String petName) {
		return pets.get(petName) ;
	}

	public void updatePet(Pet pet) {

	}

}
