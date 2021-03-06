package br.com.danielfcastro.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the Vehicle database table.
 * 
 */
@Entity
@NamedQuery(name="Vehicle.findAll", query="SELECT v FROM Vehicle v")
public class Vehicle extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String branchId;

	private String brandId;

	private String conditionId;

	private int dailyPrice;

	private String fuelId;

	private int luggageSpaceVolume;

	private String modelId;

	private String plateNumber;

	private int seatQuantity;

	private String vehicleTypeId;

	public Vehicle() {
	}

	public String getBranchId() {
		return this.branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getBrandId() {
		return this.brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getConditionId() {
		return this.conditionId;
	}

	public void setConditionId(String conditionId) {
		this.conditionId = conditionId;
	}

	public int getDailyPrice() {
		return this.dailyPrice;
	}

	public void setDailyPrice(int dailyPrice) {
		this.dailyPrice = dailyPrice;
	}

	public String getFuelId() {
		return this.fuelId;
	}

	public void setFuelId(String fuelId) {
		this.fuelId = fuelId;
	}

	public int getLuggageSpaceVolume() {
		return this.luggageSpaceVolume;
	}

	public void setLuggageSpaceVolume(int luggageSpaceVolume) {
		this.luggageSpaceVolume = luggageSpaceVolume;
	}

	public String getModelId() {
		return this.modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public String getPlateNumber() {
		return this.plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public int getSeatQuantity() {
		return this.seatQuantity;
	}

	public void setSeatQuantity(int seatQuantity) {
		this.seatQuantity = seatQuantity;
	}

	public String getVehicleTypeId() {
		return this.vehicleTypeId;
	}

	public void setVehicleTypeId(String vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
	}

}