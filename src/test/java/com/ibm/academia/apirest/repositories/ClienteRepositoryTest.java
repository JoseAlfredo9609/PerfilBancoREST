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
		clienteRepository.save(DatosDummy.cliente02());
		
	}
	
	@AfterEach
	void tearDown() 
	{
		clienteRepository.deleteAll();
	}
	
	@Test
	@DisplayName("Test: Buscar cliente por nombre y apellido")
	void buscarPorNombreYApellido() 
	{	
		//Given 
		/*clienteRepository.save(DatosDummy.cliente01());*/
		
		//When
		Cliente expected = clienteRepository.buscarPorNombreYApellido(DatosDummy.cliente01().getNombre(),DatosDummy.cliente01().getApellido());
		
		//Then
		assertThat(expected).isInstanceOf(Cliente.class);	
	}
	
	@Test
	@DisplayName("Test: Buscar cliente por edad") 	
	void findClientesByedad()
	
	{
		//When
		List<Cliente> expected = (List<Cliente>) clienteRepository.findClientesByedad(19);
		
		//Then
		assertThat(expected.size() == 2).isTrue();
	}
	
	@Test
	@DisplayName("Test: Buscar cliente por salario mensual")
	void findClientesBysalarioMensual() 
	{
		//When
		List<Cliente> expected = (List<Cliente>) clienteRepository.findClientesBysalarioMensual(20000);
		
		//Then
		assertThat(expected.size() == 1).isTrue();
	}
	
	@Test
	@DisplayName("Test: Buscar cliente por pasion")
	void findClientesBypasion() 
	{
		//when
		List<Cliente> expected = (List<Cliente>) clienteRepository.findClientesBypasion("Shopping");
		
		//Then
		assertThat(expected.size() == 2).isTrue();
	}
}
