package com.ibm.academia.apirest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.academia.apirest.entities.Cliente;
import com.ibm.academia.apirest.repositories.ClienteRepository;

@Service
public class ClienteDAOImpl extends GenericoDAOImpl<Cliente, ClienteRepository>implements ClienteDAO
{

	@Autowired
	public ClienteDAOImpl(ClienteRepository repository) {
		super(repository);
	}

	@Override
	public Optional<Cliente> buscarPorNombreYApellido(String nombre, String apellido) 
	{
		
		return repository.buscarPorNombreYApellido(nombre, apellido);
	}

	@Override
	public Optional<Cliente> buscarPorPasion(String pasion) 
	{
		return repository.buscarPorPasion(pasion);
	}

	@Override
	public Optional<Cliente> buscarPorSalario(Integer salarioMensual) 
	{
		return repository.buscarPorSalario(salarioMensual);
	}

	@Override
	public Optional<Cliente> buscarPorEdad(Integer edad) 
	{
		return repository.buscarPorEdad(edad);
	}
	

}
