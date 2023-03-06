package com.fabio.fascicolosanitario.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fabio.fascicolosanitario.web.entity.UtenteEntity;
@Repository
public interface UtenteDAO extends JpaRepository<UtenteEntity, String>{
	
	@Query(value="FROM UtenteEntity utente where utente.username=:username")
	UtenteEntity getUtenteByUsername(@Param(value = "username")String username);
}
