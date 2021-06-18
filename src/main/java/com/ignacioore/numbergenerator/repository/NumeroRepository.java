package com.ignacioore.numbergenerator.repository;

import com.ignacioore.numbergenerator.model.Numero;

import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;


public interface NumeroRepository extends CrudRepository<Numero, UUID>{
	public List<Numero> findAll();
	
	public void delete(Numero entity);
	
	public Numero persist(Numero entity);
	
}
