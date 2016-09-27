package com.viewnextfor.libreria.servicio.usuario;


@SuppressWarnings("serial")
public class ServicioUsuarioException extends RuntimeException {

	public ServicioUsuarioException(){}
	public ServicioUsuarioException(String msg){
		super(msg);
	}
	public ServicioUsuarioException(Throwable t){
		super(t);
	}
}
