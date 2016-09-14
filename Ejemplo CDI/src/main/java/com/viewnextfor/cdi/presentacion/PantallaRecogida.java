package com.viewnextfor.cdi.presentacion;

import java.util.Scanner;

import javax.inject.Inject;

import com.viewnextfor.cdi.bean.SaludoBean;
import com.viewnextfor.cdi.servicio.ServicioSaludo;


public class PantallaRecogida {

	@Inject
	private SaludoBean saludoBean;
	@Inject
	private ServicioSaludo servicio;
		
	public void ejecutar(){
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Introduzca su nombre:");
		String nombre = scan.nextLine();
		
		saludoBean.setNombre(nombre);
		servicio.crearSaludo(saludoBean);
		
		System.out.println(saludoBean.getMsg());
		
		scan.close();
	}
}
