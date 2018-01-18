package br.com.danielfcastro.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the Customer database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	private String id;

	private String firstName;

	private String identificationDocument;

	private String identiicationType;

	private String lastName;

	private String middleName;

	private String passportNumber;

	public Customer() {
	}

	public String getId() {
		return this.id;
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

	public String getIdentificationDocument() {
		return this.identificationDocument;
	}

	public void setIdentificationDocument(String identificationDocument) {
		this.identificationDocument = identificationDocument;
	}

	public String getIdentiicationType() {
		return this.identiicationType;
	}

	public void setIdentiicationType(String identiicationType) {
		this.identiicationType = identiicationType;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPassportNumber() {
		return this.passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public Customer(String firstName, String identificationDocument, String identiicationType, String lastName,
			String middleName, String passportNumber) {
		super();
		this.firstName = firstName;
		this.identificationDocument = identificationDocument;
		this.identiicationType = identiicationType;
		this.lastName = lastName;
		this.middleName = middleName;
		this.passportNumber = passportNumber;
	}

}