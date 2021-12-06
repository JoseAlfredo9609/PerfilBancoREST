package com.ibm.academia.apirest.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.apirest.entities.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> 
{
	@Query("select c from Cliente c where c.nombre = ?1 and c.apellido = ?2")
	public Optional<Cliente> buscarPorNombreYApellido(String nombre, String apellido);
	
	@Query("select c from Cliente c where c.pasion = ?1")
	public Optional<Cliente> buscarPorPasion(String pasion);
	
	@Query("select c from Cliente c where c.salarioMensual = ?1")
	public Optional<Cliente> buscarPorSalario(Integer salarioMensual);
	
	@Query("select c from Cliente c where c.edad = ?1")
	public Optional<Cliente> buscarPorEdad(Integer edad);

}
