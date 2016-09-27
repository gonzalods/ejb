package com.viewnextfor.libreria.servicio.libro;

import java.util.List;

import com.viewnextfor.libreria.dominio.libro.Categoria;
import com.viewnextfor.libreria.dominio.libro.Libro;
import com.viewnextfor.libreria.repositorio.RepositorioCategoria;
import com.viewnextfor.libreria.repositorio.RepositorioLibro;
import com.viewnextfor.libreria.repositorio.categoria.RepositorioCategoriaImpl;
import com.viewnextfor.libreria.repositorio.libro.RepositorioLibroImpl;
import com.viewnextfor.libreria.servicio.ServicioLibro;
import com.viewnextfor.libreria.servicio.bean.FiltroBusqueda;

public class ServicioLibroImpl implements ServicioLibro {

	private RepositorioLibro repositorioLibro;
	private RepositorioCategoria repositorioCategoria;
	
	ServicioLibroImpl(){
		
	}
	
	static ServicioLibro getInstance(){
		ServicioLibroImpl servicio = new ServicioLibroImpl(); 
		servicio.inicializar();
		return servicio;
	}
	
	protected void inicializar(){
		repositorioLibro = RepositorioLibroImpl.getInstance();
		repositorioCategoria = RepositorioCategoriaImpl.getInstance();
		
	}
	
	@Override
	public List<Libro> buscarLibros(FiltroBusqueda filtro) {
		if(filtro.getTitulo()!=null && !filtro.getTitulo().isEmpty() 
				&& filtro.getCategoria() != null && filtro.getCategoria() !=0){
			return repositorioLibro.busquedaPorTituloYCategoriaId(filtro.getTitulo(), filtro.getCategoria());
		}else if(filtro.getTitulo()!=null && !filtro.getTitulo().isEmpty() 
				&& (filtro.getCategoria() == null || filtro.getCategoria() ==0)){
			return repositorioLibro.buscarPorTitulo(filtro.getTitulo());
		}else if((filtro.getTitulo()==null || filtro.getTitulo().isEmpty()) 
				&& filtro.getCategoria() != null && filtro.getCategoria() !=0){
			return repositorioLibro.buscarPorCategoria(filtro.getCategoria());
		}else {
			throw new IllegalArgumentException();
		}
	}
	
	@Override
	public Libro buscarLibro(Long id) {
		return this.repositorioLibro.buscarPorId(id);
	}

	@Override
	public void anadirLibro(Libro libro) {
		this.repositorioLibro.guardarLibro(libro);

	}
	
	@Override
	public void modificarLibro(Libro libro) throws SecurityException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Categoria> buscarTodasCategorias() {
		return this.repositorioCategoria.buscarTodos();
	}


	@Override
	public void guardarCategoria(Categoria categoria) {
		repositorioCategoria.guardarCategoria(categoria);
		
	}

	@Override
	public void actualizarCategoria(Categoria categoria) {
		
		
	}

}
