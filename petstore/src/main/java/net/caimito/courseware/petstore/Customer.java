package net.caimito.courseware.petstore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {

	public static final String TABLE_NAME = "customers" ;
	
	@Id
	@GeneratedValue
	private Long id ;
	
	private String customerName ;
	private String customerEmail ;
	
	public Customer() {
	}
	
	public Customer(String customerName, String customerEmail) {
		this.customerEmail = customerEmail ;
		this.customerName = customerName ;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}


}
