package org.spring;

public class Account {

	private Money balance ;
	
	public Account(Money initialBalance) {
		this.balance = initialBalance ;
	}

	public Money getBalance() {
		return balance;
	}

	public void withdraw(Money amountRequested) {
		balance = balance.substract(amountRequested) ;
	}

}
