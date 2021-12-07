package com.ibm.academia.apirest.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.entities.Tarjeta;

@DataJpaTest
public class TarjetaRepositoryTest 
{
	@Autowired
	private TarjetaRepository tarjetaRepository;
	
	@BeforeEach
	void setUp() 
	{
		//Given 
		tarjetaRepository.save(DatosDummy.tarjeta01());
	}
	
	@AfterEach
	void tearDown() 
	{
		tarjetaRepository.deleteAll();
	}
	
	@Test
	@DisplayName("Test: Buscar tarjeta por tipo de tarjeta")
	void findTarjetasBytipoTarjeta() 
	{	
		//Given 
		/*tarjetaRepository.save(DatosDummy.tarjeta01());*/
		
		//When
		List<Tarjeta> expected = (List<Tarjeta>) tarjetaRepository.findTarjetasBytipoTarjeta("Bsmart");
		
		//Then
		assertThat(expected.size() == 1).isTrue();
	}
	
	@Test
	@DisplayName("Test: Buscar tarjeta por numero")
	void buscarPorNumero()
	{
		//Given 
		/*tarjetaRepository.save(DatosDummy.tarjeta01());*/
		
		//When
		Tarjeta expected = tarjetaRepository.buscarPorNumero(DatosDummy.tarjeta01().getNumero());
		
		//Then
		assertThat(expected).isInstanceOf(Tarjeta.class);	
	}
	
	
}
