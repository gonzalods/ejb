package com.viewnextfor.servicio;

import javax.enterprise.inject.Produces;

import com.viewnextfor.bean.SaludoBean;

public class ServicioSaludoFactory {

	@Produces
	public ServicioSaludo crearServicioSaludo(SaludoBean saludo){
		return new SaludoNewApi("Bienvenido a nuestro programa CDI", saludo);
	}
}
