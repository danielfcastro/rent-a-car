package br.com.danielfcastro.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the ModelType database table.
 * 
 */
@Entity
@NamedQuery(name="ModelType.findAll", query="SELECT m FROM ModelType m")
public class ModelType extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String idBrand;

	private String model;

	public ModelType() {
	}

	public String getIdBrand() {
		return this.idBrand;
	}

	public void setIdBrand(String idBrand) {
		this.idBrand = idBrand;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}