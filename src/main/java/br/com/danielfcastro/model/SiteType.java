package br.com.danielfcastro.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the SiteType database table.
 * 
 */
@Entity
@NamedQuery(name="SiteType.findAll", query="SELECT s FROM SiteType s")
public class SiteType extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String abbreviation;

	private String countryId;

	private String site;

	public SiteType() {
	}

	public String getAbbreviation() {
		return this.abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getCountryId() {
		return this.countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getSite() {
		return this.site;
	}

	public void setSite(String site) {
		this.site = site;
	}

}