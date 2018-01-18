package br.com.danielfcastro.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CityGeoLoc database table.
 * 
 */
@Embeddable
public class CityGeoLocPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String id;

	private int zipCode;

	public CityGeoLocPK() {
	}
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getZipCode() {
		return this.zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CityGeoLocPK)) {
			return false;
		}
		CityGeoLocPK castOther = (CityGeoLocPK)other;
		return 
			this.id.equals(castOther.id)
			&& (this.zipCode == castOther.zipCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id.hashCode();
		hash = hash * prime + this.zipCode;
		
		return hash;
	}
}