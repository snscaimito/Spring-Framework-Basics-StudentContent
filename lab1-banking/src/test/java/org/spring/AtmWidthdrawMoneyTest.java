package org.spring;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * As ATM user I want to withdraw money from my account
 */
public class AtmWidthdrawMoneyTest {

	@Test
	public void withdrawFromAccount() {
		AtmUser atmUser = new AtmUser() ;
		Account account = new Account(new Money(100)) ;
		Atm atm = new Atm() ;
		
		Money previousAccountBalance = account.getBalance() ;
		Money amountRequested = new Money(20) ;
		
		atm.withdraw(atmUser, account, amountRequested) ;
		
		assertEquals(previousAccountBalance.substract(amountRequested), account.getBalance()) ;
	}
	
	@Test(expected=AtmException.class)
	public void requestMoreThanBalanceIs() {
		AtmUser atmUser = new AtmUser() ;
		Account account = new Account(new Money(100)) ;
		Atm atm = new Atm() ;
		
		Money previousAccountBalance = account.getBalance() ;
		Money amountRequested = new Money(200) ;
		
		atm.withdraw(atmUser, account, amountRequested) ;
	}
}
