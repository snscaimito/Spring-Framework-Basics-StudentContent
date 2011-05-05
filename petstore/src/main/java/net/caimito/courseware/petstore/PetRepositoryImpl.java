package net.caimito.courseware.petstore;

import java.util.Collection;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PetRepositoryImpl extends HibernateDaoSupport implements PetRepository {

	public Collection<Pet> findAvailablePets() {
		return getHibernateTemplate().find("from Pet") ;
	}

	public Collection<String> findAvailablePetBreeds() {
		return getHibernateTemplate().find("select p.petBreed from Pet p");
	}

	public Collection<String> findAvailablePetBreedsSorted(SortOrder sortOrder) {
		if (SortOrder.ASCENDING.equals(sortOrder))
			return getHibernateTemplate().find("select p.petBreed from Pet p order by p.petBreed ASC");
		else
			return getHibernateTemplate().find("select p.petBreed from Pet p order by p.petBreed DESC");
	}

	public void store(Pet pet) {
		getHibernateTemplate().save(pet) ;
	}

	public Pet findPet(Long id) {
		return getHibernateTemplate().get(Pet.class, id) ;
	}

	public void updatePet(Pet pet) {
		getHibernateTemplate().saveOrUpdate(pet) ;
	}

	public Pet findPetByName(String petName) {
		List<Pet> pets = getHibernateTemplate().find("from Pet p where p.petName=?", petName) ;
		if (pets.isEmpty())
			return null ;
		else
			return pets.get(0) ;
	}

}
