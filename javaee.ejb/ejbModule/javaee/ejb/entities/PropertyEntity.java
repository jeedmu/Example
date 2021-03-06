package javaee.ejb.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import javaee.domain.Property;

/**
 * Entity implementation class for Entity: Property
 *
 */
@Entity(name = "property")

@NamedQuery(name = "searchProperties", query = "SELECT p FROM property p  "
		+ "WHERE UPPER(p.property) LIKE :search " 
		+ "OR UPPER(p.value) LIKE :search " 
		+ "ORDER BY p.property")

public class PropertyEntity implements Serializable {

	@Id
	private String property;
	private String value;
	private static final long serialVersionUID = 1L;

	public PropertyEntity() {
		super();
	}

	public PropertyEntity(Property property) {
		this.property = property.getProperty();
		this.value = property.getValue();
	}

	public Property toDomain() {
		return new Property(this.property, this.value);
	}

	public String getProperty() {
		return this.property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "PropertyEntity [property=" + property + ", value=" + value + "]";
	}

}
