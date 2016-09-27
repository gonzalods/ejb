package com.viewnextfor.libreria.servicio;

import javax.security.auth.login.AccountNotFoundException;
import javax.security.auth.login.FailedLoginException;

import com.viewnextfor.libreria.dominio.cuenta.Cuenta;
import com.viewnextfor.libreria.dominio.usuario.User;
import com.viewnextfor.libreria.servicio.usuario.ServicioUsuarioException;

public interface ServicioUsuario {

	public User login(String nombreusuario, String password) throws AccountNotFoundException, FailedLoginException;
	public void crearUsuario(User usuario) throws ServicioUsuarioException;
	public void crearCuenta(Cuenta cuenta) throws ServicioUsuarioException;
	public void modificarPassword(User usuario) throws ServicioUsuarioException;
	public User obtenerUsuario(String nombreusuario) throws ServicioUsuarioException;
}
