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
import com.ibm.academia.apirest.models.entities.Cliente;
import com.ibm.academia.apirest.repositories.ClienteRepository;

public class ClienteDAOImplTest 
{
	ClienteDAO clienteDao;
	ClienteRepository clienteRepository;
	
	@BeforeEach
	void setUp() 
	{
		clienteRepository = mock(ClienteRepository.class);
		clienteDao = new ClienteDAOImpl(clienteRepository);
	}
	
	
	@Test
	@DisplayName("Test: Buscar cliente por edad")
	void findClientesByedad() 
	{	
		//Given 
		Integer edad1 = 19;
		when(clienteRepository.findClientesByedad(edad1))
				.thenReturn(Arrays.asList(DatosDummy.cliente01(), DatosDummy.cliente02()));
			
		//When
		List<Cliente> expected = (List<Cliente>) clienteDao.findClientesByedad(edad1);
		
		//Then
		assertThat(expected.get(0)).isEqualTo(DatosDummy.cliente01());
		assertThat(expected.get(1)).isEqualTo(DatosDummy.cliente02());
	}
	
	@Test
	@DisplayName("Test: Buscar cliente por salario mensual")
	void findClientesBysalarioMensual() 
	{	
		//Given 
		Integer salario = 18000;
		when(clienteRepository.findClientesBysalarioMensual(18000))
				.thenReturn(Arrays.asList(DatosDummy.cliente01(), DatosDummy.cliente02()));
			
		//When
		List<Cliente> expected = (List<Cliente>) clienteDao.findClientesBysalarioMensual(salario);
		
		//Then
		assertThat(expected.get(0)).isEqualTo(DatosDummy.cliente01());
		assertThat(expected.get(1)).isEqualTo(DatosDummy.cliente02());
	}
	
	@Test
	@DisplayName("Test: Buscar cliente por pasion")
	void findClientesBypasion() 
	{	
		//Given 
		String passion = "Travels";
		when(clienteRepository.findClientesBypasion(passion))
				.thenReturn(Arrays.asList(DatosDummy.cliente01(), DatosDummy.cliente02()));
			
		//When
		List<Cliente> expected = (List<Cliente>) clienteDao.findClientesBypasion(passion);
		
		//Then
		assertThat(expected.get(0)).isEqualTo(DatosDummy.cliente01());
		assertThat(expected.get(1)).isEqualTo(DatosDummy.cliente02());
	}
	
	@Test
	@DisplayName("Test: Buscar cliente por nombre y apellido")
	void buscarPorNombreYApellido()
	{
		//Given
		String name = "Juan";
		String surname = "Barrera";
		when(clienteRepository.buscarPorNombreYApellido(name, surname))
				.thenReturn(DatosDummy.cliente01());
		
		//When 
		Cliente expected = clienteDao.buscarPorNombreYApellido(name, surname);
		
		//Then
		assertThat(expected.equals(DatosDummy.cliente01()));
	}	
}
