package br.com.danielfcastro.model;

import java.lang.reflect.Field;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

public abstract class BaseModel {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(columnDefinition = "char(36)")
	private String id;

	protected BaseModel() {
		super();
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public final String checkNulls(boolean ignoreId)  {
		StringBuilder sb = new StringBuilder();
		for (Field field : this.getClass().getDeclaredFields()) {
			Class t = field.getType();
			field.setAccessible(true);
			Object v;
			try {
				v = field.get(this);
				if(ignoreId && field.getName().equalsIgnoreCase("id")) continue;
				if (t.isPrimitive() && ((Number) v).doubleValue() == 0) {
					sb.append("Property ").append(field.getName()).append(" can not be 0").append('\n');
				} else if(t == boolean.class && Boolean.FALSE.equals(v)) {
					sb.append("Property ").append(field.getName()).append(" can not be 0").append('\n');
				}else if (!t.isPrimitive() && v == null) {
					sb.append("Property ").append(field.getName()).append(" can not be null").append('\n');
				}				
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}

		}
		if(sb.length()>0) sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}

}