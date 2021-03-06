package net.caimito.courseware.cashregister;

import static org.junit.Assert.*;
import static org.easymock.classextension.EasyMock.*;

import java.util.Collection;

import net.caimito.courseware.petstore.fixtures.PetStoreFixtures;

import org.junit.Test;

public class InventoryAwareCashRegisterTest {

	@Test
	public void sellPet() {
		InventoryAgent inventoryAgent = createMock(InventoryAgent.class) ;
		inventoryAgent.inquireAvailability((String)anyObject()) ;
		expectLastCall().anyTimes() ;
		
		expect(inventoryAgent.isAvailable((String)anyObject())).andReturn(true).anyTimes() ;
		
		inventoryAgent.retrieveFromShelter((String)anyObject()) ;
		expectLastCall().anyTimes() ;
		
		inventoryAgent.removeFromInventory((Collection<String>)anyObject()) ;
		expectLastCall().anyTimes() ;
		
		replay(inventoryAgent) ;
		
		CashRegister cashRegister = new InventoryAwareCashRegister() ;
		((InventoryAwareCashRegister)cashRegister).setInventoryAgent(inventoryAgent) ;
		
		cashRegister.sell(PetStoreFixtures.getGermanShepherd().getPetName(), PetStoreFixtures.getGermanShepherd().getPetPrice()) ;
		cashRegister.sell(PetStoreFixtures.getWhiteRabbit().getPetName(), PetStoreFixtures.getWhiteRabbit().getPetPrice()) ;
		
		double totalSale = cashRegister.getTotalSale() ;
		assertEquals(PetStoreFixtures.getGermanShepherd().getPetPrice() + PetStoreFixtures.getWhiteRabbit().getPetPrice(), totalSale, 0.0) ;
		
		cashRegister.pay(700.0) ;
		
		double returnMoney = cashRegister.getReturnMoney() ;
		assertEquals(returnMoney, 700.0 - (PetStoreFixtures.getGermanShepherd().getPetPrice() + PetStoreFixtures.getWhiteRabbit().getPetPrice()), 0.0) ;
		
		verify(inventoryAgent) ;
	}
}
