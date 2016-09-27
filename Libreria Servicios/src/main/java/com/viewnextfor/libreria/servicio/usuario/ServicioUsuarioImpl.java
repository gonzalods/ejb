package com.viewnextfor.libreria.servicio.usuario;

import javax.security.auth.login.AccountNotFoundException;
import javax.security.auth.login.FailedLoginException;

import com.viewnextfor.libreria.dominio.cuenta.Cuenta;
import com.viewnextfor.libreria.dominio.usuario.User;
import com.viewnextfor.libreria.repositorio.RepositorioCuenta;
import com.viewnextfor.libreria.repositorio.RepositorioUsuario;
import com.viewnextfor.libreria.repositorio.cuenta.RepositorioCuentaImpl;
import com.viewnextfor.libreria.repositorio.usuario.RepositorioUsuarioImpl;
import com.viewnextfor.libreria.servicio.ServicioUsuario;

public class ServicioUsuarioImpl implements ServicioUsuario {

	private RepositorioUsuario repositorioUsuario = new RepositorioUsuarioImpl();
	private RepositorioCuenta repositorioCuenta = RepositorioCuentaImpl.getInstance();

	@Override
	public User login(String nombreusuario, String password) throws AccountNotFoundException, FailedLoginException {
		User usuario = obtenerUsuario(nombreusuario);
		if (usuario == null) {
			throw new AccountNotFoundException("Nombre usuario inválido.");
		}
		if (!usuario.getPassword().equals(password))
			throw new FailedLoginException("Contraseña inválida.");
		if (!usuario.isEnabled()) {
			throw new FailedLoginException("Usuario no activo.");
		}
		return usuario;
	}

	@Override
	public void crearUsuario(User usuario) {
		if (obtenerUsuario(usuario.getUsername()) != null) {
			throw new ServicioUsuarioException(
					String.format("Nombre de usuario %s ya existente", usuario.getUsername()));
		}
		repositorioUsuario.crearUsuario(usuario);
		repositorioUsuario.anadirRol(usuario.getAuthority(), usuario.getUsername());

	}

	@Override
	public void modificarPassword(User usuario) {
		if (obtenerUsuario(usuario.getUsername()) == null) {
			throw new ServicioUsuarioException(String.format("No existe usuario %s", usuario.getUsername()));
		}
		repositorioUsuario.actualizarPassword(usuario);

	}

	@Override
	public User obtenerUsuario(String nombreusuario) {
		User usuario = repositorioUsuario.obtenerUsuario(nombreusuario);
		return usuario;
	}

	@Override
	public void crearCuenta(Cuenta cuenta) throws ServicioUsuarioException {
		repositorioCuenta.crearCuenta(cuenta);
		
	}

}
