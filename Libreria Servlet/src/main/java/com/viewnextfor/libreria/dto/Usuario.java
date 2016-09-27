package com.viewnextfor.libreria.dto;

public class Usuario {

	private String username;
	private String rol;
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Usuario(String username, String rol) {
		super();
		this.username = username;
		this.rol = rol;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	
}
