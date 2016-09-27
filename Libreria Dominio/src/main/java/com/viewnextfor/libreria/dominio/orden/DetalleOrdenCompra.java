package com.viewnextfor.libreria.dominio.orden;

import java.io.Serializable;
import java.math.BigDecimal;

public class DetalleOrdenCompra implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private BigDecimal precio;
	private int cantidad;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
