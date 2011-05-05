package net.caimito.courseware.cashregister;

import java.util.HashMap;
import java.util.Map;

public class InventoryAwareCashRegister implements CashRegister {

	private Map<String, Double> pets = new HashMap<String, Double>() ;
	private double cashInRegister = 0.0 ;
	
	private InventoryAgent inventoryAgent ;
	
	public void sell(String petName, double petPrice) {
		inventoryAgent.inquireAvailability(petName) ;
		
		try {
			Thread.sleep(1000) ; // TODO this can be improved
		} catch (InterruptedException e) {
		}
		
		if (inventoryAgent.isAvailable(petName)) {
			pets.put(petName, petPrice) ;
		} else
			throw new InventoryException("Pet " + petName + " is not available") ;
	}

	public double getTotalSale() {
		double total = 0.0 ;
		
		for (Double price : pets.values())
			total += price ;
		
		return total ;
	}

	public double getReturnMoney() {
		return cashInRegister - getTotalSale() ;
	}

	public void pay(double payment) {
		cashInRegister = payment ;
	}
	
	public void setInventoryAgent(InventoryAgent inventoryAgent) {
		this.inventoryAgent = inventoryAgent ;
	}

}
