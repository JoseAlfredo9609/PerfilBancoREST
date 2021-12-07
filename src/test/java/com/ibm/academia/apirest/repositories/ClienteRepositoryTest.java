package com.ibm.academia.apirest.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.entities.Cliente;

@DataJpaTest
public class ClienteRepositoryTest 
{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@BeforeEach
	void setUp() 
	{
		//Given 
				clienteRepository.save(DatosDummy.cliente01());
	}
	
	@AfterEach
	void tearDown() 
	{
		clienteRepository.deleteAll();
	}
	
	@Test
	@DisplayName("Test: Buscar persona por nombre y apellido")
	void buscarPorNombreYApellido() 
	{	
		//Given 
		/*clienteRepository.save(DatosDummy.cliente01());*/
		
		//When
		Optional<Cliente> expected = clienteRepository.buscarPorNombreYApellido(DatosDummy.cliente01().getNombre(),DatosDummy.cliente01().getApellido());
		
		//Then
		assertThat(expected.get()).isInstanceOf(Cliente.class);	
	}
}
