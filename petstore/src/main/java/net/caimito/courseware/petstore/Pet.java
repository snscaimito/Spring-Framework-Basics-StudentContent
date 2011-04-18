package net.caimito.courseware.petstore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name=Pet.TABLE_NAME)
public class Pet {
	
	public static final String TABLE_NAME = "pets" ;

	@Id
	@GeneratedValue
	private Long id ;
}
