package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.models.entities.Cliente;

public interface ClienteDAO extends GenericoDAO<Cliente>
{
	public Cliente buscarPorNombreYApellido(String nombre, String apellido);
	
	public Iterable<Cliente> findClientesByedad(Integer edad);
	
	public Iterable<Cliente> findClientesBysalarioMensual(Integer salarioMensual);
	
	public Iterable<Cliente> findClientesBypasion(String pasion);
	
	public Cliente actualizar(Cliente clienteEncontrado, Cliente clienteActualizar); 

}
