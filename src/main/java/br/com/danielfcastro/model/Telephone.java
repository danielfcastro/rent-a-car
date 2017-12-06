package br.com.danielfcastro.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;


/**
 * The persistent class for the Telephone database table.
 * 
 */
@Entity
@NamedQuery(name="Telephone.findAll", query="SELECT t FROM Telephone t")
public class Telephone extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String customerId;

	private String employeeId;

	private String idTelephoneType;

	private BigDecimal telephoneNumber;

	public Telephone() {
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

}