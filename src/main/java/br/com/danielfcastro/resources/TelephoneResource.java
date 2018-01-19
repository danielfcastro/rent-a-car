package br.com.danielfcastro.resources;

import java.math.BigDecimal;
import java.util.List;

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

import br.com.danielfcastro.model.Telephone;
import br.com.danielfcastro.qualifier.TelephoneQualifier;
import br.com.danielfcastro.repository.IRepository;

@Path("/telephone")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TelephoneResource {
	private static final Logger logger = LoggerFactory.getLogger(TelephoneResource.class);
	private static final String CONTENT_TYPE = "Content-Type";

	@TelephoneQualifier
	IRepository<Telephone> repository;

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Formatted
	public Response getFueltype() {
		logger.info("Início");
		Response response = null;
		List<Telephone> entity = repository.query(null);
		if (entity.size() != 0) {
			response = Response.ok().entity(entity).build();
		} else {
			response = Response.noContent().build();
		}
		logger.info("Fim");
		return response;
	}

	@GET
	@Path("/telephone/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Formatted
	public Response getFueltype(@PathParam("id") String id) {
		logger.info("Início");
		Response response = null;
		if (id == null || id.trim().length() == 0) {
			return Response.status(Response.Status.BAD_REQUEST).entity("id can not be null!").build();
		}
		List<Telephone> entity = repository.query(id);
		if (entity.size() != 0) {
			response = Response.ok().entity(entity).build();
		} else {
			response = Response.noContent().build();
		}
		logger.info("Fim");
		return response;
	}

	@POST
	@Path("/telephone/")
	@Formatted
	public Response addFueltype(@QueryParam("customerId") String customerId,
			@QueryParam("employeeId") String employeeId, @QueryParam("idTelephoneType") String idTelephoneType,
			@QueryParam("telephoneNumber") BigDecimal telephoneNumber)
			throws IllegalArgumentException, IllegalAccessException {
		logger.info("Início");
		Telephone novo = new Telephone(customerId, employeeId, idTelephoneType, telephoneNumber);
		String errorMessage = novo.checkNulls();
		if (null == errorMessage) {
			repository.save(novo);
		} else {
			return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).build();
		}

		logger.info("Fim");
		return Response.status(Response.Status.CREATED).entity("Fueltype inserted with success!").build();
	}

	@PUT
	@Path("/telephone/{id}")
	@Formatted
	public Response updateFueltype(@PathParam("id") String id, @QueryParam("customerId") String customerId, @QueryParam("employeeId") String employeeId,
			@QueryParam("idTelephoneType") String idTelephoneType, @QueryParam("telephoneNumber")BigDecimal telephoneNumber)
			throws IllegalArgumentException, IllegalAccessException {
		logger.info("Início");
		if (id == null || id.trim().length() == 0) {
			return Response.status(Response.Status.BAD_REQUEST).entity("id não pode ser nulo!").build();
		}
		Telephone novo = new Telephone(customerId, employeeId, idTelephoneType, telephoneNumber);
		novo.setId(id);
		String errorMessage = novo.checkNulls();
		if (null == errorMessage) {
			novo.setId(id);
			repository.update(novo);
		} else {
			return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).build();
		}
		logger.info("Fim");
		return Response.ok("Fueltype updated with success!", MediaType.APPLICATION_JSON).build();
	}

	@DELETE
	@Path("/telephone/{id}")
	@Formatted
	public Response removeFueltype(@PathParam("id") String id) {
		logger.info("Início");
		if (id == null || id.trim().length() == 0) {
			return Response.status(Response.Status.BAD_REQUEST).entity("id não pode ser nulo!").build();
		}
		repository.remove(id);
		logger.info("Fim");
		return Response.ok("Fueltype removed with success!", MediaType.APPLICATION_JSON).build();

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
		Response retorno = Response.ok().header(TelephoneResource.CONTENT_TYPE, MediaType.APPLICATION_JSON).build();
		logger.info("Fim");
		return retorno;
	}

}
