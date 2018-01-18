package br.com.danielfcastro.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the ModelType database table.
 * 
 */
@Entity
@NamedQuery(name="ModelType.findAll", query="SELECT m FROM ModelType m")
public class ModelType extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	private String id;

	private String idBrand;

	private String model;

	public ModelType() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdBrand() {
		return this.idBrand;
	}

	public void setIdBrand(String idBrand) {
		this.idBrand = idBrand;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}