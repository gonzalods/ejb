package com.viewnextfor.libreria.servicio.libro;


import com.viewnextfor.libreria.dominio.libro.Libro;
import com.viewnextfor.libreria.servicio.ServicioLibro;


public final class ServicioLibroSeg extends ServicioLibroImpl {
	
	ServicioLibroSeg(){}
	
	static ServicioLibro getInstance(){
		ServicioLibroSeg servicio = new ServicioLibroSeg();
		servicio.inicializar();
		return servicio;
	}

	@Override
	public void anadirLibro(Libro libro) throws SecurityException{
//		Cuenta cuenta = AlmacenamientoLocal.get();
//		if(cuenta.getRol()!=Rol.ROL_ADMIN)
//			throw new SecurityException();
		
		super.anadirLibro(libro);
	}
}
