package com.viewnextfor.servicio;

import java.time.LocalTime;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.viewnextfor.bean.SaludoBean;

@ApplicationScoped
public class SaludoNewApi implements ServicioSaludo {

	private String textoSaludo;
	
	@Inject
	private SaludoBean saludo;
	
	public SaludoNewApi(String texto, SaludoBean saludo){
		textoSaludo = texto;
		this.saludo = saludo; 
	}
	@Override
	public void crearSaludo() {
		LocalTime ahora = LocalTime.now();
		StringBuilder sb = new StringBuilder();
		sb.append(conversionTimeString(ahora))
			.append(" ")
			.append(saludo.getNombre())
			.append(", ")
			.append(textoSaludo);
		saludo.setSaludo(sb.toString());

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
