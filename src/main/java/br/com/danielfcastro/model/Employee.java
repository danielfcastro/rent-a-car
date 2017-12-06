package br.com.danielfcastro.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the Employee database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e"),
	@NamedQuery(name="Employee.findById", query="SELECT e FROM Employee e WHERE id= :id")
})
public class Employee extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String firstName;

	private byte flagManager;

	private String identificationDocument;

	private String identificationtYPE;

	private String lastName;

	private String managerId;

	private String middleName;

	public Employee() {
	}

	public Employee(String firstName, byte flagManager, String identificationDocument, String identificationtYPE,
			String lastName, String managerId, String middleName) {
		super();
		this.firstName = firstName;
		this.flagManager = flagManager;
		this.identificationDocument = identificationDocument;
		this.identificationtYPE = identificationtYPE;
		this.lastName = lastName;
		this.managerId = managerId;
		this.middleName = middleName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public byte getFlagManager() {
		return this.flagManager;
	}

	public void setFlagManager(byte flagManager) {
		this.flagManager = flagManager;
	}

	public String getIdentificationDocument() {
		return this.identificationDocument;
	}

	public void setIdentificationDocument(String identificationDocument) {
		this.identificationDocument = identificationDocument;
	}

	public String getIdentificationtYPE() {
		return this.identificationtYPE;
	}

	public void setIdentificationtYPE(String identificationtYPE) {
		this.identificationtYPE = identificationtYPE;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getManagerId() {
		return this.managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

}