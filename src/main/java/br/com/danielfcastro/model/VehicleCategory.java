package br.com.danielfcastro.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the VehicleCategory database table.
 * 
 */
@Entity
@NamedQuery(name="VehicleCategory.findAll", query="SELECT v FROM VehicleCategory v")
public class VehicleCategory extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private int averageLuggageQuantity;

	private String idVehicleType;

	private String name;

	private int seatNumbers;

	public VehicleCategory() {
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

}