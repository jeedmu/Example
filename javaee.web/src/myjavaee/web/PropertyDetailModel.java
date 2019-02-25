package myjavaee.web;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class PropertyDetailModel implements Serializable {

	private static final long serialVersionUID = 1L;
	private String property;
	private String value;

	public PropertyDetailModel() {
	}
	
	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
