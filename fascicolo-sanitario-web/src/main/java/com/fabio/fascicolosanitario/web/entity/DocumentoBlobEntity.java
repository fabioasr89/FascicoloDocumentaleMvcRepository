package com.fabio.fascicolosanitario.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="documento_blob")
public class DocumentoBlobEntity {
	
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="blob",nullable=false)
	private byte[] blob;
	
	@Column(name="size")
	private Long size;
	
	@ManyToOne
	@JoinColumn(name="fk_documento")
	private DocumentoEntity documento;
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte[] getBlob() {
		return blob;
	}

	public void setBlob(byte[] blob) {
		this.blob = blob;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public DocumentoEntity getDocumento() {
		return documento;
	}

	public void setDocumento(DocumentoEntity documento) {
		this.documento = documento;
	}
	
	
}
