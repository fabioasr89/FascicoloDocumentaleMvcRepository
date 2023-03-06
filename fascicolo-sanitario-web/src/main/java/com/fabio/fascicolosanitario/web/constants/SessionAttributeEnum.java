package com.fabio.fascicolosanitario.web.constants;

public enum SessionAttributeEnum {
	
	
	USER("USERNAME"),
	ID_TOKEN("ID_TOKEN");
	
	private String attributo;
	
	private SessionAttributeEnum(String attributo) {
		this.attributo=attributo;
	}

	public String getAttributo() {
		return attributo;
	}

	public void setAttributo(String attributo) {
		this.attributo = attributo;
	}
	
	
}
