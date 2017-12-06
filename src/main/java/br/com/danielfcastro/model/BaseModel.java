package br.com.danielfcastro.model;

import java.lang.reflect.Field;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

public abstract class BaseModel {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	protected BaseModel() {
		super();
	}

	public final String getId() {
		return this.id;
	}

	public final void setId(String id) {
		this.id = id;
	}

	public final String checkNulls() throws IllegalArgumentException, IllegalAccessException {
		StringBuilder sb = new StringBuilder();
		for (Field field : this.getClass().getDeclaredFields()) {
			Class t = field.getType();
			field.setAccessible(true);
			Object v = field.get(this);
			if (t.isPrimitive() && ((Number) v).doubleValue() == 0) {
				sb.append("Property ").append(field.getName()).append(" can not be 0").append('\n');
			} else if(t == boolean.class && Boolean.FALSE.equals(v)) {
				sb.append("Property ").append(field.getName()).append(" can not be 0").append('\n');
			}else if (!t.isPrimitive() && v == null) {
				sb.append("Property ").append(field.getName()).append(" can not be null").append('\n');
			}
		}
		if(sb.length()>0) sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}

}