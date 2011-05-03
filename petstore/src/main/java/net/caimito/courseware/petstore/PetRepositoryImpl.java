package net.caimito.courseware.petstore;

import java.util.Collection;

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

}
