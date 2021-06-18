package com.ignacioore.numbergenerator.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ignacioore.numbergenerator.model.Numero;
import com.ignacioore.numbergenerator.repository.NumeroRepository;

@Service
public class NumeroService {
	@Autowired
	private NumeroRepository repo;
	
	public List<Numero> getAllNumero() {
		return repo.findAll();
	}
	
	public List<Numero> getAllNumero(int inicio, int fin) {
		List<Numero> allNumero = repo.findAll();
		List<Numero> range = new ArrayList<Numero>();
		for (Numero num : allNumero) {
			if (num.getNumero() >= inicio && num.getNumero() <= fin) {
				range.add(num);
			}
		}
		return range;
	}
	
	public Numero save(Numero entity) {
		Numero num = repo.save(entity);
		return num;
	}
	
	public void delete(Numero entity) {
		repo.delete(entity);
	}
	
	
}
