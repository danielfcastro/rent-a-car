package br.com.danielfcastro.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the State database table.
 * 
 */
@Entity
@NamedQuery(name="State.findAll", query="SELECT s FROM State s")
public class State extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String countryId;

	private String fu;

	private String name;

	public State() {
	}

	public String getCountryId() {
		return this.countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getFu() {
		return this.fu;
	}

	public void setFu(String fu) {
		this.fu = fu;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}