package org.spring;

public class Atm {

	public void withdraw(AtmUser atmUser, Account account,
			Money amountRequested) {
		if (account.getBalance().getAmount() < amountRequested.getAmount())
			throw new AtmException("Amount requested exceeds available balance.") ;
		
		account.withdraw(amountRequested) ;
	}

}
