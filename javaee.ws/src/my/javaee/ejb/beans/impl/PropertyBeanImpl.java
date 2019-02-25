package my.javaee.ejb.beans.impl;


import java.util.Optional;

import javax.ejb.EJB;
import javax.jws.WebService;

import javaee.domain.Property;
import javaee.ejb.beans.PropertyBeanLocal;
import my.javaee.ejb.beans.PropertyBean;

@WebService(serviceName = "PropertyBeanService", endpointInterface = "my.javaee.ejb.beans.PropertyBean", targetNamespace = "http://beans.ejb.javaee.my/")
public class PropertyBeanImpl implements PropertyBean {
	@EJB private PropertyBeanLocal ejb;
	public boolean create(my.javaee.ejb.beans.Property arg0) {
		Property property = new Property(arg0.getProperty(), arg0.getValue());
		ejb.create(property);
		return true;
	}

	public boolean update(my.javaee.ejb.beans.Property arg0) {
		return false;
	}

	public my.javaee.ejb.beans.Property read(java.lang.String arg0) {
		Optional<Property> optional = ejb.read(arg0);
		my.javaee.ejb.beans.Property property = null;
		if (optional.isPresent()) {
			property = new my.javaee.ejb.beans.Property();
			property.setProperty(optional.get().getProperty());
			property.setValue(optional.get().getValue());
		}
		return property;
	}

	public java.util.List<my.javaee.ejb.beans.Property> list(java.lang.String arg0) {
		return null;
	}

	public boolean delete(java.lang.String arg0) {
		return false;
	}
}