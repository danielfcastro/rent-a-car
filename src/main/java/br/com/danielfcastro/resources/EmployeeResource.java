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

import br.com.danielfcastro.model.Employee;
import br.com.danielfcastro.repository.impl.EmployeeRepositoryImpl;

@Path("/employees")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeResource.class);
	private static final String CONTENT_TYPE = "Content-Type";

	@Inject
	EmployeeRepositoryImpl repository;

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Formatted
	public Response getEmployee() {
		logger.info("Início");
		Response response = null;
		List<Employee> entity = repository.query(null);
		if (entity.size() != 0) {
			response = Response.ok().entity(entity).build();
		} else {
			response = Response.noContent().build();
		}
		logger.info("Fim");
		return response;
	}

	@GET
	@Path("/employee/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Formatted
	public Response getEmployee(@PathParam("id") String id) {
		logger.info("Início");
		Response response = null;
		if (id == null || id.trim().length() == 0) {
			return Response.status(Response.Status.BAD_REQUEST).entity("id can not be null!").build();
		}
		List<Employee> entity = repository.query(id);
		if (entity.size() != 0) {
			response = Response.ok().entity(entity).build();
		} else {
			response = Response.noContent().build();
		}
		logger.info("Fim");
		return response;
	}

	@POST
	@Path("/employee/")
	@Formatted
	public Response addEmployee(@QueryParam("firstName") String firstName, 
			@QueryParam("flagManager") byte flagManager, 
			@QueryParam("identificationDocument") String identificationDocument, 
			@QueryParam("identificationtYPE") String identificationtYPE,
			@QueryParam("lastName") String lastName, 
			@QueryParam("managerId") String managerId, 
			@QueryParam("middleName") String middleName)
			throws IllegalArgumentException, IllegalAccessException {
		logger.info("Início");
		Employee novo = new Employee(firstName, flagManager, identificationDocument, identificationtYPE,
				lastName, managerId, middleName);
		String errorMessage = novo.checkNulls();
		if (null == errorMessage) {
			repository.add(novo);
		} else {
			return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).build();
		}

		logger.info("Fim");
		return Response.status(Response.Status.CREATED).entity("Employee inserted with success!").build();
	}

	@PUT
	@Path("/employee/{id}")
	@Formatted
	public Response updateEmployee(@PathParam("id") String id, @QueryParam("firstName") String firstName, 
			@QueryParam("flagManager") byte flagManager, 
			@QueryParam("identificationDocument") String identificationDocument, 
			@QueryParam("identificationtYPE") String identificationtYPE,
			@QueryParam("lastName") String lastName, 
			@QueryParam("managerId") String managerId, 
			@QueryParam("middleName") String middleName)
			throws IllegalArgumentException, IllegalAccessException {
		logger.info("Início");
		if (id == null || id.trim().length() == 0) {
			return Response.status(Response.Status.BAD_REQUEST).entity("id não pode ser nulo!").build();
		}
		Employee novo = new Employee(firstName, flagManager, identificationDocument, identificationtYPE,
				lastName, managerId, middleName);
		String errorMessage = novo.checkNulls();
		if (null == errorMessage) {
			novo.setId(id);
			repository.update(novo);
		} else {
			return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).build();
		}
		logger.info("Fim");
		return Response.ok("Employee updated with success!", MediaType.APPLICATION_JSON).build();
	}

	@DELETE
	@Path("/employee/{id}")
	@Formatted
	public Response removeEmployee(@PathParam("id") String id) {
		logger.info("Início");
		if (id == null || id.trim().length() == 0) {
			return Response.status(Response.Status.BAD_REQUEST).entity("id não pode ser nulo!").build();
		}
		repository.remove(id);
		logger.info("Fim");
		return Response.ok("Employee removed with success!", MediaType.APPLICATION_JSON).build();

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
		Response retorno = Response.ok().header(EmployeeResource.CONTENT_TYPE, MediaType.APPLICATION_JSON).build();
		logger.info("Fim");
		return retorno;
	}

}
