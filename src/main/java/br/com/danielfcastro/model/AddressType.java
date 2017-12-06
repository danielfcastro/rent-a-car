package br.com.danielfcastro.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the AddressType database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="AddressType.findAll", query="SELECT a FROM AddressType a"),
	@NamedQuery(name="AddressType.findById", query="SELECT a FROM AddressType a WHERE id= :id")
})
public class AddressType extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;

	public AddressType() {
	}

	public AddressType(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}