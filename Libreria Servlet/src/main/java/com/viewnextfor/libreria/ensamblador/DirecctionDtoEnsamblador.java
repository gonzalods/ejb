package com.viewnextfor.libreria.ensamblador;

import com.viewnextfor.libreria.dominio.cuenta.Direccion;
import com.viewnextfor.libreria.dto.DireccionDto;

public class DirecctionDtoEnsamblador {

	public DireccionDto toDto(Direccion dir){
		DireccionDto dto = new DireccionDto();
		dto.setCalle(dir.getCalle())
			.setCiudad(dir.getCiudad())
			.setCodigoPostal(dir.getCodigoPostal())
			.setNumero(dir.getNumero())
			.setPiso(dir.getPiso());
		return dto;
	}
	
	public Direccion fromDto(DireccionDto dto){
		Direccion dir = new Direccion();
		dir.setCalle(dto.getCalle());
		dir.setCiudad(dto.getCiudad());
		dir.setCodigoPostal(dto.getCodigoPostal());
		dir.setNumero(dto.getNumero());
		dir.setPiso(dto.getPiso());
		
		return dir;
	}
}
