package com.viewnextfor.libreria.util;

import com.viewnextfor.libreria.dominio.cuenta.Cuenta;

public class AlmacenamientoLocal {

	public static final ThreadLocal<Cuenta> cuentaLocal = new ThreadLocal<Cuenta>();
	
	public static void set(Cuenta cuenta){
		cuentaLocal.set(cuenta);
	}
	
	public static void unset(){
		cuentaLocal.remove();
	}
	
	public static Cuenta get(){
		return cuentaLocal.get();
	}
}
