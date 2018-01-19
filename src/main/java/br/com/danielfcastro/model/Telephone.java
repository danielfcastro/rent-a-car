package br.com.danielfcastro.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the Telephone database table.
 * 
 */
@Entity
@NamedQuery(name="Telephone.findAll", query="SELECT t FROM Telephone t")
public class Telephone extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	private String id;

	private String customerId;

	private String employeeId;

	private String idTelephoneType;

	private BigDecimal telephoneNumber;

	public Telephone() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getIdTelephoneType() {
		return this.idTelephoneType;
	}

	public void setIdTelephoneType(String idTelephoneType) {
		this.idTelephoneType = idTelephoneType;
	}

	public BigDecimal getTelephoneNumber() {
		return this.telephoneNumber;
	}

	public void setTelephoneNumber(BigDecimal telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public Telephone(String customerId, String employeeId, String idTelephoneType, BigDecimal telephoneNumber) {
		super();
		this.customerId = customerId;
		this.employeeId = employeeId;
		this.idTelephoneType = idTelephoneType;
		this.telephoneNumber = telephoneNumber;
	}

}