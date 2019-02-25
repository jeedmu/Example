package javaee.ejbws;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import javaee.domain.Property;

public class RestClient {
	private final String PATH = "http://m13975:8080/javaee.ws/rest/property/";
	
	public Property read(String property) {
		Client client = ClientBuilder.newClient();
		Property prop =  client.target(PATH + "read/" + property)
				.request(MediaType.APPLICATION_JSON)
				.get(Property.class);
		client.close();
		return prop;
	}
	
	public List<Property> list(String search) {
		Client client = ClientBuilder.newClient();
		List<Property> list =  client.target(PATH + "list/" + search)
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Property>>() {});
		client.close();
		return list;
	}
	
	public boolean insert(Property property) {
		Client client = ClientBuilder.newClient();
		boolean b =  client.target(PATH)
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.json(property), Boolean.class);
		client.close();
		return b;
	}

	public boolean update(Property property) {
		Client client = ClientBuilder.newClient();
		boolean b =  client.target(PATH)
				.request(MediaType.APPLICATION_JSON)
				.put(Entity.json(property), Boolean.class);
		client.close();
		return b;
	}

	public boolean delete(String property) {
		Client client = ClientBuilder.newClient();
		boolean b =  client.target(PATH + "delete/" + property)
				.request(MediaType.APPLICATION_JSON)
				.delete(Boolean.class);
		client.close();
		return b;
	}
}
