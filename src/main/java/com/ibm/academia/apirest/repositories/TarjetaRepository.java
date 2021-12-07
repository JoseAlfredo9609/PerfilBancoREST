package com.ibm.academia.apirest.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.apirest.entities.Tarjeta;

@Repository
public interface TarjetaRepository extends CrudRepository<Tarjeta, Integer> 
{
	@Query("select t from Tarjeta t where t.numero = ?1")
	public Tarjeta buscarPorNumero(Integer numero);
	
	public Iterable<Tarjeta> findTarjetasBytipoTarjeta(String tipoTarjeta);

}
