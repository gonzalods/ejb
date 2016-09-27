package com.viewnextfor.libreria.repositorio.ordencompra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import com.viewnextfor.libreria.dominio.orden.DetalleOrdenCompra;
import com.viewnextfor.libreria.dominio.orden.OrdenCompra;
import com.viewnextfor.libreria.repositorio.DataAccesException;
import com.viewnextfor.libreria.repositorio.Repositorio;
import com.viewnextfor.libreria.repositorio.RepositorioOrdenCompra;

public class RepositorioOrdenCompraImpl extends Repositorio implements RepositorioOrdenCompra{

	private static RepositorioOrdenCompra INSTANCE;
	
	private RepositorioOrdenCompraImpl(){}
	
	public static RepositorioOrdenCompra getInstance(){
		if(INSTANCE==null)
			INSTANCE = new RepositorioOrdenCompraImpl();
		return INSTANCE;
	}

	@Override
	public List<OrdenCompra> buscarPorUsuario(String nombreusuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdenCompra buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void establecerFechaEnvio(Long id, Date fechaEnvio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void establecerFechaEntrega(Long id, Date fechaEntrega) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrdenCompra> buscarNoEnviados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdenCompra> buscarNoEntregados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdenCompra guardarOrdenCompra(OrdenCompra ordenCompra) {
		String sql = "INSERT INTO LIB_ORDEN "
				+ "(ENT_CALLE,ENT_NUMERO,ENT_PISO,ENT_CIUDAD,ENT_CODIGOPOSTA,"
				+ "COB_CALLE,COB_NUMERO,COB_PISO,COB_CIUDAD,COB_CODIGOPOSTA,"
				+ "EMAIL,FECHA_ORDEN,COB_IGUAL_ENT,PRECIO_TOTAL,NOMBREUSUARIO) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try(Connection conn = ds.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
			pstm.setString(1, ordenCompra.getDireccionEntrega().getCalle());
			pstm.setString(2, ordenCompra.getDireccionEntrega().getNumero());
			pstm.setString(3, ordenCompra.getDireccionEntrega().getPiso());
			pstm.setString(4, ordenCompra.getDireccionEntrega().getCiudad());
			pstm.setString(5, ordenCompra.getDireccionEntrega().getCodigoPostal());
			pstm.setString(6, ordenCompra.getDireccionCobro().getCalle());
			pstm.setString(7, ordenCompra.getDireccionCobro().getNumero());
			pstm.setString(8, ordenCompra.getDireccionCobro().getPiso());
			pstm.setString(9, ordenCompra.getDireccionCobro().getCiudad());
			pstm.setString(10, ordenCompra.getDireccionCobro().getCodigoPostal());
			pstm.setString(11, ordenCompra.getEmail());
			pstm.setDate(12, new java.sql.Date(ordenCompra.getFechaOrden().getTime()));
			pstm.setBoolean(13, ordenCompra.isCobroIgualEntrega());
			pstm.setBigDecimal(14, ordenCompra.getPrecioTotalOrden());
			pstm.setString(15, ordenCompra.getNombreususario());
			
			int num = pstm.executeUpdate();
			if(num == 1){
				try(ResultSet keys = pstm.getGeneratedKeys()){
					keys.next();
					ordenCompra.setId(keys.getLong(1));
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccesException(e);
		}
		return ordenCompra;
	}

	@Override
	public void guardarListaDetalle(List<DetalleOrdenCompra> detalle, Long ordenId) {
		String sql = "INSERT INTO LIB_DETALLE_ORDEN "
				+ "(ID_LIBRO,ID_ORDEN,CANTIDAD,PRECIO) "
				+ "VALUES(?,?,?,?)";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstm = conn.prepareStatement(sql)){
			for(DetalleOrdenCompra item: detalle){
				pstm.setLong(1, item.getId());
				pstm.setLong(2, ordenId);
				pstm.setInt(3, item.getCantidad());
				pstm.setBigDecimal(4, item.getPrecio());
				
				pstm.executeUpdate();
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccesException(e);
		}
	}
}
