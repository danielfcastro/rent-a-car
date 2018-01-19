package br.com.danielfcastro.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.GenericGenerator;

/**
 * The persistent class for the VehicleCategory database table.
 * 
 */
@Entity
@NamedQuery(name = "VehicleCategory.findAll", query = "SELECT v FROM VehicleCategory v")
public class VehicleCategory extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	private String id;

	private int averageLuggageQuantity;

	private String idVehicleType;

	private String name;

	private int seatNumbers;

	public VehicleCategory() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAverageLuggageQuantity() {
		return this.averageLuggageQuantity;
	}

	public void setAverageLuggageQuantity(int averageLuggageQuantity) {
		this.averageLuggageQuantity = averageLuggageQuantity;
	}

	public String getIdVehicleType() {
		return this.idVehicleType;
	}

	public void setIdVehicleType(String idVehicleType) {
		this.idVehicleType = idVehicleType;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSeatNumbers() {
		return this.seatNumbers;
	}

	public void setSeatNumbers(int seatNumbers) {
		this.seatNumbers = seatNumbers;
	}

	public VehicleCategory(int averageLuggageQuantity, String idVehicleType, String name, int seatNumbers) {
		super();
		this.averageLuggageQuantity = averageLuggageQuantity;
		this.idVehicleType = idVehicleType;
		this.name = name;
		this.seatNumbers = seatNumbers;
	}

}