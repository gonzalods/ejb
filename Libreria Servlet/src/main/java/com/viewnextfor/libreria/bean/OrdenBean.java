package com.viewnextfor.libreria.bean;

import com.viewnextfor.libreria.dominio.carrito.Carrito;
import com.viewnextfor.libreria.dominio.cuenta.Cuenta;
import com.viewnextfor.libreria.dominio.orden.OrdenCompra;
import com.viewnextfor.libreria.dto.DetalleCarrito;
import com.viewnextfor.libreria.dto.DireccionDto;
import com.viewnextfor.libreria.dto.Usuario;
import com.viewnextfor.libreria.ensamblador.DetalleCarritoDtoEnsamblador;
import com.viewnextfor.libreria.ensamblador.DirecctionDtoEnsamblador;
import com.viewnextfor.libreria.servicio.ServicioCuenta;
import com.viewnextfor.libreria.servicio.ServicioOrdenCompra;
import com.viewnextfor.libreria.servicio.cuenta.ServicioCuentaFactoria;
import com.viewnextfor.libreria.servicio.orden.ServicioOrdenCompraImpl;

public class OrdenBean {

	private Usuario usuario;
	private Carrito carrito;
	
	private DetalleCarrito detalleCarrito;
	private boolean cobroIgualEntrega = true;
	private DireccionDto dirEntrega;
	private DireccionDto dirCobro;
	private String email;
	private String numOrden;

	private ServicioOrdenCompra servicoOrden;
	private ServicioCuenta servicioCuenta;
	public OrdenBean(Usuario usuario, Carrito carrito) {
		super();
		this.usuario = usuario;
		this.carrito = carrito;
		init();
	}
	public OrdenBean() {
		this(null,null);
	}

	private void init(){
		servicoOrden = new ServicioOrdenCompraImpl();
		servicioCuenta = ServicioCuentaFactoria.getInstance();
	}
	public boolean isCobroIgualEntrega() {
		return cobroIgualEntrega;
	}
	public void setCobroIgualEntrega(boolean cobroIgualEntrega) {
		this.cobroIgualEntrega = cobroIgualEntrega;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public Carrito getCarrito() {
		return carrito;
	}
	public DetalleCarrito getDetalleCarrito() {
		return detalleCarrito;
	}
	public DireccionDto getDirEntrega() {
		return dirEntrega;
	}
	public void setDirEntrega(DireccionDto dirEntrega) {
		this.dirEntrega = dirEntrega;
	}
	public String getEmail() {
		return email;
	}
	public String getNumOrden() {
		return numOrden;
	}
	
	public String direccion(){
		Cuenta cuenta = servicioCuenta.obtener(usuario.getUsername());
		DirecctionDtoEnsamblador ensamblador = new DirecctionDtoEnsamblador();
		dirCobro = ensamblador.toDto(cuenta.getDireccion());
		dirEntrega = dirCobro;
		email = cuenta.getEmail();
		return "/WEB-INF/paginas/orden/direccion.jsp";
	}
	public String obtenerdirentrega(){
		if(cobroIgualEntrega){
			dirEntrega = dirCobro;
		}else{
			dirEntrega = null;
		}
		return "/WEB-INF/paginas/orden/direccion.jsp";
	}
	
	public String vueltadireccion(){
		return "/WEB-INF/paginas/orden/direccion.jsp";
	}
	public String resumen(){
		DetalleCarritoDtoEnsamblador ensamblador = new DetalleCarritoDtoEnsamblador();
		detalleCarrito = ensamblador.toDto(carrito);
		return "/WEB-INF/paginas/orden/resumen.jsp";
	}
	
	public String confirmar(){
		OrdenCompra orden = new OrdenCompra();
		orden.setCobroIgualEntrega(cobroIgualEntrega);
		orden.setEmail(email);
		DirecctionDtoEnsamblador dirEnsamblador = new DirecctionDtoEnsamblador();
		orden.setDireccionCobro(dirEnsamblador.fromDto(dirCobro));
		orden.setDireccionEntrega(dirEnsamblador.fromDto(dirEntrega));
		orden.setNombreususario(usuario.getUsername());
		
		servicoOrden.guardarOrdenCompra(orden, carrito);
		numOrden = String.valueOf(orden.getId());
		
		return "/WEB-INF/paginas/orden/confirmacion.jsp";
	}
}
