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

import br.com.danielfcastro.dao.CountryDAO;
import br.com.danielfcastro.model.Country;

@Path("/countries")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CountryResource {
	private static final Logger logger = LoggerFactory.getLogger(CountryResource.class);
	private static final String CONTENT_TYPE = "Content-Type";

	@Inject
	CountryDAO repository;

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Formatted
	public Response getCountry() {
		logger.info("Início");
		Response response = null;
		List<Country> entity = repository.query("Country.findAll");
		if (entity.size() != 0) {
			response = Response.ok().entity(entity).build();
		} else {
			response = Response.noContent().build();
		}
		logger.info("Fim");
		return response;
	}

	@GET
	@Path("/country/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Formatted
	public Response getCountry(@PathParam("id") String id) {
		logger.info("Início");
		Response response = null;
		if (id == null || id.trim().length() == 0) {
			return Response.status(Response.Status.BAD_REQUEST).entity("id can not be null!").build();
		}
		List<Country> entity = repository.query(id);
		if (entity.size() != 0) {
			response = Response.ok().entity(entity).build();
		} else {
			response = Response.noContent().build();
		}
		logger.info("Fim");
		return response;
	}

	@PUT
	@Path("/country/")
	@Formatted
	public Response addCountry(@QueryParam("iso") String iso, @QueryParam("iso3") String iso3,
			@QueryParam("name") String name, @QueryParam("nicename") String nicename,
			@QueryParam("numcode") short numcode, @QueryParam("phonecode") int phonecode)
			throws IllegalArgumentException, IllegalAccessException {
		logger.info("Início");
		Country novo = new Country(iso, iso3, name, nicename, numcode, phonecode);
		String errorMessage = novo.checkNulls(true);
		if (null == errorMessage) {
			repository.save(novo);
		} else {
			return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).build();
		}

		logger.info("Fim");
		return Response.status(Response.Status.CREATED).entity("Country inserted with success!").build();
	}

	
	@POST
	@Path("/country/{id}")
	@Formatted
	public Response updateCountry(@PathParam("id") String id, @QueryParam("iso") String iso, @QueryParam("iso3") String iso3,
			@QueryParam("name") String name, @QueryParam("nicename") String nicename,
			@QueryParam("numcode") short numcode, @QueryParam("phonecode") int phonecode)
			throws IllegalArgumentException, IllegalAccessException {
		logger.info("Início");
		if (id == null || id.trim().length() == 0) {
			return Response.status(Response.Status.BAD_REQUEST).entity("id não pode ser nulo!").build();
		}
		Country novo = new Country(iso, iso3, name, nicename, numcode, phonecode);
		novo.setId(id);
		String errorMessage = novo.checkNulls(false);
		if (null == errorMessage) {
			novo.setId(id);
			repository.update(novo);
		} else {
			return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).build();
		}
		logger.info("Fim");
		return Response.ok("Country updated with success!", MediaType.APPLICATION_JSON).build();
	}

	@DELETE
	@Path("/type/{id}")
	@Formatted
	public Response removeCountry(@PathParam("id") String id) {
		logger.info("Início");
		if (id == null || id.trim().length() == 0) {
			return Response.status(Response.Status.BAD_REQUEST).entity("id não pode ser nulo!").build();
		}
		repository.remove(id);
		logger.info("Fim");
		return Response.ok("Country removed with success!", MediaType.APPLICATION_JSON).build();

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
		Response retorno = Response.ok().header(CountryResource.CONTENT_TYPE, MediaType.APPLICATION_JSON).build();
		logger.info("Fim");
		return retorno;
	}

}
