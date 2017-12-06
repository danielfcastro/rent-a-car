package br.com.danielfcastro.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the TelephoneType database table.
 * 
 */
@Entity
@NamedQuery(name="TelephoneType.findAll", query="SELECT t FROM TelephoneType t")
public class TelephoneType extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String description;

	public TelephoneType() {
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}