package com.viewnextfor.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("saludo")
@RequestScoped
public class SaludoBean {

	private String nombre;
	private String saludo;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSaludo() {
		return saludo;
	}
	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}
}
