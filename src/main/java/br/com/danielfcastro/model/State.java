package br.com.danielfcastro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the State database table.
 * 
 */
@Entity
@NamedQuery(name="State.findAll", query="SELECT s FROM State s")
public class State extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(columnDefinition = "char(36)")
	private String id;

	@Column(columnDefinition = "char(36)")
	private String countryId;

	private String fu;

	private String name;

	public State() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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

	public State(String countryId, String fu, String name) {
		super();
		this.countryId = countryId;
		this.fu = fu;
		this.name = name;
	}

}