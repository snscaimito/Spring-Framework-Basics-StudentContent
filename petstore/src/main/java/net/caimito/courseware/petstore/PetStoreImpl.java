package net.caimito.courseware.petstore;

import java.util.Calendar;
import java.util.Collection;

public class PetStoreImpl implements PetStore {

	private PetRepository petRepository ;
	
	public Collection<Pet> getAvailablePets() {
		return petRepository.findAvailablePets() ;
	}

	public Collection<String> getAvailablePetBreeds() {
		return petRepository.findAvailablePetBreeds() ;
	}

	public Collection<String> getAvailablePetBreedsSorted(SortOrder sortOrder) {
		return petRepository.findAvailablePetBreedsSorted(sortOrder) ;
	}

	public void setPetRepository(PetRepository petRepository) {
		this.petRepository = petRepository ;
	}

	public void addPet(Pet pet) {
		petRepository.store(pet) ;
	}

	public Pet findPet(Long id) {
		return petRepository.findPet(id) ;
	}

	public void updatePet(Pet pet) {
		petRepository.updatePet(pet) ;
	}

	public Pet findPetByName(String petName) {
		return petRepository.findPetByName(petName);
	}

	public Collection<Pet> findPetsScheduledForPickup(Calendar today) {
		// TODO Auto-generated method stub
		return null;
	}

}
