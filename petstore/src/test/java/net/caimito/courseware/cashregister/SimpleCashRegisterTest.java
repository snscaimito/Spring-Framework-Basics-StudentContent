package net.caimito.courseware.cashregister;

import static org.junit.Assert.*;
import net.caimito.courseware.petstore.fixtures.PetStoreFixtures;

import org.junit.Test;

public class SimpleCashRegisterTest {

	@Test
	public void sellPet() {
		SimpleCashRegister cashRegister = new SimpleCashRegister() ;
		
		cashRegister.sell(PetStoreFixtures.getGermanShepherd().getPetName(), PetStoreFixtures.getGermanShepherd().getPetPrice()) ;
		cashRegister.sell(PetStoreFixtures.getWhiteRabbit().getPetName(), PetStoreFixtures.getWhiteRabbit().getPetPrice()) ;
		
		double totalSale = cashRegister.getTotalSale() ;
		assertEquals(PetStoreFixtures.getGermanShepherd().getPetPrice() + PetStoreFixtures.getWhiteRabbit().getPetPrice(), totalSale, 0.0) ;
		
		cashRegister.pay(700.0) ;
		
		double returnMoney = cashRegister.getReturnMoney() ;
		assertEquals(returnMoney, 700.0 - (PetStoreFixtures.getGermanShepherd().getPetPrice() + PetStoreFixtures.getWhiteRabbit().getPetPrice()), 0.0) ;
	}
}
