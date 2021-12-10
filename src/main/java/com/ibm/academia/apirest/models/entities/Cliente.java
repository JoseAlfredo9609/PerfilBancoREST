package com.ibm.academia.apirest.models.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
//@Table(name = "clientes", schema = "perfil")
@Table(name = "clientes")
public class Cliente implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "No puede ser nulo")
	@NotEmpty(message = "No puede ser vacio")
	private String nombre;
	
	private String apellido;
	
	private String pasion;
	
	@Positive(message = "Debe ser mayor a cero")
	@Column (name = "salario_mensual")
	private Integer salarioMensual;
	
	@Positive(message = "Debe ser mayor a cero")
	private Integer edad;
	
	@Column(name = "fecha_alta")
	private Date fechaAlta;
	
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@ManyToOne(optional = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"tarjeta"})
	@JoinColumn(name = "tarjeta_id")
	private Tarjeta tarjeta;

	public Cliente(Integer id, String nombre, String apellido, String pasion, Integer salarioMensual, Integer edad) 
	{
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.pasion = pasion;
		this.salarioMensual = salarioMensual;
		this.edad = edad;
	}
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", pasion=" + pasion + ", salarioMensual=" + salarioMensual
				+ ", edad=" + edad + "]";
	}

	@Override
	public int hashCode() 
	{
		return Objects.hash(id, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
	}
	
	@PrePersist
	private void antesPersistir() 
	{
		this.fechaAlta = new Date();	
	}
	
	@PreUpdate 
	private void antesActualizar() 
	{
		this.fechaModificacion = new Date();	
	}
	
	private static final long serialVersionUID = -2614503563982312577L;	
}
