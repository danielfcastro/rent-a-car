package br.com.danielfcastro.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the Country database table.
 * 
 */
@Entity

@NamedQueries({
	@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c"),
	@NamedQuery(name="Country.findById", query="SELECT c FROM Country c where id= :id")
})
public class Country extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String iso;

	private String iso3;

	private String name;

	private String nicename;

	private short numcode;

	private int phonecode;

	public Country() {
	}

	public Country(String iso, String iso3, String name, String nicename, short numcode, int phonecode) {
		super();
		this.iso = iso;
		this.iso3 = iso3;
		this.name = name;
		this.nicename = nicename;
		this.numcode = numcode;
		this.phonecode = phonecode;
	}

	public String getIso() {
		return this.iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public String getIso3() {
		return this.iso3;
	}

	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNicename() {
		return this.nicename;
	}

	public void setNicename(String nicename) {
		this.nicename = nicename;
	}

	public short getNumcode() {
		return this.numcode;
	}

	public void setNumcode(short numcode) {
		this.numcode = numcode;
	}

	public int getPhonecode() {
		return this.phonecode;
	}

	public void setPhonecode(int phonecode) {
		this.phonecode = phonecode;
	}

}