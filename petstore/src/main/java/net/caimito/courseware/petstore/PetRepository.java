package net.caimito.courseware.petstore;

import java.util.Collection;

public interface PetRepository {

	public Collection<Pet> findAvailablePets() ;

	public Collection<String> findAvailablePetBreeds() ;

	public Collection<String> findAvailablePetBreedsSorted(SortOrder sortOrder) ;

	public void store(Pet pet);

	public Pet findPet(Long id);

	public void updatePet(Pet pet);

	public Pet findPetByName(String petName);

}
