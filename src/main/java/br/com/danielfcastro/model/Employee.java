package br.com.danielfcastro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


/**
 * The persistent class for the Employee database table.
 * 
 */
@Entity
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(columnDefinition = "char(36)")
	private String id;

	private String firstName;

	@Column(columnDefinition="BITY(1)")
	private byte flagManager;

	private String identificationDocument;

	private String identificationtYPE;

	private String lastName;

	@Column(columnDefinition = "char(36)")
	private String managerId;

	private String middleName;

	public Employee() {
	}


	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public byte setFlagManager() {
		return flagManager;
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

}