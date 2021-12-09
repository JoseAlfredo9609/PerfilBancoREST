package com.ibm.academia.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.academia.apirest.models.entities.Tarjeta;
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
	public Tarjeta buscarPorNumero(Integer numero) {
		return repository.buscarPorNumero(numero);
	}

	@Override
	public Iterable<Tarjeta> findTarjetasBytipoTarjeta(String tipoTarjeta) {
		return repository.findTarjetasBytipoTarjeta(tipoTarjeta);
	}

	@Override
	public Tarjeta actualizar(Tarjeta tarjetaEncontrada, Tarjeta tarjeta) {
		Tarjeta tarjetaActualizada = null;
		tarjetaEncontrada.setNumero(tarjeta.getNumero());
		tarjetaEncontrada.setTipoTarjeta(tarjeta.getTipoTarjeta());
		tarjetaEncontrada.setVigencia(tarjeta.getVigencia());
		tarjetaActualizada = repository.save(tarjetaEncontrada);
		return tarjetaActualizada;
	}	
}
