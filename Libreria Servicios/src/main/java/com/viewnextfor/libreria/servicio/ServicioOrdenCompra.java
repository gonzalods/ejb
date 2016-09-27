package com.viewnextfor.libreria.servicio;

import com.viewnextfor.libreria.dominio.carrito.Carrito;
import com.viewnextfor.libreria.dominio.orden.OrdenCompra;

public interface ServicioOrdenCompra {

	void guardarOrdenCompra(OrdenCompra orden, Carrito carrito);
}
