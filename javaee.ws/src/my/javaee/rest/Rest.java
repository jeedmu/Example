package my.javaee.rest;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javaee.domain.Property;
import javaee.ejb.beans.PropertyBeanLocal;

@Path("/property")
public class Rest {
	@Inject
	private PropertyBeanLocal ejb;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("read/{key}")
	public Property read(@PathParam("key") String key) {
		Optional<Property> optional = ejb.read(key);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list/{search}")
	public List<Property> search(@PathParam("search") String search) {
		return ejb.list(search);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("")
	public Boolean insert(Property property) {
		ejb.create(property);
		return Boolean.TRUE;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("")
	public Boolean update(Property property) {
		ejb.update(property);
		return Boolean.TRUE;
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("delete/{key}")
	public Boolean delete(@PathParam("key") String key) {
		ejb.delete(key);
		return Boolean.TRUE;
	}


}
