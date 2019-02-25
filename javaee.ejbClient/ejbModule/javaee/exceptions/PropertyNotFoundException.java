package javaee.exceptions;

public class PropertyNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public PropertyNotFoundException() {
		super("Property not found");
	}

}
