package com.fabio.fascicolosanitario.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabio.fascicolosanitario.web.entity.PazienteEntity;

public interface PazienteRepository extends JpaRepository<PazienteEntity,String>{

}
