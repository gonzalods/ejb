package com.viewnextfor.libreria.repositorio;

import java.util.Set;

import com.viewnextfor.libreria.dominio.usuario.User;

public interface RepositorioUsuario {

	public void crearUsuario(User usuario);
	public void anadirRol(Set<String> rol, String nombreusuario);
	public void actualizarPassword(User usuario);
	public User obtenerUsuario(String nombreusuario);
}
