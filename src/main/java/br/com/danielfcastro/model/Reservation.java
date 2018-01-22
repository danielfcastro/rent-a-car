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
 * The persistent class for the Reservation database table.
 * 
 */
@Entity
@NamedQuery(name="Reservation.findAll", query="SELECT r FROM Reservation r")
public class Reservation extends BaseModel implements Serializable {
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

	@Column(columnDefinition = "char(36)")
	private String customerId;

	@Temporal(TemporalType.DATE)
	private Date pickupDate;

	private String plateNumber;

	@Temporal(TemporalType.DATE)
	private Date reservationDate;

	@Temporal(TemporalType.DATE)
	private Date returnDate;

	public Reservation() {
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

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Date getPickupDate() {
		return this.pickupDate;
	}

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}

	public String getPlateNumber() {
		return this.plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public Date getReservationDate() {
		return this.reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public Date getReturnDate() {
		return this.returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Reservation(String agencyId, String customerId, Date pickupDate, String plateNumber, Date reservationDate,
			Date returnDate) {
		super();
		this.agencyId = agencyId;
		this.customerId = customerId;
		this.pickupDate = pickupDate;
		this.plateNumber = plateNumber;
		this.reservationDate = reservationDate;
		this.returnDate = returnDate;
	}

}