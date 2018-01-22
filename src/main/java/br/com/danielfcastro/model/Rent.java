package br.com.danielfcastro.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the Rent database table.
 * 
 */
@Entity
@NamedQuery(name="Rent.findAll", query="SELECT r FROM Rent r")
public class Rent extends BaseModel implements Serializable {
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
	private String customerId;

	private int dailyRentFee;

	private int downPayment;

	@Column(columnDefinition = "char(36)")
	private String employeeId;

	private int fuelCharge;

	private String plateNumber;

	private int refund;

	@Temporal(TemporalType.DATE)
	private Date rentDate;

	@Temporal(TemporalType.DATE)
	private Date returnDate;

	private int totalPaid;

	private int totalRentDays;

	public Rent() {
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

	public int getDailyRentFee() {
		return this.dailyRentFee;
	}

	public void setDailyRentFee(int dailyRentFee) {
		this.dailyRentFee = dailyRentFee;
	}

	public int getDownPayment() {
		return this.downPayment;
	}

	public void setDownPayment(int downPayment) {
		this.downPayment = downPayment;
	}

	public String getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public int getFuelCharge() {
		return this.fuelCharge;
	}

	public void setFuelCharge(int fuelCharge) {
		this.fuelCharge = fuelCharge;
	}

	public String getPlateNumber() {
		return this.plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public int getRefund() {
		return this.refund;
	}

	public void setRefund(int refund) {
		this.refund = refund;
	}

	public Date getRentDate() {
		return this.rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	public Date getReturnDate() {
		return this.returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public int getTotalPaid() {
		return this.totalPaid;
	}

	public void setTotalPaid(int totalPaid) {
		this.totalPaid = totalPaid;
	}

	public int getTotalRentDays() {
		return this.totalRentDays;
	}

	public void setTotalRentDays(int totalRentDays) {
		this.totalRentDays = totalRentDays;
	}

	public Rent(String customerId, int dailyRentFee, int downPayment, String employeeId, int fuelCharge,
			String plateNumber, int refund, Date rentDate, Date returnDate, int totalPaid, int totalRentDays) {
		super();
		this.customerId = customerId;
		this.dailyRentFee = dailyRentFee;
		this.downPayment = downPayment;
		this.employeeId = employeeId;
		this.fuelCharge = fuelCharge;
		this.plateNumber = plateNumber;
		this.refund = refund;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
		this.totalPaid = totalPaid;
		this.totalRentDays = totalRentDays;
	}

}