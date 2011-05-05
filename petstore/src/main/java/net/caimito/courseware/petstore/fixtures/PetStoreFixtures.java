package net.caimito.courseware.petstore.fixtures;

import net.caimito.courseware.petstore.Pet;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PetStoreFixtures extends HibernateDaoSupport {
	
	private static Pet germanShepherd ;
	private static Pet rottweiler ;
	private static Pet whiteRabbit ;
	
	static {
		germanShepherd = new Pet() ;
		germanShepherd.setPetName("Harro") ;
		germanShepherd.setPetBreed("German Shepherd") ;
		germanShepherd.setPetPrice(650.00) ;
		
		rottweiler = new Pet() ;
		rottweiler.setPetName("Big Boy") ;
		rottweiler.setPetBreed("Rottweiler") ;
		rottweiler.setPetPrice(475.00) ;

		whiteRabbit = new Pet() ;
		whiteRabbit.setPetName("Cutie") ;
		whiteRabbit.setPetBreed("White Rabbit") ;
		whiteRabbit.setPetPrice(175.00) ;
	}
	
	public void storePetsInventory() {
		getHibernateTemplate().save(germanShepherd) ;
		getHibernateTemplate().save(rottweiler) ;
	}

	public static Pet getGermanShepherd() {
		return germanShepherd;
	}

	public static Pet getWhiteRabbit() {
		return whiteRabbit;
	}

}
