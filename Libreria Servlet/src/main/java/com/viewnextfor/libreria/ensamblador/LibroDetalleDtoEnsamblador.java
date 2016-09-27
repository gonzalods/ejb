package com.viewnextfor.libreria.ensamblador;

import java.text.NumberFormat;

import org.apache.commons.lang3.StringUtils;

import com.viewnextfor.libreria.dominio.libro.Libro;
import com.viewnextfor.libreria.dto.DetalleLibro;

public class LibroDetalleDtoEnsamblador {

	public DetalleLibro toDto(Libro libro){
		String autores = StringUtils.join(libro.getAutores(), ",");
		String stAnno = libro.getAnno()!=null?libro.getAnno().toString():"";
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		String stPrecio = fmt.format(libro.getPrecio());
		DetalleLibro dto = new DetalleLibro(libro.getId().toString(),
				libro.getTitulo(), libro.getDescripcion(), autores,
				stPrecio, stAnno, libro.getIsbn(),
				libro.getCategoria().getDescripcion());
		
		return dto;
	}
}
