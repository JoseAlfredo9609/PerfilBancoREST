package com.ibm.academia.apirest.datos;

import com.ibm.academia.apirest.entities.Cliente;

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
	
}
