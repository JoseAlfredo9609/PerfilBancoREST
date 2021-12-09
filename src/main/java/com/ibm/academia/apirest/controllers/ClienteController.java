package com.ibm.academia.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.ibm.academia.apirest.mapper.ClienteMapper;
import com.ibm.academia.apirest.models.dto.ClienteDTO;
import com.ibm.academia.apirest.models.entities.Cliente;
import com.ibm.academia.apirest.services.ClienteDAO;

@RestController
@RequestMapping("/cliente")
public class ClienteController 
{
	@Autowired
	private ClienteDAO clienteDao;
	
	Logger logger = LoggerFactory.getLogger(ClienteController.class);
	
	/**Endpoint para buscar todos los clientes
	 * @return Retorna una lista de todos los ojetos tipo cliente
	 * BadRequestException En caso de que falle buscando todos los ojetos tipo cliente
	 * author JAMR - 08/12/2021
	 */
	@GetMapping("/clientes")
	public ResponseEntity<?> buscartodos()
	{
		List<Cliente> clientes = (List<Cliente>) clienteDao.buscarTodos();
		
		if(clientes.isEmpty())
			throw new BadRequestException("No existen clientes");
		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);  
	}
	
	/**
	 * Endpoint para buscar un cliente
	 * @param clienteId Parametro para buscar cliente
	 * @return Retorna un objeto tipo Cliente
	 * BadRequestException En caso de que falle buscando a un ojeto tipo cliente.
	 * author JAMR - 08/12/2021
	 */
	@GetMapping("/id/{clienteId}")
	public ResponseEntity<?> buscarClientePorId(@PathVariable Integer clienteId) 
	{
		Optional<Cliente> oCliente =  clienteDao.buscarPorId(clienteId);		
		
		if(!oCliente.isPresent())
			throw new BadRequestException(String.format("El cliente con ID %d noexiste",clienteId));
		
		return new ResponseEntity<Cliente>(oCliente.get(), HttpStatus.OK);
	}
	
	/**
	 * Endpoint para crear un cliente
	 * @param cliente Parametro para buscar cliente
	 * @param result Parametro para buscar errores
	 * @return Un objeto tipo cliente creado
	 * ListaErrores En caso de que falle creando un objeto tipo cliente
	 * author JAMR - 08/12/2021
	 */
	@PostMapping
	public ResponseEntity<?> guardarCliente(@Valid @RequestBody Cliente cliente, BindingResult result) 
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
		
		Cliente clienteGuardado = clienteDao.guardar(cliente);
		return new ResponseEntity<Cliente>(clienteGuardado, HttpStatus.CREATED);
	}
	
	/**
	 * Endpoint para actualizar un objeto del tipo cliente
	 * @param clienteId Parámetro para buscar el cliente
	 * @param cliente Objeto con la informacion a modificar
	 * @return Retorna un objeto tipo Cliente con la informacion actualizada
	 * NotFoundException En caso de que falle actualizando el objeto cliente
	 * author JAMR - 08/12/2021
	 */
	@PutMapping("/upd/clienteId/{clienteId}")
	public ResponseEntity<?> actualizarCliente(@PathVariable Integer clienteId, @RequestBody Cliente cliente )
	{
		Optional<Cliente> oCliente = clienteDao.buscarPorId(clienteId);
		
		if(!oCliente.isPresent())
			throw new NotFoundException(String.format("Cliente con ID: %d no existe", clienteId));
		
		Cliente clienteActualizado = clienteDao.actualizar(oCliente.get(), cliente);
		return new ResponseEntity<Cliente>(clienteActualizado, HttpStatus.OK);
	}
	
	/**
	 * Endpoint para eliminar cliente
	 * @param clienteId Parametro para buscar cliente
	 * @return Retornar respuesta de objeto tipo cliente eliminado
	 * NotFoundException En caso de que falle eliminando el objeto cliente
	 * author JAMR - 08/12/2021
	 */
	@DeleteMapping("/clienteId/{clienteId}")
	public ResponseEntity<?> eliminarCarrera(@PathVariable Integer clienteId)
	{
		Map<String, Object> respuesta = new HashMap<String, Object>();
		
		Optional<Cliente> cliente = clienteDao.buscarPorId(clienteId);
		
		if(!cliente.isPresent())
			throw new NotFoundException(String.format("Cliente con ID: %d no existe", clienteId));
		
		clienteDao.eliminarPorId(clienteId);
		respuesta.put("OK", "Cliente ID: " + clienteId + " eliminado exitosamente");
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.ACCEPTED);
		
	}
	
	/**
	 * Endpoint para leer clientes con patron diseño DTO
	 * @return  Retorna un objeto tipo cliente con solo la informacion necesaria.
	 *  NotFoundException En caso de que falle buscando el objeto cliente
	 *  author JAMR - 08/12/2021
	 */
	@GetMapping("/clientes/dto")
	public ResponseEntity<?> obtenerClientesDTO()
	{
		List<Cliente> clientes = (List<Cliente>) clienteDao.buscarTodos();
		
		if(clientes.isEmpty())
			throw new NotFoundException("No existen carreras en la base de datos.");
		
		List<ClienteDTO> listaClientes = clientes
				.stream()
				.map(ClienteMapper::mapCliente)
				.collect(Collectors.toList());
		
		return new ResponseEntity<List<ClienteDTO>>(listaClientes, HttpStatus.OK);  
	}
	
}
	
