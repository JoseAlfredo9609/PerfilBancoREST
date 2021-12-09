package com.ibm.academia.apirest.mapper;

import com.ibm.academia.apirest.models.dto.ClienteDTO;
import com.ibm.academia.apirest.models.entities.Cliente;

public class ClienteMapper 
{
	public static ClienteDTO mapCliente(Cliente cliente)
	{
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(cliente.getId());
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setApellido(cliente.getApellido());
        clienteDTO.setEdad(cliente.getEdad());
        clienteDTO.setSalarioMensual(cliente.getSalarioMensual());
        clienteDTO.setPasion(cliente.getPasion());
        
        return clienteDTO;
	}

}
