package com.fabio.fascicolosanitario.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ruolo")
public class RuoloEntity {
	
	
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="ruolo")
	private String ruolo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	
	
}
