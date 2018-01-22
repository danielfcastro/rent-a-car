package br.com.danielfcastro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the VehicleAccessories database table.
 * 
 */
@Entity
@Table(name="VehicleAccessories")
@NamedQuery(name="VehicleAccessory.findAll", query="SELECT v FROM VehicleAccessory v")
public class VehicleAccessory extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(columnDefinition = "char(36)")
	private String id;

	private String name;

	public VehicleAccessory() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public VehicleAccessory(String name) {
		super();
		this.name = name;
	}
}