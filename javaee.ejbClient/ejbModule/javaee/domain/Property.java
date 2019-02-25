package javaee.domain;

import java.io.Serializable;

public class Property implements Serializable {

	private static final long serialVersionUID = 1L;
	private String property;
	private String value;
	
	public Property(String property, String value) {
		this.property = property;
		this.value = value;
	}

	public String getProperty() {
		return property;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Property [property=" + property + ", value=" + value + "]";
	}

}
