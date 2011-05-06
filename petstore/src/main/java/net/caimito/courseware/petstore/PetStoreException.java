package net.caimito.courseware.petstore;


public class PetStoreException extends RuntimeException {

	private static final long serialVersionUID = 6732218749161693604L;

	public PetStoreException(String message, Throwable cause) {
		super(message, cause) ;
	}

}
