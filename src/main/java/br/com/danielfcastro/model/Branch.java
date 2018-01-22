package br.com.danielfcastro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the Branch database table.
 * 
 */
@Entity
@NamedQuery(name="Branch.findAll", query="SELECT b FROM Branch b")
public class Branch extends BaseModel implements Serializable {
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
	private String agencyId;

	private String name;

	public Branch() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAgencyId() {
		return this.agencyId;
	}

	public void setAgencyId(String agencyId) {
		this.agencyId = agencyId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Branch(String agencyId, String name) {
		super();
		this.agencyId = agencyId;
		this.name = name;
	}

}