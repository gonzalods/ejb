package com.viewnextfor.servicio;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import com.viewnextfor.bean.SaludoBean;

public class ServicioSaludoFactory {

	@Produces
	@Inject
	public ServicioSaludo crearServicioSaludo(SaludoBean saludo){
		return new SaludoNewApi("Bienvenido a nuestro programa CDI", saludo);
	}
}
