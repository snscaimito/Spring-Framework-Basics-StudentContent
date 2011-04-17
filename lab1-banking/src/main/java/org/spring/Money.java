package org.spring;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Money {
	private double amount ;

	public Money(double amount) {
		this.amount = amount ;
	}

	public Money substract(Money amount) {
		return new Money(this.amount - amount.getAmount()) ;
	}

	public double getAmount() {
		return amount;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this) ;
	}
	
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj) ;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this) ;
	}
}
