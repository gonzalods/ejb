package com.viewnextfor.libreria.ensamblador;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.viewnextfor.libreria.dominio.libro.Libro;
import com.viewnextfor.libreria.dto.ListaLibro;

public class LibroListaDtoEnsamblador {

	public ListaLibro toDto(Libro libro){
		Set<String> autores = libro.getAutores();
		String stAutores = StringUtils.join(autores, ",");

		ListaLibro dto = new ListaLibro(libro.getId().toString(), 
				libro.getTitulo(), stAutores.toString());
		
		return dto;
	}
	
	public List<ListaLibro> toDtoList(List<Libro> libros){
		List<ListaLibro> dtoList = new ArrayList<>(libros.size());
		
		for(Libro libro: libros){
			dtoList.add(toDto(libro));
		}
		
		return dtoList;
 	}
}
