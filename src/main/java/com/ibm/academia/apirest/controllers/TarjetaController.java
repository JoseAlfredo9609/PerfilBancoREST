package com.ibm.academia.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.apirest.exceptions.BadRequestException;
import com.ibm.academia.apirest.exceptions.NotFoundException;
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
	
	/**
	 * Endpoint para buscar una tarjeta
	 * @param tarjetaId Parametro para buscar tarjeta
	 * @return Retorna un objeto tipo tarjeta
	 * BadRequestException En caso de que falle buscando a un ojeto tipo tarjeta.
	 * author JAMR - 08/12/2021
	 */
	@GetMapping("/id/{tarjetaId}")
	public ResponseEntity<?> buscarTarjetaPorId(@PathVariable Integer tarjetaId) 
	{
		Optional<Tarjeta> oTarjeta =  tarjetaDao.buscarPorId(tarjetaId);		
		
		if(!oTarjeta.isPresent())
			throw new BadRequestException(String.format("La tarjeta con ID %d noexiste",tarjetaId));
		
		return new ResponseEntity<Tarjeta>(oTarjeta.get(), HttpStatus.OK);
	}
	
	/**
	 * Endpoint para crear una tarjeta
	 * @param tarjeta Parametro para buscar cliente
	 * @param result Parametro para buscar errores
	 * @return Un objeto tipo tarjeta creado
	 * ListaErrores En caso de que falle creando un objeto tipo tarjeta
	 * author JAMR - 08/12/2021
	 */
	@PostMapping
	public ResponseEntity<?> guardarTarjeta(@Valid @RequestBody Tarjeta tarjeta, BindingResult result) 
	{
		Map<String, Object> validaciones = new HashMap<String, Object>();
		
		if(result.hasErrors())
		{
			List<String> listaErrores = result.getFieldErrors()
					.stream()
					.map(errores -> "Campo: '" + errores.getField() + "' " + errores.getDefaultMessage())
					.collect(Collectors.toList());
			validaciones.put("Lista Errores", listaErrores);
			return new ResponseEntity<Map<String, Object>>(validaciones, HttpStatus.BAD_REQUEST);
		}	
		
		Tarjeta tarjetaGuardada = tarjetaDao.guardar(tarjeta);
		return new ResponseEntity<Tarjeta>(tarjetaGuardada, HttpStatus.CREATED);
	}
	
	/**
	 * Endpoint para actualizar un objeto del tipo tarjeta
	 * @param tarjetaId Parámetro para buscar tarjeta
	 * @param tarjeta Objeto con la informacion a modificar
	 * @return Retorna un objeto tipo tarjeta con la informacion actualizada
	 * NotFoundException En caso de que falle actualizando el objeto tarjeta
	 * author JAMR - 08/12/2021
	 */
	@PutMapping("/upd/tarjetaId/{tarjetaId}")
	public ResponseEntity<?> actualizarTarjeta(@PathVariable Integer tarjetaId, @RequestBody Tarjeta tarjeta )
	{
		Optional<Tarjeta> oTarjeta = tarjetaDao.buscarPorId(tarjetaId);
		
		if(!oTarjeta.isPresent())
			throw new NotFoundException(String.format("Tarjeta con ID: %d no existe", tarjetaId));
		
		Tarjeta tarjetaActualizada = tarjetaDao.actualizar(oTarjeta.get(), tarjeta);
		return new ResponseEntity<Tarjeta>(tarjetaActualizada, HttpStatus.OK);
	}
	
	/**
	 * Endpoint para eliminar tarjeta
	 * @param tarjetaId Parametro para buscar tarjeta
	 * @return Retornar respuesta de objeto tipo tarjeta eliminado
	 * NotFoundException En caso de que falle eliminando el objeto tarjeta
	 * author JAMR - 08/12/2021
	 */
	@DeleteMapping("/tarjetaId/{tarjetaId}")
	public ResponseEntity<?> eliminarCarrera(@PathVariable Integer tarjetaId)
	{
		Map<String, Object> respuesta = new HashMap<String, Object>();
		
		Optional<Tarjeta> tarjeta = tarjetaDao.buscarPorId(tarjetaId);
		
		if(!tarjeta.isPresent())
			throw new NotFoundException(String.format("Cliente con ID: %d no existe", tarjetaId));
		
		tarjetaDao.eliminarPorId(tarjetaId);
		respuesta.put("OK", "Cliente ID: " + tarjetaId + " eliminado exitosamente");
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.ACCEPTED);
	}
}
