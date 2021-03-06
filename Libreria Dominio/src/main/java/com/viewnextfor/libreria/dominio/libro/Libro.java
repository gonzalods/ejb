package com.viewnextfor.libreria.dominio.libro;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


public class Libro implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String titulo;
	private String descripcion;
	private BigDecimal precio;
	private Integer anno;
	private Set<String> autores;
	private String isbn;
	private Categoria categoria;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public Integer getAnno() {
		return anno;
	}
	public void setAnno(Integer anno) {
		this.anno = anno;
	}
	public Set<String> getAutores() {
		return autores;
	}
	public void setAutores(Set<String> autores) {
		this.autores = autores;
	}
	public void addAutor(String autor){
		if(autores==null){
			autores = new HashSet<>();
		}
		autores.add(autor);
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		}
		if(!(obj instanceof Libro)){
			return false;
		}
		Libro otro = (Libro)obj;
		return this.id.equals(otro.id);
	} 
	
}
