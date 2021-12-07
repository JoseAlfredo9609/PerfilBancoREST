package com.ibm.academia.apirest.datos;

import com.ibm.academia.apirest.entities.Cliente;
import com.ibm.academia.apirest.entities.Tarjeta;

public class DatosDummy 
{
	public static Cliente cliente01()
	{
		return new Cliente(null, "Juan", "Barrera", "Shopping",18000, 19);
	}
	
	public static Cliente cliente02()
	{
		return new Cliente(null, "Luis", "Ortiz", "Shopping",20000, 19);
	}
	
	public static Tarjeta tarjeta01()
	{
		return new Tarjeta(null, 1234, "Bsmart", "2025");
	}
	
}
