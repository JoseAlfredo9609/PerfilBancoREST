package com.ibm.academia.apirest.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.apirest.entities.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> 
{
	@Query("select c from Cliente c where c.nombre = ?1 and c.apellido = ?2")
	public Cliente buscarPorNombreYApellido(String nombre, String apellido);
	
	public Iterable<Cliente> findClientesByedad(Integer edad);
	
	public Iterable<Cliente> findClientesBysalarioMensual(Integer salarioMensual);
	
	public Iterable<Cliente> findClientesBypasion(String pasion);

}
