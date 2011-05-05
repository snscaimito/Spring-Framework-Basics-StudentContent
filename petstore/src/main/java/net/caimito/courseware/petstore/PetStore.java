package net.caimito.courseware.petstore;

import java.util.Collection;

import javax.swing.RepaintManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PetStore {

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

}
