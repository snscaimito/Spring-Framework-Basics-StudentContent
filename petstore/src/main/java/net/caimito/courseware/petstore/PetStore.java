package net.caimito.courseware.petstore;

import java.util.Calendar;
import java.util.Collection;

public interface PetStore {

	public Collection<Pet> getAvailablePets();

	public Collection<String> getAvailablePetBreeds();

	public Collection<String> getAvailablePetBreedsSorted(
			SortOrder sortOrder);

	public void addPet(Pet pet);

	public Pet findPet(Long id);
	
	public Pet findPetByName(String petName) ;

	public void updatePet(Pet pet);

	public Collection<Pet> findPetsScheduledForPickup(Calendar today);

}