package com.viewnextfor.cdi.servicio;

import java.time.LocalTime;

import com.viewnextfor.cdi.bean.SaludoBean;

public class ServicioSaludoNewApi implements ServicioSaludo {

	@Override
	public void crearSaludo(SaludoBean saludo) {
		LocalTime ahora = LocalTime.now();
		StringBuilder sb = new StringBuilder();
		sb.append(conversionTimeString(ahora))
			.append(" ")
			.append(saludo.getNombre())
			.append(", Bienvenido a nuestro programa");
		saludo.setMsg(sb.toString());
	}

	private String conversionTimeString(LocalTime localTime){
		int hora = localTime.getHour();
		String text = "";
		if(hora >= 6 && hora <=14){
			text = "Buenos dias";
		}else if(hora > 14 && hora <19){
			text = "Buenas tardes";
		}else{
			text = "Buenas noches";
		}
		return text;
	}
}
