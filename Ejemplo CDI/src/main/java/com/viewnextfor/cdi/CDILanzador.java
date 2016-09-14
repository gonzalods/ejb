package com.viewnextfor.cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import com.viewnextfor.cdi.presentacion.PantallaRecogida;

public class CDILanzador {

	public static void main(String[] args) {
		
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		PantallaRecogida pantalla = container.instance().select(PantallaRecogida.class).get();
		pantalla.ejecutar();
		weld.shutdown();

	}

}
