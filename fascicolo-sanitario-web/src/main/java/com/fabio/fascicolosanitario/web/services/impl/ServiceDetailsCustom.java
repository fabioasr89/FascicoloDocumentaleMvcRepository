package com.fabio.fascicolosanitario.web.services.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fabio.fascicolosanitario.web.bean.UserDetailsCustom;
import com.fabio.fascicolosanitario.web.entity.UtenteEntity;
import com.fabio.fascicolosanitario.web.repository.UtenteDAO;

@Service
@Qualifier(value="servicesDetailsCustom")
public class ServiceDetailsCustom implements UserDetailsService{
	
	@Autowired
	private UtenteDAO utenteRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails utente=null;
		UtenteEntity utenteEntity=null;
		if(StringUtils.isNotBlank(username)) {
			utenteEntity= utenteRepository.getUtenteByUsername(username);
			try {
				utente=new UserDetailsCustom(utenteEntity);
				return utente;
			}catch(Exception e) {
				throw new UsernameNotFoundException(e.getMessage());
			}
			
			
		}
		
		throw new UsernameNotFoundException("Username non valorizzato, ");
	}
	
}
