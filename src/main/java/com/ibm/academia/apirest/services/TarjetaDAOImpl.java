package com.ibm.academia.apirest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.academia.apirest.entities.Tarjeta;
import com.ibm.academia.apirest.repositories.TarjetaRepository;

@Service
public class TarjetaDAOImpl extends GenericoDAOImpl<Tarjeta, TarjetaRepository> implements TarjetaDAO 
{

	@Autowired
	public TarjetaDAOImpl(TarjetaRepository repository) 
	{
		super(repository);
	}

	@Override
	public Optional<Tarjeta> buscarPorNumero(Integer numero) {
		return repository.buscarPorNumero(numero);
	}

	@Override
	public Optional<Tarjeta> buscarPorTipoTarjeta(String tipoTarjeta) {
		
		return repository.buscarPorTipoTarjeta(tipoTarjeta);
	}
}
