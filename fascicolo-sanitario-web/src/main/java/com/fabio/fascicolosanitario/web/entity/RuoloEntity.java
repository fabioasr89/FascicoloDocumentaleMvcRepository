package com.fabio.fascicolosanitario.web.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="ruolo")
public class RuoloEntity {
	
	
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="ruolo")
	private String ruolo;
	
	@ManyToMany
	@JoinTable(
			name = "ass_ruolo_autorizzazione",
			joinColumns = @JoinColumn(name="fk_ruolo"),
			inverseJoinColumns = @JoinColumn(name="fk_autorizzazione"))
	private Set<AutorizzazioneEntity> autorizzazioni;
	
	
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

	public Set<AutorizzazioneEntity> getAutorizzazioni() {
		return autorizzazioni;
	}

	public void setAutorizzazioni(Set<AutorizzazioneEntity> autorizzazioni) {
		this.autorizzazioni = autorizzazioni;
	}
	
	
}
