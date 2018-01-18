package br.com.danielfcastro.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the Address database table.
 * 
 */
@Entity
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	private String id;

	private int addressType;

	private String city;

	private String complement;

	private int countryId;

	private int customerId;

	private int employeeId;

	private int number;

	private String state;

	private String streetName;

	private String typeSite;

	private String zipcode;

	public Address() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAddressType() {
		return this.addressType;
	}

	public void setAddressType(int addressType) {
		this.addressType = addressType;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getComplement() {
		return this.complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public int getCountryId() {
		return this.countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreetName() {
		return this.streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getTypeSite() {
		return this.typeSite;
	}

	public void setTypeSite(String typeSite) {
		this.typeSite = typeSite;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Address(int addressType, String city, String complement, int countryId, int customerId, int employeeId,
			int number, String state, String streetName, String typeSite, String zipcode) {
		super();
		this.addressType = addressType;
		this.city = city;
		this.complement = complement;
		this.countryId = countryId;
		this.customerId = customerId;
		this.employeeId = employeeId;
		this.number = number;
		this.state = state;
		this.streetName = streetName;
		this.typeSite = typeSite;
		this.zipcode = zipcode;
	}

}