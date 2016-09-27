package com.viewnextfor.libreria.ensamblador;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.viewnextfor.libreria.dominio.cuenta.Cuenta;
import com.viewnextfor.libreria.dominio.cuenta.Direccion;
import com.viewnextfor.libreria.dto.GestionCuenta;

public class DetalleCuentaDtoEnsamblador {

	private static final DateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
	
	public GestionCuenta toDto(Cuenta cuenta){
		
		Direccion dir = cuenta.getDireccion();
		GestionCuenta dto = new GestionCuenta(String.valueOf(cuenta.getId()), 
				cuenta.getNombre(), cuenta.getApellidos(), cuenta.getEmail(), 
				dir.getCalle(), dir.getCiudad(), dir.getCodigoPostal(), 
				cuenta.getNombreusuario());
		dto.setNumero(dir.getNumero());
		dto.setPiso(dir.getPiso());
		dto.setFechaNacimiento(fmt.format(cuenta.getFechaNacimiento()));
		return dto;
	}
	
	public Cuenta fromDto(GestionCuenta dto){
		Cuenta cuenta = new Cuenta();
		if(dto.getId() != null && dto.getId().length()!=0){
			cuenta.setId(Long.valueOf(dto.getId()));
		}
		cuenta.setApellidos(dto.getApellidos());
		cuenta.setEmail(dto.getEmail());
		cuenta.setNombre(dto.getNombre());
		cuenta.setNombreusuario(dto.getNombreusuario());
		Direccion dir = new Direccion();
		dir.setCalle(dto.getCalle());
		dir.setCiudad(dto.getCiudad());
		dir.setCodigoPostal(dto.getCodigoPostal());
		dir.setNumero(dto.getNumero());
		dir.setPiso(dto.getPiso());
		cuenta.setDireccion(dir);
		String fechaNacimiento = dto.getFechaNacimiento(); 
		if(fechaNacimiento!= null && fechaNacimiento.trim().length()!=0){
			try {
				cuenta.setFechaNacimiento(fmt.parse(fechaNacimiento));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return cuenta;
	}
}
