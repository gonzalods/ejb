package com.viewnextfor.libreria.dominio.libro;

public class Categoria{

	private Long id;
	private String descripcion;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj==null) 
			return false;
		if(!(obj instanceof Categoria))
			return false;
		Categoria otro = (Categoria)obj;
		return id==otro.id;
	}

	@Override
	public int hashCode() {
		return id.intValue();
	}

	
}
