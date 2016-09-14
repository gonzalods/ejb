package com.viewnextfor.tradicional.presentacion;

import java.util.Scanner;

import com.viewnextfor.tradicional.bean.SaludoBean;
import com.viewnextfor.tradicional.servicio.ServicioSaludo;
import com.viewnextfor.tradicional.servicio.ServicioSaludoNewApi;

public class PantallaRecogida {

	public void ejecutar(){
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Introduzca su nombre:");
		String nombre = scan.nextLine();
		
		ServicioSaludo servicio = new ServicioSaludoNewApi();
		SaludoBean saludoBean = new SaludoBean();
		saludoBean.setNombre(nombre);
		servicio.crearSaludo(saludoBean);
		
		System.out.println(saludoBean.getMsg());
				
	}
}
