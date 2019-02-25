package javaee.exceptions;

public class PropertyAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public PropertyAlreadyExistsException() {
		super("Property already exists");
	}

}
