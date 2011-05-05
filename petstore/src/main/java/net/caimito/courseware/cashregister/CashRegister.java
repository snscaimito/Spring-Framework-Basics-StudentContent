package net.caimito.courseware.cashregister;

import java.util.HashMap;
import java.util.Map;

public class CashRegister {

	private Map<String, Double> pets = new HashMap<String, Double>() ;
	private double cashInRegister = 0.0 ;
	
	public void sell(String petName, double petPrice) {
		pets.put(petName, petPrice) ;
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

}
