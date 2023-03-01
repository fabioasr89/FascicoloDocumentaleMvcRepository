package com.fabio.fascicolosanitario.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabio.fascicolosanitario.web.entity.DocumentoEntity;
@Repository
public interface DocumentoRepository extends JpaRepository<DocumentoEntity, String>{

}
