package com.ibm.academia.apirest.models.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
//@Table(name = "tarjetas", schema = "perfil")
@Table(name = "tarjetas")
public class Tarjeta implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer numero;
	
	@Column(name = "tipo_tarjeta")
	private String tipoTarjeta;
	
	private String vigencia;
	
	@Column(name = "fecha_alta")
	private Date fechaAlta;
	
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@OneToMany(mappedBy =  "tarjeta", fetch =  FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "tarjeta"})
	private Set<Cliente> clientes;
	
	public Tarjeta(Integer id, Integer numero, String tipoTarjeta, String vigencia) {
		super();
		this.id = id;
		this.numero = numero;
		this.tipoTarjeta = tipoTarjeta;
		this.vigencia = vigencia;
	}

	@Override
	public int hashCode() 
	{
		return Objects.hash(id, tipoTarjeta);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarjeta other = (Tarjeta) obj;
		return Objects.equals(id, other.id) && tipoTarjeta == other.tipoTarjeta;
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
	
	@Override
	public String toString() {
		return "Tarjeta [id=" + id + ", numero=" + numero + ", tipoTarjeta=" + tipoTarjeta + ", vigencia=" + vigencia
				+ "]";
	}

	private static final long serialVersionUID = 2911762464333103201L;
	
}
