package com.fabio.fascicolosanitario.web.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="autorizzazione")
public class AutorizzazioneEntity {
	
	
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="autorizzazione")
	private String autorizzazione;
	
	@ManyToMany(mappedBy = "autorizzazioni")
	private Set<RuoloEntity> ruoli;
	
	
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
	public Set<RuoloEntity> getRuoli() {
		return ruoli;
	}
	public void setRuoli(Set<RuoloEntity> ruoli) {
		this.ruoli = ruoli;
	}
	
	
	
}
