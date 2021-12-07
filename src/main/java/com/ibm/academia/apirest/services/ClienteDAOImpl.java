package com.ibm.academia.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.academia.apirest.entities.Cliente;
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
	public Cliente buscarPorNombreYApellido(String nombre, String apellido) 
	{
		
		return repository.buscarPorNombreYApellido(nombre, apellido);
	}

	@Override
	public Iterable<Cliente> findClientesByedad(Integer edad) 
	{
		return repository.findClientesByedad(edad);
	}

	@Override
	public Iterable<Cliente> findClientesBysalarioMensual(Integer salarioMensual)
	{
		return repository.findClientesBysalarioMensual(salarioMensual);
	}

	@Override
	public Iterable<Cliente> findClientesBypasion(String pasion) 
	{
		return repository.findClientesBypasion(pasion);
	}

}
