package com.viewnextfor.libreria.validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.viewnextfor.libreria.dto.GestionCuenta;

public class CuentaValidator {

	public final static String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*" + 
			"@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public Map<String, String> validate(GestionCuenta gestionCuenta){

		 Map<String, String> errores = new LinkedHashMap<>();
		if(StringUtils.isBlank(gestionCuenta.getNombre())){
			errores.put("nombre", "El campo Nombre es obligatorio");
		}
		if(StringUtils.isBlank(gestionCuenta.getApellidos())){
			errores.put("apellidos", "El campo Apellidos es obligatorio");
		}
		if(StringUtils.isBlank(gestionCuenta.getEmail())){
			errores.put("email", "El campo Correo Electrónico es obligatorio");
		}else {
			Pattern p = Pattern.compile(EMAIL_PATTERN);
			Matcher m = p.matcher(gestionCuenta.getEmail());
			if(!m.matches()){
				errores.put("email", "El campo Correo Electrónico no tiene un formato válido.");
			}
		}
		if(!StringUtils.isBlank(gestionCuenta.getFechaNacimiento())){
			DateFormat fmt = new  SimpleDateFormat("dd-MM-yyyy");
			try{
				fmt.parse(gestionCuenta.getFechaNacimiento());
			}catch (ParseException e) {
				errores.put("fechaNacimiento", "El campo Fecha Nacimiento no tiene un formato válido.");
			}
		}
		if(StringUtils.isBlank(gestionCuenta.getCalle())){
			errores.put("calle", "El campo Calle es obligatorio");
		}
		if(StringUtils.isBlank(gestionCuenta.getCiudad())){
			errores.put("ciudad", "El campo Ciudad es obligatorio");
		}
		if(StringUtils.isBlank(gestionCuenta.getCodigoPostal())){
			errores.put("codigoPostal", "El campo Código Postal es obligatorio");
		}

		return errores;
	}
}
