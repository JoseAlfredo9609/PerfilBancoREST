package com.ibm.academia.apirest.services;

import java.util.Optional;

import com.ibm.academia.apirest.entities.Cliente;

public interface ClienteDAO extends GenericoDAO<Cliente>
{
	public Optional<Cliente> buscarPorNombreYApellido(String nombre, String apellido);
	
	public Optional<Cliente> buscarPorPasion(String pasion);
	
	public Optional<Cliente> buscarPorSalario(Integer salarioMensual);
	
	public Optional<Cliente> buscarPorEdad(Integer edad);
}
