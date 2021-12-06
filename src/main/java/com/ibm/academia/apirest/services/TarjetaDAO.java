package com.ibm.academia.apirest.services;

import java.util.Optional;

import com.ibm.academia.apirest.entities.Tarjeta;

public interface TarjetaDAO extends GenericoDAO<Tarjeta> 
{
	public Optional<Tarjeta> buscarPorNumero(Integer numero);
	
	public Optional<Tarjeta> buscarPorTipoTarjeta(String tipoTarjeta);

}
