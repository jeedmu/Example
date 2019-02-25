package myjavaee.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import javaee.domain.Property;

@Named
@SessionScoped
public class PropertyOverviewModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String searchString;
	private List<Property> list;
	private Property selectedProperty;

	public PropertyOverviewModel() {
	}
	
	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String search) {
		this.searchString = search;
	}

	public List<Property> getList() {
		return list;
	}

	public void setList(List<Property> list) {
		this.list = list;
	}

	public Property getSelectedProperty() {
		return selectedProperty;
	}

	public void setSelectedProperty(Property selectedProperty) {
		this.selectedProperty = selectedProperty;
	}

}
