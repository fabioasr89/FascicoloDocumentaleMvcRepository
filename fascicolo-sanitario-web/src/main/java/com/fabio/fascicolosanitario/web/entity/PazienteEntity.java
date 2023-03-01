package com.fabio.fascicolosanitario.web.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="paziente")
public class PazienteEntity {
	
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="codice_fiscale",unique=true)
	private String codiceFiscale;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cognome")
	private String cognome;
	
	
	@OneToMany(mappedBy="paziente")
	private Set<DocumentoEntity> documenti;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Set<DocumentoEntity> getDocumenti() {
		return documenti;
	}

	public void setDocumenti(Set<DocumentoEntity> documenti) {
		this.documenti = documenti;
	}
	
	
}
