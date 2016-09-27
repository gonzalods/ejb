package com.viewnextfor.libreria.bean;

import java.util.Set;

import javax.security.auth.login.AccountNotFoundException;
import javax.security.auth.login.FailedLoginException;

import com.viewnextfor.libreria.dominio.usuario.User;
import com.viewnextfor.libreria.dto.Usuario;
import com.viewnextfor.libreria.ensamblador.UsuarioDtoEnsamblador;
import com.viewnextfor.libreria.servicio.ServicioUsuario;
import com.viewnextfor.libreria.servicio.usuario.ServicioUsuarioImpl;

public class LoginBean {

	private Usuario usuario;
	private String password;
	private String msg_error;
	private Set<String> roles;
	private String rol;
	
	private ServicioUsuario servicioUsuario;
	
	
	public LoginBean() {
		super();
		init();
	}
	
	private void init(){
		servicioUsuario = new ServicioUsuarioImpl();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMsg_error() {
		return msg_error;
	}
	public void setMsg_error(String msg_error) {
		this.msg_error = msg_error;
	}
	
	public Set<String> getRoles() {
		return roles;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String login(){
		try{
			User user = servicioUsuario.login(usuario.getUsername(), password);
			UsuarioDtoEnsamblador ensamblador = new UsuarioDtoEnsamblador();

			if(user.getAuthority().size() > 1){
				usuario = ensamblador.toDto(user, null);
				roles = user.getAuthority();
				return "/WEB-INF/paginas/seleccionRol.jsp";
			}else if(user.getAuthority().contains("ROLE_USUARIO")){
				usuario = ensamblador.toDto(user,"ROLE_USUARIO");
				return "redirect:cliente/catalogo";
			}else if(rol.equals("ROLE_ADMIN")){
				usuario = ensamblador.toDto(user,"ROLE_ADMIN");
				return "redirect:admin/inicioadmin";
			}else{
				return "redirect:logout";
			}
		} catch (AccountNotFoundException | FailedLoginException e) {
			msg_error = e.getMessage();
			return "/WEB-INF/paginas/login.jsp";
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public String selectRol(){
		usuario.setRol(rol);
		if(rol.equals("ROLE_USUARIO")){
			return "redirect:cliente/catalogo";
		}else if(rol.equals("ROLE_ADMIN")){
			return "redirect:admin/inicioadmin";
		}else{
			return "redirect:login";
		}
	}
}
