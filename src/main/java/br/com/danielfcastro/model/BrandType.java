package br.com.danielfcastro.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the BrandType database table.
 * 
 */
@Entity
@NamedQuery(name="BrandType.findAll", query="SELECT b FROM BrandType b")
public class BrandType extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String brand;

	public BrandType() {
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

}