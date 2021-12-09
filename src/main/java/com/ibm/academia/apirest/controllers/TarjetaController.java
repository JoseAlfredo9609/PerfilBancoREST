package com.ibm.academia.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.apirest.exceptions.BadRequestException;
import com.ibm.academia.apirest.models.entities.Tarjeta;
import com.ibm.academia.apirest.services.TarjetaDAO;

@RestController
@RequestMapping("/tarjeta")
public class TarjetaController 
{
	@Autowired
	private TarjetaDAO tarjetaDao;
	
	
	@GetMapping("/tarjetas")
	public ResponseEntity<?> buscartodos()
	{
		List<Tarjeta> tarjetas = (List<Tarjeta>) tarjetaDao.buscarTodos();
		if(tarjetas.isEmpty())
			throw new BadRequestException("No existen clientes");
		return new ResponseEntity<List<Tarjeta>>(tarjetas, HttpStatus.OK);  
	}
	
	
}
