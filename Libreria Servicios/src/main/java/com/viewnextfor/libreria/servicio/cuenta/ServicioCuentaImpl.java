package com.viewnextfor.libreria.servicio.cuenta;

import com.viewnextfor.libreria.dominio.cuenta.Cuenta;
import com.viewnextfor.libreria.repositorio.RepositorioCuenta;
import com.viewnextfor.libreria.repositorio.cuenta.RepositorioCuentaImpl;
import com.viewnextfor.libreria.servicio.ServicioCuenta;


public class ServicioCuentaImpl implements ServicioCuenta{

	private RepositorioCuenta repositorioCuenta;
	
	ServicioCuentaImpl() {
	}

	static ServicioCuenta getInstance(){
		ServicioCuentaImpl servicio = new ServicioCuentaImpl();
		servicio.inicializar();
		return servicio;
		
	}
	
	protected void inicializar(){
		repositorioCuenta = RepositorioCuentaImpl.getInstance();
	}
	
	@Override
	public Cuenta obtener(String nombreUsu){
		return repositorioCuenta.obtenerCuenta(nombreUsu);
	}
	
	@Override
	public void actualizar(Cuenta cuenta){
		repositorioCuenta.actualizarCuenta(cuenta);
	}



}
