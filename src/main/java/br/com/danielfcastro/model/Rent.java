package br.com.danielfcastro.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.Date;


/**
 * The persistent class for the Rent database table.
 * 
 */
@Entity
@NamedQuery(name="Rent.findAll", query="SELECT r FROM Rent r")
public class Rent extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String customerId;

	private int dailyRentFee;

	private int downPayment;

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

}