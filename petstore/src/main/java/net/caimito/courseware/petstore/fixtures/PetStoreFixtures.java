package net.caimito.courseware.petstore.fixtures;

import net.caimito.courseware.petstore.Pet;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PetStoreFixtures extends HibernateDaoSupport {
	
	public void storePetsInventory() {
		Pet germanShepherd = new Pet() ;
		germanShepherd.setPetName("Harro") ;
		germanShepherd.setPetBreed("German Shepherd") ;
		germanShepherd.setPetPrice(650.00) ;
		
		getHibernateTemplate().save(germanShepherd) ;

		Pet rottweiler = new Pet() ;
		rottweiler.setPetName("Big Boy") ;
		rottweiler.setPetBreed("Rottweiler") ;
		rottweiler.setPetPrice(475.00) ;
		
		getHibernateTemplate().save(rottweiler) ;
	}

}
