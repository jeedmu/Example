package myjavaee.web;

import java.io.Serializable;
import java.util.Optional;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import javaee.domain.Property;
import javaee.ejb.beans.PropertyBeanLocal;

@Named
@SessionScoped
public class PropertyDetailControl implements Serializable {

	@EJB private PropertyBeanLocal properties;
	@Inject private PropertyDetailModel model;
	private Logger logger = Logger.getLogger(PropertyDetailControl.class);
	
	private static final long serialVersionUID = 1L;

	public PropertyDetailControl() {
	}
	
	public void fetch() {
		logger.info("method fetch entered");
		try {
			Optional<Property> optional = properties.read(model.getProperty());
			if (optional.isPresent()) {
				model.setProperty(optional.get().getProperty());
				model.setValue(optional.get().getValue());
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Property fetched"));
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Property not found", "Property not found"));
			}
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error occured", e.getMessage()));
		}

	}
	
	public void save() {
		logger.info("method save entered");
		try {
			Optional<Property> optional = properties.read(model.getProperty());
			if (optional.isPresent()) {
				properties.update(new Property(model.getProperty(), model.getValue()));
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Property updated"));
			} else {
				properties.create(new Property(model.getProperty(), model.getValue()));
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Property created"));
			}
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error occured", e.getMessage()));
		}

	}
	
	public void delete() {
		logger.info("method delete entered");
		try {
			Optional<Property> optional = properties.read(model.getProperty());
			if (optional.isPresent()) {
				properties.delete(model.getProperty());
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Property deleted"));
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Property not found", "Property not found"));
			}
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error occured", e.getMessage()));
		}
		
	}

}
