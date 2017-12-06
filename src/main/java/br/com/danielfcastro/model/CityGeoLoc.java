package br.com.danielfcastro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CityGeoLoc database table.
 * 
 */
@Entity
@NamedQuery(name="CityGeoLoc.findAll", query="SELECT c FROM CityGeoLoc c")
public class CityGeoLoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CityGeoLocPK id;

	private String county;

	private BigDecimal latitude;

	private BigDecimal longitude;

	public CityGeoLoc() {
	}

	public CityGeoLocPK getId() {
		return this.id;
	}

	public void setId(CityGeoLocPK id) {
		this.id = id;
	}

	public String getCounty() {
		return this.county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public BigDecimal getLatitude() {
		return this.latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return this.longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

}