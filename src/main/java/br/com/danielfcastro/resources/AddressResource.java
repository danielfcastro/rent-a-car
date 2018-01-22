package br.com.danielfcastro.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.providers.jackson.Formatted;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.danielfcastro.dao.AddressDAO;
import br.com.danielfcastro.model.Address;

@Path("/addresses")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AddressResource {
	private static final Logger logger = LoggerFactory.getLogger(AddressResource.class);
	private static final String CONTENT_TYPE = "Content-Type";

	@Inject
	AddressDAO repository;

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Formatted
	public Response getAddresses() {
		logger.info("Início");
		Response response = null;
		List<Address> entity = repository.query("Address.findAll");
		if (entity.size() != 0) {
			response = Response.ok().entity(entity).build();
		} else {
			response = Response.noContent().build();
		}
		logger.info("Fim");
		return response;
	}

	@GET
	@Path("/address/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Formatted
	public Response getAddress(@PathParam("id") String id) {
		logger.info("Início");
		Response response = null;
		if (id == null || id.trim().length() == 0) {
			return Response.status(Response.Status.BAD_REQUEST).entity("id can not be null!").build();
		}
		List<Address> entity = repository.query(id);
		if (entity.size() != 0) {
			response = Response.ok().entity(entity).build();
		} else {
			response = Response.noContent().build();
		}
		logger.info("Fim");
		return response;
	}

	@PUT
	@Path("/address/")
	@Formatted
	public Response addAddress(@QueryParam("addressType") int addressType,
			@QueryParam("city") String city,
			@QueryParam("complement") String complement,
			@QueryParam("countryId") int countryId,
			@QueryParam("customerId") int customerId,
			@QueryParam("employeeId") int employeeId,
			@QueryParam("number") int number,
			@QueryParam("state") String state,
			@QueryParam("streetName") String streetName,
			@QueryParam("typeSite") String typeSite,
			@QueryParam("zipcode") String zipcode) {
		logger.info("Início");
		Address novo = new Address(addressType, city, complement, countryId, customerId, employeeId,
				number, state, streetName, typeSite, zipcode);
		String errorMessage = novo.checkNulls(true); 
		if (null == errorMessage) {
			repository.save(novo);	
		}else {
			return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).build();
		}
		
		logger.info("Fim");
		return Response.status(Response.Status.CREATED).entity("Address inserted with success!").build();
	}

	
	@POST
	@Path("/{id}")
	@Formatted
	public Response updateAddress(@PathParam("id") String id,
			@QueryParam("addressType") int addressType,
			@QueryParam("city") String city,
			@QueryParam("complement") String complement,
			@QueryParam("countryId") int countryId,
			@QueryParam("customerId") int customerId,
			@QueryParam("employeeId") int employeeId,
			@QueryParam("number") int number,
			@QueryParam("state") String state,
			@QueryParam("streetName") String streetName,
			@QueryParam("typeSite") String typeSite,
			@QueryParam("zipcode") String zipcode) {
		logger.info("Início");
		if (id == null || id.trim().length() == 0) {
			return Response.status(Response.Status.BAD_REQUEST).entity("id não pode ser nulo!").build();
		}
		Address novo = new Address(addressType, city, complement, countryId, customerId, employeeId,
				number, state, streetName, typeSite, zipcode);
		novo.setId(id);
		String errorMessage = novo.checkNulls(false); 
		if (null == errorMessage) {
			repository.save(novo);	
		}else {
			return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).build();
		}		
		repository.update(novo);
		logger.info("Fim");
		return Response.ok("Address updated with success!", MediaType.APPLICATION_JSON).build();
	}

	@DELETE
	@Path("/address/{id}")
	@Formatted
	public Response removeAddress(@PathParam("id") String id) {
		logger.info("Início");
		if (id == null || id.trim().length() == 0) {
			return Response.status(Response.Status.BAD_REQUEST).entity("id não pode ser nulo!").build();
		}
		repository.remove(id);
		logger.info("Fim");
		return Response.ok("Address removed with success!", MediaType.APPLICATION_JSON).build();

	}

	@GET
	@Path("/health_check")
	@Produces(MediaType.APPLICATION_JSON)
	@Formatted
	public Response health_check(@QueryParam("timeout") int timeout) {
		logger.info("Início");
		logger.info("Fim");
		return null;
	}

	@OPTIONS
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response options() {
		logger.info("Início");
		Response response = Response.status(200).header("Allow", "POST, PUT, GET, DELETE, OPTIONS, HEAD")
				.header("Content-Type", MediaType.APPLICATION_JSON).header("Content-Length", "0").build();
		logger.info("Fim");
		return response;
	}

	@HEAD
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response head() {
		logger.info("Início");
		Response retorno = Response.ok().header(AddressResource.CONTENT_TYPE, MediaType.APPLICATION_JSON).build();
		logger.info("Fim");
		return retorno;
	}

}
