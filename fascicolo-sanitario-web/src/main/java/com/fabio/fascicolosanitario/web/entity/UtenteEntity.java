package com.fabio.fascicolosanitario.web.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="utente")
public class UtenteEntity{

	@Id
	@Column(name="id")
	private String idUtente;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "fk_ruolo")
	private RuoloEntity ruolo;

	public String getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(String idUtente) {
		this.idUtente = idUtente;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RuoloEntity getRuolo() {
		return ruolo;
	}

	public void setRuolo(RuoloEntity ruolo) {
		this.ruolo = ruolo;
	}

	
	
	
}
