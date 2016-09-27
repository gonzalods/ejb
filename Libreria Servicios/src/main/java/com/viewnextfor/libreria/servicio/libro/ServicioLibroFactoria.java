package com.viewnextfor.libreria.servicio.libro;

import com.viewnextfor.libreria.configuracion.ConfiguracionLibreria;
import com.viewnextfor.libreria.servicio.ServicioLibro;

public class ServicioLibroFactoria {

	public static ServicioLibro getInstance() {
		boolean ioc = ConfiguracionLibreria.isIoc();
		boolean seguro = ConfiguracionLibreria.isSeguro();
		ServicioLibro servicio = ioc ? new ServicioLibroImpl()
				: seguro ? ServicioLibroSeg.getInstance() : ServicioLibroImpl
						.getInstance();
		return servicio;
	}
}
