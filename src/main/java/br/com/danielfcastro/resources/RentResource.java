package br.com.danielfcastro.resources;

import java.util.Date;
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

import br.com.danielfcastro.model.Rent;
import br.com.danielfcastro.qualifier.RentQualifier;
import br.com.danielfcastro.repository.IRepository;

@Path("/rent")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RentResource {
	private static final Logger logger = LoggerFactory.getLogger(RentResource.class);
	private static final String CONTENT_TYPE = "Content-Type";

	@RentQualifier
	IRepository<Rent> repository;

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Formatted
	public Response getFueltype() {
		logger.info("Início");
		Response response = null;
		List<Rent> entity = repository.query(null);
		if (entity.size() != 0) {
			response = Response.ok().entity(entity).build();
		} else {
			response = Response.noContent().build();
		}
		logger.info("Fim");
		return response;
	}

	@GET
	@Path("/rent/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Formatted
	public Response getFueltype(@PathParam("id") String id) {
		logger.info("Início");
		Response response = null;
		if (id == null || id.trim().length() == 0) {
			return Response.status(Response.Status.BAD_REQUEST).entity("id can not be null!").build();
		}
		List<Rent> entity = repository.query(id);
		if (entity.size() != 0) {
			response = Response.ok().entity(entity).build();
		} else {
			response = Response.noContent().build();
		}
		logger.info("Fim");
		return response;
	}

	@POST
	@Path("/rent/")
	@Formatted
	public Response addFueltype(@QueryParam("customerId") String customerId,
			@QueryParam("dailyRentFee") int dailyRentFee, @QueryParam("downPayment") int downPayment,
			@QueryParam("employeeId") String employeeId, @QueryParam("fuelCharge") int fuelCharge,
			@QueryParam("plateNumber") String plateNumber, @QueryParam("refund") int refund,
			@QueryParam("rentDate") Date rentDate, @QueryParam("returnDate") Date returnDate,
			@QueryParam("totalPaid") int totalPaid, @QueryParam("totalRentDays") int totalRentDays) 
			throws IllegalArgumentException, IllegalAccessException {
		logger.info("Início");
		Rent novo = new Rent(customerId, dailyRentFee, downPayment, employeeId, fuelCharge, plateNumber, refund,
				rentDate, returnDate, totalPaid, totalRentDays);
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
	@Path("/rent/{id}")
	@Formatted
	public Response updateFueltype(@PathParam("id") String id, @QueryParam("customerId") String customerId,
			@QueryParam("dailyRentFee") int dailyRentFee, @QueryParam("downPayment") int downPayment,
			@QueryParam("employeeId") String employeeId, @QueryParam("fuelCharge") int fuelCharge,
			@QueryParam("plateNumber") String plateNumber, @QueryParam("refund") int refund,
			@QueryParam("rentDate") Date rentDate, @QueryParam("returnDate") Date returnDate,
			@QueryParam("totalPaid") int totalPaid, @QueryParam("totalRentDays") int totalRentDays)
			throws IllegalArgumentException, IllegalAccessException {
		logger.info("Início");
		if (id == null || id.trim().length() == 0) {
			return Response.status(Response.Status.BAD_REQUEST).entity("id não pode ser nulo!").build();
		}
		Rent novo = new Rent(customerId, dailyRentFee, downPayment, employeeId, fuelCharge, plateNumber, refund,
				rentDate, returnDate, totalPaid, totalRentDays);
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
	@Path("/rent/{id}")
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
		Response retorno = Response.ok().header(RentResource.CONTENT_TYPE, MediaType.APPLICATION_JSON).build();
		logger.info("Fim");
		return retorno;
	}

}
