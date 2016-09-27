package com.viewnextfor.libreria.dto;

public class ListaLibro {

	private String id;
	private String titulo;
	private String autores;
	public ListaLibro() {
		super();
	}
	public ListaLibro(String id, String titulo, String autores) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autores = autores;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutores() {
		return autores;
	}
	public void setAutores(String autores) {
		this.autores = autores;
	}
	
}
