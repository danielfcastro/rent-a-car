package br.com.danielfcastro.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the FuelType database table.
 * 
 */
@Entity
@NamedQuery(name="FuelType.findAll", query="SELECT f FROM FuelType f")
public class FuelType extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String fuel;

	public FuelType() {
	}

	public String getFuel() {
		return this.fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

}