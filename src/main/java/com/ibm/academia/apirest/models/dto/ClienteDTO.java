package com.ibm.academia.apirest.models.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO 
{
	private Integer id;
	
	@NotNull(message = "No puede ser nulo")
	@NotEmpty(message = "No puede ser vacio")
	private String nombre;
	
	private String apellido;
	
	private String pasion;
	
	@Positive(message = "Debe ser mayor a cero")
	private Integer salarioMensual;
	
	@Positive(message = "Debe ser mayor a cero")
	private Integer edad;
	
}
