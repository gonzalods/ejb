package com.viewnextfor.libreria.bean;

import com.viewnextfor.libreria.dominio.carrito.Carrito;
import com.viewnextfor.libreria.dto.DetalleCarrito;
import com.viewnextfor.libreria.dto.Usuario;
import com.viewnextfor.libreria.ensamblador.DetalleCarritoDtoEnsamblador;

public class CarritoBean {

	private Usuario usuario;
	private Carrito carrito;
	private DetalleCarrito detalleCarrito;
	private String cantidad;
	private String idEliminar;
	
	public CarritoBean() {
		this(null,null);
	}
	public CarritoBean(Usuario usuario, Carrito carrito) {
		super();
		this.usuario = usuario;
		this.carrito = carrito;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Carrito getCarrito() {
		return carrito;
	}
	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}
	public DetalleCarrito getDetalleCarrito() {
		return detalleCarrito;
	}
	public void setDetalleCarrito(DetalleCarrito detalleCarrito) {
		this.detalleCarrito = detalleCarrito;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getIdEliminar() {
		return idEliminar;
	}
	public void setIdEliminar(String idEliminar) {
		this.idEliminar = idEliminar;
	}
	public String detalle(){
		DetalleCarritoDtoEnsamblador ensambaldor = new DetalleCarritoDtoEnsamblador();
		detalleCarrito = ensambaldor.toDto(carrito);
		return "/WEB-INF/paginas/carrito/detalleCarrito.jsp";
	}
	public String elimiarItem(){
		Long id = Long.valueOf(idEliminar);
		carrito.removeItem(id);
		if(carrito.getCantidad()==0){
			carrito = null;
			return "catalogo";
		}else{
			DetalleCarritoDtoEnsamblador ensambaldor = new DetalleCarritoDtoEnsamblador();
			detalleCarrito = ensambaldor.toDto(carrito);
			return"/WEB-INF/paginas/carrito/detalleCarrito.jsp";
		}
	}
}
