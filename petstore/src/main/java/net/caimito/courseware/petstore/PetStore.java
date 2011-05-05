package net.caimito.courseware.petstore;

import java.util.Collection;

public interface PetStore {

	public abstract Collection<Pet> getAvailablePets();

	public abstract Collection<String> getAvailablePetBreeds();

	public abstract Collection<String> getAvailablePetBreedsSorted(
			SortOrder sortOrder);

	public abstract void setPetRepository(PetRepository petRepository);

	public abstract void addPet(Pet pet);

	public abstract Pet findPet(Long id);

	public abstract void updatePet(Pet pet);

}