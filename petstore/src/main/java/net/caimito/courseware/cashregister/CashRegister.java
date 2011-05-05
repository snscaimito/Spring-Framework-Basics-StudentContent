package net.caimito.courseware.cashregister;

public interface CashRegister {
	
	public void sell(String petName, double petPrice) ;

	public double getTotalSale() ;

	public double getReturnMoney() ;

	public void pay(double payment) ;
	
}