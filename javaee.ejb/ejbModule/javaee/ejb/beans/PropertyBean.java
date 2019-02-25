package javaee.ejb.beans;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javaee.domain.Property;
import javaee.ejb.entities.PropertyEntity;
import javaee.exceptions.PropertyAlreadyExistsException;
import javaee.exceptions.PropertyNotFoundException;

/**
 * Session Bean implementation class PropertyBean
 */
@Stateless
public class PropertyBean implements PropertyBeanLocal {
	@PersistenceContext private EntityManager em;

	@Override
	public void create(Property property) {
		Optional<Property> optional = read(property.getProperty());
		if (optional.isPresent()) {
			throw new PropertyAlreadyExistsException();
		} else {
			em.persist(new PropertyEntity(property));
		}
		
	}

	@Override
	public Optional<Property> read(String property) {
		PropertyEntity entity = em.find(PropertyEntity.class, property);
		if (entity != null) {
			return Optional.of(entity.toDomain());
		} else {
			return Optional.empty();
		}
	}

	@Override
	public void update(Property property) {
		PropertyEntity entity = em.find(PropertyEntity.class, property.getProperty());
		if (entity != null) {
			entity.setValue(property.getValue());
		} else {
			throw new PropertyNotFoundException();
		}
	}

	@Override
	public void delete(String property) {
		PropertyEntity entity = em.find(PropertyEntity.class, property);
		if (entity != null) {
			em.remove(entity);
		} else {
			throw new PropertyNotFoundException();
		}
	}

	@Override
	public List<Property> list(String search) {
		return em.createNamedQuery("searchProperties", PropertyEntity.class)
				.setParameter("search", "%" + search.toUpperCase() + "%")
				.getResultList()
				.stream()
				.map(p -> p.toDomain())
				.collect(Collectors.toList());
	}

}
