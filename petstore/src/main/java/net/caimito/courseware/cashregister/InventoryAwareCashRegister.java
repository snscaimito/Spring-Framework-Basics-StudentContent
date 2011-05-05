package net.caimito.courseware.cashregister;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

public class InventoryAwareCashRegister implements CashRegister, InitializingBean {

	private static Logger logger = LoggerFactory.getLogger(InventoryAwareCashRegister.class) ;
	private Map<String, Double> pets = new HashMap<String, Double>() ;
	private double cashInRegister = 0.0 ;
	
	private InventoryAgent inventoryAgent ;
	
	public void afterPropertiesSet() throws Exception {
		if (inventoryAgent == null)
			logger.error("Need an instance of Inventory Agent") ;
	}

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
