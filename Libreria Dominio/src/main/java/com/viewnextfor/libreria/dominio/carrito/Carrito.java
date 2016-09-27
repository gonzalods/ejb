package com.viewnextfor.libreria.dominio.carrito;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class Carrito implements Serializable{

	private Map<Long, ItemCarrito> items;
	private Integer cantidad;

	public Carrito(){
		items = new HashMap<>();
		cantidad = 0;
	}

	public Integer getCantidad() {
		return cantidad;
	}
	
	public Map<Long, ItemCarrito> getItems() {
		return items;
	}
	public void setItems(Map<Long, ItemCarrito> items) {
		this.items = items;
	}
	public void addItem(ItemCarrito newItem){
		int newCantidad = newItem.getCantidad();
		if(items.containsKey(newItem.getId())){
			ItemCarrito item = items.get(newItem.getId());
			item.setCantidad(item.getCantidad()+newCantidad);
		}else{
			items.put(newItem.getId(), newItem);
		}
		cantidad += newCantidad;
	}
	public void removeItem(Long id){
		if(items.containsKey(id)){
			ItemCarrito removedItem = items.remove(id);
			cantidad -= removedItem.getCantidad();
		}
	}
	
}
