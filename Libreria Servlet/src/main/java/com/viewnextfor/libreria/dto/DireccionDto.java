package com.viewnextfor.libreria.dto;

public class DireccionDto {

	public String calle;
	public String numero;
	public String piso;
	public String ciudad;
	public String codigoPostal;
	public String getCalle() {
		return calle;
	}
	public DireccionDto setCalle(String calle) {
		this.calle = calle;
		return this;
	}
	public String getNumero() {
		return numero;
	}
	public DireccionDto setNumero(String numero) {
		this.numero = numero;
		return this;
	}
	public String getPiso() {
		return piso;
	}
	public DireccionDto setPiso(String piso) {
		this.piso = piso;
		return this;
	}
	public String getCiudad() {
		return ciudad;
	}
	public DireccionDto setCiudad(String ciudad) {
		this.ciudad = ciudad;
		return this;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public DireccionDto setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
		return this;
	}
	
	
}
