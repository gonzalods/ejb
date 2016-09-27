package com.viewnextfor.libreria.bean;

import java.util.Map;

import com.viewnextfor.libreria.dominio.cuenta.Cuenta;
import com.viewnextfor.libreria.dominio.usuario.User;
import com.viewnextfor.libreria.dto.GestionCuenta;
import com.viewnextfor.libreria.dto.Usuario;
import com.viewnextfor.libreria.ensamblador.DetalleCuentaDtoEnsamblador;
import com.viewnextfor.libreria.ensamblador.UsuarioDtoEnsamblador;
import com.viewnextfor.libreria.servicio.ServicioUsuario;
import com.viewnextfor.libreria.servicio.usuario.ServicioUsuarioException;
import com.viewnextfor.libreria.servicio.usuario.ServicioUsuarioImpl;
import com.viewnextfor.libreria.validator.CuentaValidator;

public class RegistroBean {

	private Usuario usuario;
	private GestionCuenta cuenta;
	private String username;
	private String password;
	
	private CuentaValidator validator;
	
	private String registro_error;
	private String cuenta_error;
	private Map<String, String> validacion_errores;
	
	private ServicioUsuario servicioUsuario;
	public RegistroBean(){
		servicioUsuario = new ServicioUsuarioImpl();
		validator = new CuentaValidator();
	}
	public GestionCuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(GestionCuenta cuenta) {
		this.cuenta = cuenta;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegistro_error() {
		return registro_error;
	}
	public String getCuenta_error() {
		return cuenta_error;
	}
	public Map<String, String> getValidacion_errores() {
		return validacion_errores;
	}
	
	public String registro(){
		return "/WEB-INF/paginas/registro/registro.jsp";
	}
	public String crearUsuario(){
		usuario = new Usuario(username, "ROLE_CLIENTE");
		UsuarioDtoEnsamblador ensamblador = new UsuarioDtoEnsamblador();
		User user = ensamblador.fromDto(usuario, password);
		try{
			servicioUsuario.crearUsuario(user);
		}catch (ServicioUsuarioException e) {
			registro_error = e.getMessage();
			return "/WEB-INF/paginas/registro/registro.jsp";
		}
		return "/WEB-INF/paginas/registro/crearcuenta.jsp";
	}
	
//	public String cuenta(){
//		return "";
//	}
	
	public String crearCuenta(){
		validacion_errores = validator.validate(cuenta);
		if(!validacion_errores.isEmpty()){
			return "/WEB-INF/paginas/registro/crearcuenta.jsp";
		}
		DetalleCuentaDtoEnsamblador ensamblador = new DetalleCuentaDtoEnsamblador();
		cuenta.setNombreusuario(usuario.getUsername());
		Cuenta cuentaCliente = ensamblador.fromDto(cuenta);
		try{
			servicioUsuario.crearCuenta(cuentaCliente);
		}catch(ServicioUsuarioException e){
			cuenta_error = e.getMessage();
			return "/WEB-INF/paginas/registro/crearcuenta.jsp";
		}
		
		return "redirect:catalogo";
	}
	
}
