package com.ignacioore.numbergenerator.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ignacioore.numbergenerator.model.Numero;
import com.ignacioore.numbergenerator.service.NumeroService;

@RestController
@RequestMapping("")
public class NumeroRestController {
	@Autowired
	private NumeroService numeroService;
	
	@GetMapping (value= "", produces = "application/json")
	public ResponseEntity<List<Numero>> getAllNumero(){
		
		List<Numero> numeros = numeroService.getAllNumero();
		
		if(!numeros.isEmpty()) {
			return new ResponseEntity<List <Numero>>(numeros,HttpStatus.OK);
		}
		return new ResponseEntity<List<Numero>>(HttpStatus.NOT_FOUND);
			
	}
	
	@PostMapping(value = "/agregar", produces ="application/json")
	public ResponseEntity<Numero> addNumero(@RequestBody Numero numero) {
		
		try {
			numeroService.save(numero);
			return new ResponseEntity<Numero> (numero, HttpStatus.CREATED);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Numero>(HttpStatus.BAD_REQUEST);
		}
		
		
	}
}
