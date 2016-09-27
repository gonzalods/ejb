package com.viewnextfor.libreria.repositorio;

import java.util.Date;
import java.util.List;

import com.viewnextfor.libreria.dominio.orden.DetalleOrdenCompra;
import com.viewnextfor.libreria.dominio.orden.OrdenCompra;

public interface RepositorioOrdenCompra {

	OrdenCompra guardarOrdenCompra(OrdenCompra ordenCompra);
	OrdenCompra buscarPorId(Long id);
	List<OrdenCompra> buscarPorUsuario(String nombreusuario);
	List<OrdenCompra> buscarNoEnviados();
	List<OrdenCompra> buscarNoEntregados();
	void establecerFechaEnvio(Long id, Date fechaEnvio);
	void establecerFechaEntrega(Long id, Date fechaEntrega);
	void guardarListaDetalle(List<DetalleOrdenCompra> detalle, Long ordenId);
}
