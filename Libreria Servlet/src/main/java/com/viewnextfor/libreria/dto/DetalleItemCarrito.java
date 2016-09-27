package com.viewnextfor.libreria.dto;

public class DetalleItemCarrito {

	private String idLibro;
	private String titulo;
	private String cantidad;
	private String precio;
	private String totalItem;
	public DetalleItemCarrito() {
		super();
	}
	public DetalleItemCarrito(String idLibro, 
			String titulo, String cantidad, 
			String precio, String totalItem) {
		super();
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.cantidad = cantidad;
		this.precio = precio;
		this.totalItem = totalItem;
	}
	public String getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(String idLibro) {
		this.idLibro = idLibro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(String totalItem) {
		this.totalItem = totalItem;
	}
	
}
