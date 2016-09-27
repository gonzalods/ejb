package com.viewnextfor.libreria.servicio.orden;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.viewnextfor.libreria.dominio.carrito.Carrito;
import com.viewnextfor.libreria.dominio.orden.DetalleOrdenCompra;
import com.viewnextfor.libreria.dominio.orden.OrdenCompra;
import com.viewnextfor.libreria.repositorio.RepositorioOrdenCompra;
import com.viewnextfor.libreria.repositorio.ordencompra.RepositorioOrdenCompraImpl;
import com.viewnextfor.libreria.servicio.ServicioOrdenCompra;

public class ServicioOrdenCompraImpl implements ServicioOrdenCompra {

	@Override
	public void guardarOrdenCompra(OrdenCompra orden, Carrito carrito) {
		RepositorioOrdenCompra repositorio = RepositorioOrdenCompraImpl.getInstance();
		List<DetalleOrdenCompra> detalleOrden = carrito.getItems().values().stream()
				.map(item ->{
					DetalleOrdenCompra detalle = new DetalleOrdenCompra();
					detalle.setId(item.getId());
					detalle.setPrecio(item.getPrecio());
					detalle.setCantidad(item.getCantidad());
					return detalle;
				}).collect(Collectors.toList());
		BigDecimal totalOrden = detalleOrden.stream()
			.map(item -> {
				return item.getPrecio().multiply(new BigDecimal(item.getCantidad()));
			}).reduce(BigDecimal.ZERO, (p1, p2) -> {
				p1 = p1.add(p2);
				return p1;
			});
		orden.setDetallesOrden(detalleOrden);
		orden.setPrecioTotalOrden(totalOrden);
		orden.setFechaOrden(new Date());
		repositorio.guardarOrdenCompra(orden);
		repositorio.guardarListaDetalle(detalleOrden, orden.getId());
	}

}
