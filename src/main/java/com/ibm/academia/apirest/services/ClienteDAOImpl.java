package com.ibm.academia.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.academia.apirest.models.entities.Cliente;
import com.ibm.academia.apirest.repositories.ClienteRepository;

@Service
public class ClienteDAOImpl extends GenericoDAOImpl<Cliente, ClienteRepository>implements ClienteDAO
{

	@Autowired
	public ClienteDAOImpl(ClienteRepository repository) 
	{
		super(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente buscarPorNombreYApellido(String nombre, String apellido) 
	{
		
		return repository.buscarPorNombreYApellido(nombre, apellido);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Cliente> findClientesByedad(Integer edad) 
	{
		return repository.findClientesByedad(edad);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Cliente> findClientesBysalarioMensual(Integer salarioMensual)
	{
		return repository.findClientesBysalarioMensual(salarioMensual);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Cliente> findClientesBypasion(String pasion) 
	{
		return repository.findClientesBypasion(pasion);
	}

	@Override
	@Transactional
	public Cliente actualizar(Cliente clienteEncontrado, Cliente cliente) 
	{
		Cliente clienteActualizado = null;
		clienteEncontrado.setSalarioMensual(cliente.getSalarioMensual());
		clienteEncontrado.setEdad(cliente.getEdad());
		clienteEncontrado.setPasion(cliente.getPasion());
		clienteActualizado = repository.save(clienteEncontrado);
		return clienteActualizado;
	}

}
