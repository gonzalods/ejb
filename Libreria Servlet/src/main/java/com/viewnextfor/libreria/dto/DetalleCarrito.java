package com.viewnextfor.libreria.dto;

import java.util.ArrayList;
import java.util.List;

public class DetalleCarrito {

	private List<DetalleItemCarrito> items;
	private String total;
	
	public DetalleCarrito() {
		items = new ArrayList<>();
	}
	public List<DetalleItemCarrito> getItems() {
		return items;
	}
	public void addItem(String idLibro, 
			String titulo, String cantidad, 
			String precio, String totalItem) {
		this.items.add(new DetalleItemCarrito(
				idLibro, titulo, cantidad, 
				precio, totalItem));
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	
}
