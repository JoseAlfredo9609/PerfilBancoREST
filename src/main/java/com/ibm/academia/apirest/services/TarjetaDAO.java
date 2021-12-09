package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.models.entities.Tarjeta;

public interface TarjetaDAO extends GenericoDAO<Tarjeta> 
{
	public Tarjeta buscarPorNumero(Integer numero);
	
	public Iterable<Tarjeta> findTarjetasBytipoTarjeta(String tipoTarjeta);

}
