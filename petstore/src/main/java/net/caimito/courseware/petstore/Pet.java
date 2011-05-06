package net.caimito.courseware.petstore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = Pet.TABLE_NAME)
public class Pet {

	public static final String TABLE_NAME = "pets";

	@Id
	@GeneratedValue
	private Long id;

	private String petName;
	private String petBreed;
	private double petPrice;
	
	@OneToOne
	private Customer customer ;

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getPetBreed() {
		return petBreed;
	}

	public void setPetBreed(String petBreed) {
		this.petBreed = petBreed;
	}

	public double getPetPrice() {
		return petPrice;
	}

	public void setPetPrice(double petPrice) {
		this.petPrice = petPrice;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer ;
	}

}
