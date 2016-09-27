package com.viewnextfor.libreria.servicio;

import com.viewnextfor.libreria.dominio.cuenta.Cuenta;


public interface ServicioCuenta {

	public Cuenta obtener(String nombreUsu);
	public void actualizar(Cuenta cuenta);
}
