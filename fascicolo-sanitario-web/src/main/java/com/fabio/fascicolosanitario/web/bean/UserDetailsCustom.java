package com.fabio.fascicolosanitario.web.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fabio.fascicolosanitario.web.entity.AutorizzazioneEntity;
import com.fabio.fascicolosanitario.web.entity.UtenteEntity;

public class UserDetailsCustom implements UserDetails{

	private static final long serialVersionUID = 1L;
	private UtenteEntity utente;
	
	public UserDetailsCustom(UtenteEntity entity) throws Exception {
		if(entity==null) {
			throw new Exception("Errore nella definizione dell'userdetails");
		}
		this.utente=entity;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		if(utente!=null) {
			Set<AutorizzazioneEntity> autorizzazioni=utente.getRuolo().getAutorizzazioni();
			for(AutorizzazioneEntity autorizzazione:autorizzazioni) {
				authorities.add(new SimpleGrantedAuthority(autorizzazione.getAutorizzazione()));
			}
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return utente.getPassword();
	}

	@Override
	public String getUsername() {
		return utente.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
