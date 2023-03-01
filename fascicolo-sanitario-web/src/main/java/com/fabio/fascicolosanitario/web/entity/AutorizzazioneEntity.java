package com.fabio.fascicolosanitario.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="autorizzazione")
public class AutorizzazioneEntity {
	
	
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="autorizzazione")
	private String autorizzazione;
	
	public AutorizzazioneEntity() {}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAutorizzazione() {
		return autorizzazione;
	}

	public void setAutorizzazione(String autorizzazione) {
		this.autorizzazione = autorizzazione;
	}
	
	
	
}
