package javaee.ejb.beans;

import java.util.List;
import java.util.Optional;

import javax.ejb.Local;

import javaee.domain.Property;

@Local
public interface PropertyBeanLocal {
	
	public void create(Property property);

	public Optional<Property> read(String property);
	
	public void update(Property property);
	
	public void delete(String property);
	
	public List<Property> list(String search);
}
