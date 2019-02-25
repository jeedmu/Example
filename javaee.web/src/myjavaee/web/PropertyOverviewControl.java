package myjavaee.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import javaee.ejb.beans.PropertyBeanLocal;

@Named
@SessionScoped
public class PropertyOverviewControl implements Serializable {
	
	@EJB private PropertyBeanLocal properties;
	@Inject private PropertyOverviewModel overview;
	@Inject private PropertyDetailModel detail;
	private Logger logger = Logger.getLogger(PropertyOverviewControl.class);

	private static final long serialVersionUID = 1L;

	public PropertyOverviewControl() {
	}
	
	public void search() {
		logger.info("Search : " + overview.getSearchString());
		overview.setList(properties.list(overview.getSearchString()));
	}
	
	public String view() {
		logger.info("Selected property : " + overview.getSelectedProperty());
		if (overview != null && overview.getSelectedProperty() != null) {
			detail.setProperty(overview.getSelectedProperty().getProperty());
			detail.setValue(overview.getSelectedProperty().getValue());
			overview.setSelectedProperty(null);
			return "propertydetail.xhtml";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No row selected"));
			return null;
		}
	}
	
	public String create() {
		if (detail != null) {
			detail.setProperty(null);
			detail.setValue(null);
			overview.setSelectedProperty(null);
			return "propertydetail.xhtml";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No detail"));
			return null;
		}

	}

}
