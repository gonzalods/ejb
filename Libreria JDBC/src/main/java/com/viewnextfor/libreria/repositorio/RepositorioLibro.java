package com.viewnextfor.libreria.repositorio;

import java.util.List;
import java.util.Set;

import com.viewnextfor.libreria.dominio.libro.Libro;

public interface RepositorioLibro {

	public Libro buscarPorId(Long id);
	
	public List<Libro> busquedaPorTituloYCategoriaId(String titulo, Long categoria);
	
	public List<Libro> buscarPorCategoria(Long categoria);
	
	public List<Libro> buscarPorTitulo(String titulo);
	
	public void guardarLibro(Libro libro);
	
	public void guardarAutor(Set<String> autores, Long id_libro);
}
