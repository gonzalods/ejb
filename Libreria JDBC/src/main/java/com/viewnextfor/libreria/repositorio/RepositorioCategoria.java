package com.viewnextfor.libreria.repositorio;

import java.util.List;

import com.viewnextfor.libreria.dominio.libro.Categoria;

public interface RepositorioCategoria {

	public List<Categoria> buscarTodos();
	public Categoria buscarPorId(Long id);
	public void guardarCategoria(Categoria categoria);
}
