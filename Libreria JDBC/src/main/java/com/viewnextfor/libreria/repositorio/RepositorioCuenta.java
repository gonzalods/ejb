package com.viewnextfor.libreria.repositorio;

import com.viewnextfor.libreria.dominio.cuenta.Cuenta;

public interface RepositorioCuenta {

	
	public void crearCuenta(Cuenta cuenta);
	public void actualizarCuenta(Cuenta cuenta);	
	public Cuenta obtenerCuenta(String nombreUsu);
 
}
