package br.com.danielfcastro.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the VehicleType database table.
 * 
 */
@Entity
@NamedQuery(name="VehicleType.findAll", query="SELECT v FROM VehicleType v")
public class VehicleType extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String type;

	public VehicleType() {
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}