package com.viewnextfor.libreria.servicio;

import java.util.List;

import com.viewnextfor.libreria.dominio.libro.Categoria;
import com.viewnextfor.libreria.dominio.libro.Libro;
import com.viewnextfor.libreria.servicio.bean.FiltroBusqueda;



public interface ServicioLibro {

	public List<Libro> buscarLibros(FiltroBusqueda filtro);
	
	public Libro buscarLibro(Long id);
	
	public void anadirLibro(Libro libro) throws SecurityException;
	
	public void modificarLibro(Libro libro) throws SecurityException;
	
	public List<Categoria> buscarTodasCategorias();
	
	public void guardarCategoria(Categoria categoria);
	
	public void actualizarCategoria(Categoria categoria);
	
}
