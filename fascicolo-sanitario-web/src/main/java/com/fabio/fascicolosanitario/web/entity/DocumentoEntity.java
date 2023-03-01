package com.fabio.fascicolosanitario.web.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="documento")
public class DocumentoEntity {
	
	
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="nome_file")
	private String nomeFile;
	
	@Column(name="mime")
	private String mime;
	
	@ManyToOne
	@JoinColumn(name="fk_paziente")
	private PazienteEntity paziente;
	
	@OneToMany(mappedBy="documento")
	private Set<DocumentoBlobEntity> files;
	
	public DocumentoEntity() {}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getNomeFile() {
		return nomeFile;
	}



	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}



	public String getMime() {
		return mime;
	}



	public void setMime(String mime) {
		this.mime = mime;
	}



	public PazienteEntity getPaziente() {
		return paziente;
	}



	public void setPaziente(PazienteEntity paziente) {
		this.paziente = paziente;
	}



	public Set<DocumentoBlobEntity> getFiles() {
		return files;
	}



	public void setFiles(Set<DocumentoBlobEntity> files) {
		this.files = files;
	}
	
	
}
