package com.viewnextfor.libreria.dominio.orden;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.viewnextfor.libreria.dominio.cuenta.Direccion;

public class OrdenCompra implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Direccion direccionEntrega;
	private Direccion direccionCobro;
	private boolean cobroIgualEntrega = true;
	private String email;
	private Date fechaOrden;
	private Date fechaEntrega;
	private BigDecimal precioTotalOrden;
	private String nombreususario;
	private List<DetalleOrdenCompra> detallesOrden = new ArrayList<DetalleOrdenCompra>();
	
	public OrdenCompra() {
		super();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Direccion getDireccionEntrega() {
		return direccionEntrega;
	}
	public void setDireccionEntrega(Direccion direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}
	public Direccion getDireccionCobro() {
		return direccionCobro;
	}
	public void setDireccionCobro(Direccion direccionCobro) {
		this.direccionCobro = direccionCobro;
	}
	public boolean isCobroIgualEntrega() {
		return cobroIgualEntrega;
	}
	public void setCobroIgualEntrega(boolean cobroIgualEntrega) {
		this.cobroIgualEntrega = cobroIgualEntrega;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getFechaOrden() {
		return fechaOrden;
	}
	public void setFechaOrden(Date fechaOrden) {
		this.fechaOrden = fechaOrden;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public BigDecimal getPrecioTotalOrden() {
		return precioTotalOrden;
	}
	public void setPrecioTotalOrden(BigDecimal precioTotalOrden) {
		this.precioTotalOrden = precioTotalOrden;
	}
	public String getNombreususario() {
		return nombreususario;
	}

	public void setNombreususario(String nombreususario) {
		this.nombreususario = nombreususario;
	}

	public List<DetalleOrdenCompra> getDetallesOrden() {
		return detallesOrden;
	}
	public void setDetallesOrden(List<DetalleOrdenCompra> detallesOrden) {
		this.detallesOrden = detallesOrden;
	}
}
