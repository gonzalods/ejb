package com.viewnextfor.libreria.repositorio.cuenta;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.viewnextfor.libreria.dominio.cuenta.Cuenta;
import com.viewnextfor.libreria.dominio.cuenta.Direccion;
import com.viewnextfor.libreria.repositorio.DataAccesException;
import com.viewnextfor.libreria.repositorio.Repositorio;
import com.viewnextfor.libreria.repositorio.RepositorioCuenta;

public class RepositorioCuentaImpl extends Repositorio implements RepositorioCuenta {

	private static RepositorioCuentaImpl INSTANCE;
	
	RepositorioCuentaImpl() {}
	
	public static RepositorioCuenta getInstance(){
		if(INSTANCE==null)
			INSTANCE = new RepositorioCuentaImpl();
		return INSTANCE;
	}

	@Override
	public void crearCuenta(Cuenta cuenta){
		String sql = "INSERT INTO LIB_CUENTA " +
				"(NOMBRE ,APELLIDOS ,FECHANACIMIENTO ,EMAIL ," +
				"CALLE ,NUMERO ,PISO ,CIUDAD ,CODIGOPOSTAL ," +
				"NOMBREUSUARIO) " +
				"VALUES(?,?,?,?,?,?,?,?,?,?)";
		try(Connection conn = ds.getConnection();
			PreparedStatement stm = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
			
			stm.setString(1, cuenta.getNombre());
			stm.setString(2, cuenta.getApellidos());
			stm.setDate(3, new Date(cuenta.getFechaNacimiento().getTime()));
			stm.setString(4, cuenta.getEmail());
			stm.setString(5, cuenta.getDireccion().getCalle());
			stm.setString(6, cuenta.getDireccion().getNumero());
			stm.setString(7, cuenta.getDireccion().getPiso());
			stm.setString(8, cuenta.getDireccion().getCiudad());
			stm.setString(9, cuenta.getDireccion().getCodigoPostal());
			stm.setString(10, cuenta.getNombreusuario());
			
			int  result = stm.executeUpdate();
			if(result==1){
				try(ResultSet keys = stm.getGeneratedKeys()){
					keys.next();
					cuenta.setId(keys.getLong(1));
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new DataAccesException(e);
		}
	}

	@Override
	public Cuenta obtenerCuenta(String nombreUsu){
		Cuenta cuenta = null;
		String sql = "SELECT C.* " +
				"FROM LIB_CUENTA C " +
				"WHERE C.NOMBREUSUARIO=?";

		try(Connection conn = ds.getConnection();
			PreparedStatement stm = conn.prepareStatement(sql)){
			stm.setString(1, nombreUsu);
			
			try(ResultSet result = stm.executeQuery()){
				while(result.next()){
					cuenta = new Cuenta();
					cuenta.setId(result.getLong("ID"));
					cuenta.setNombre(result.getString("NOMBRE"));
					cuenta.setApellidos(result.getString("APELLIDOS"));
					cuenta.setFechaNacimiento(new java.util.Date(result.getDate("FECHANACIMIENTO").getTime()));
					cuenta.setEmail(result.getString("EMAIL"));
					Direccion direccion = new Direccion();
					direccion.setCalle(result.getString("CALLE"));
					direccion.setNumero(result.getString("NUMERO"));
					direccion.setPiso(result.getString("PISO"));
					direccion.setCiudad(result.getString("CIUDAD"));
					direccion.setCodigoPostal(result.getString("CODIGOPOSTAL"));
					cuenta.setDireccion(direccion);
					
					cuenta.setNombreusuario(result.getString("NOMBREUSUARIO"));
				}
					
			}
		}catch(SQLException e){
				e.printStackTrace();
				throw new DataAccesException(e);
		}
		return cuenta;
	}


	@Override
	public void actualizarCuenta(Cuenta cuenta){
		String sql = "UPDATE LIB_CUENTA SET NOMBRE = ?, APELLIDOS = ?," +
				" FECHANACIMIENTO = ?, EMAIL = ?, CALLE = ?, NUMERO = ?, " +
				"PISO = ?, CIUDAD = ?, CODIGOPOSTAL = ?, NOMBREUSUARIO = ? " +
				"WHERE ID = ?";

		try(Connection conn = ds.getConnection();
			PreparedStatement stm = conn.prepareStatement(sql)){
			
			stm.setString(1, cuenta.getNombre());
			stm.setString(2, cuenta.getApellidos());
			stm.setDate(3, new Date(cuenta.getFechaNacimiento().getTime()));
			stm.setString(4, cuenta.getEmail());
			stm.setString(5, cuenta.getDireccion().getCalle());
			stm.setString(6, cuenta.getDireccion().getNumero());
			stm.setString(7, cuenta.getDireccion().getPiso());
			stm.setString(8, cuenta.getDireccion().getCiudad());
			stm.setString(9, cuenta.getDireccion().getCodigoPostal());
			stm.setString(10, cuenta.getNombreusuario());
			stm.setLong(11, cuenta.getId());
			stm.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			throw new DataAccesException(e);
		}
	}
}
