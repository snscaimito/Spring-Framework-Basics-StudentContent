package net.caimito.courseware.petstore;

import java.util.Collection;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PetStore extends HibernateDaoSupport {

	public Collection<Pet> getAvailablePets() {
		return getHibernateTemplate().find("from Pet") ;
	}

}
