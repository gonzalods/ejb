package com.viewnextfor.libreria.ensamblador;

import java.math.BigDecimal;
import java.text.NumberFormat;

import com.viewnextfor.libreria.dominio.carrito.Carrito;
import com.viewnextfor.libreria.dominio.carrito.ItemCarrito;
import com.viewnextfor.libreria.dto.DetalleCarrito;

public class DetalleCarritoDtoEnsamblador {

	private static final NumberFormat fmt = NumberFormat.getCurrencyInstance();
	
	public DetalleCarrito toDto(Carrito carrito){
		DetalleCarrito dto = new DetalleCarrito();
		BigDecimal totalCarrito = BigDecimal.ZERO;
		for(ItemCarrito item: carrito.getItems().values()){
			BigDecimal totalItem = item.getPrecio().multiply(new BigDecimal(item.getCantidad()));
			totalCarrito = totalCarrito.add(totalItem);
			dto.addItem(String.valueOf(item.getId()), item.getTitulo(),
					String.valueOf(item.getCantidad()), 
					fmt.format(item.getPrecio()), 
					fmt.format(totalItem));
		}
		dto.setTotal(fmt.format(totalCarrito));
		return dto;
	}
}
