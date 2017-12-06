package br.com.danielfcastro.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the VehicleAccessories database table.
 * 
 */
@Entity
@Table(name="VehicleAccessories")
@NamedQuery(name="VehicleAccessory.findAll", query="SELECT v FROM VehicleAccessory v")
public class VehicleAccessory extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;

	public VehicleAccessory() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}