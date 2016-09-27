package com.viewnextfor.libreria.servicio.cuenta;

import com.viewnextfor.libreria.configuracion.ConfiguracionLibreria;
import com.viewnextfor.libreria.servicio.ServicioCuenta;

public class ServicioCuentaFactoria {

	public static ServicioCuenta getInstance(){
		boolean ioc = ConfiguracionLibreria.isIoc();
		return ioc?new ServicioCuentaImpl():
				ServicioCuentaImpl.getInstance();
	}
}
