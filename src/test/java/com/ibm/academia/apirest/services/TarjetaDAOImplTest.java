package com.ibm.academia.apirest.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.models.entities.Tarjeta;
import com.ibm.academia.apirest.repositories.TarjetaRepository;

public class TarjetaDAOImplTest 
{
	TarjetaDAO tarjetaDao;
	TarjetaRepository tarjetaRepository;
	
	@BeforeEach
	void setUp()
	{
		tarjetaRepository = mock(TarjetaRepository.class);
		tarjetaDao = new TarjetaDAOImpl(tarjetaRepository);
	}
	  
	@Test
	@DisplayName("Test: Buscar tarjeta por numero")
	void buscarPorNumero() 
	{
		//Given 
		Integer numero1 = 1234;
		when(tarjetaRepository.buscarPorNumero(numero1))
				.thenReturn(DatosDummy.tarjeta01());
		
		//When
		Tarjeta expected = tarjetaDao.buscarPorNumero(numero1);
		
		//Then
		assertThat(expected.equals(DatosDummy.tarjeta01()));
		
	}
	
	@Test
	@DisplayName("Test: Buscar tarjeta por tipo")
	void findTarjetasBytipoTarjeta() 
	{	
		//Given 
		String tipo = "Bsmart";
		when(tarjetaRepository.findTarjetasBytipoTarjeta(tipo))
				.thenReturn(Arrays.asList(DatosDummy.tarjeta01()));
			
		//When
		List<Tarjeta> expected = (List<Tarjeta>) tarjetaDao.findTarjetasBytipoTarjeta(tipo);
		
		//Then
		assertThat(expected.get(0)).isEqualTo(DatosDummy.tarjeta01());
	}
	
}
