package com.viewnextfor.libreria.repositorio.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import com.viewnextfor.libreria.dominio.usuario.User;
import com.viewnextfor.libreria.repositorio.DataAccesException;
import com.viewnextfor.libreria.repositorio.Repositorio;
import com.viewnextfor.libreria.repositorio.RepositorioUsuario;

public class RepositorioUsuarioImpl extends Repositorio implements RepositorioUsuario {

	@Override
	public void crearUsuario(User usuario){
		String sql = "INSERT INTO USERS " +
				"(username, password, enabled) " +
				"VALUES (?,?,?)";
		
		try(Connection conn = ds.getConnection();
			PreparedStatement stm = conn.prepareStatement(sql)){
			stm.setString(1, usuario.getUsername());
			stm.setString(2, usuario.getPassword());
			stm.setBoolean(3, true);
			stm.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			throw new DataAccesException(e);
		}
	}

	

	@Override
	public void actualizarPassword(User usuario){
		String sql = "UPDATE USERS SET password = ? " +
				"WHERE username = ?";
		try(Connection conn = ds.getConnection();
			PreparedStatement stm = conn.prepareStatement(sql)){
			
			stm.setString(1, usuario.getPassword());
			stm.setString(2, usuario.getUsername());
			stm.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			throw new DataAccesException(e);
		}

	}

	@Override
	public User obtenerUsuario(String nombreusuario){
		User usuario = null;
		String sql = "SELECT PASSWORD, ENABLED, AUTHORITY "
				+ "FROM USERS AS U "
				+ "LEFT JOIN AUTHORITIES AS A ON (U.USERNAME = A.USERNAME) "
				+ "WHERE USERNAME = ?";
		try(Connection conn = ds.getConnection();
			PreparedStatement stm = conn.prepareStatement(sql)){
			stm.setString(1, nombreusuario);
			
			try(ResultSet rs = stm.executeQuery()){
				while(rs.next()){
					if(usuario == null){
						usuario = new User();
						usuario.setUsername(nombreusuario);
						usuario.setPassword(rs.getString("PASSWORD"));
						usuario.setEnabled(rs.getBoolean("ENABLED"));
					}
					usuario.getAuthority().add(rs.getString("AUTHORITY"));
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccesException(e);
		}
		return usuario;
	}



	@Override
	public void anadirRol(Set<String> roles, String nombreusuario) {
		String sql = "INSERT INTO AUTHORITIES " +
				"(AUTHORITY, USERNAME) " +
				"VALUES (?,?)";
		
		try(Connection conn = ds.getConnection();
			PreparedStatement stm = conn.prepareStatement(sql)){
			for(String rol: roles){
				stm.setString(1, rol);
				stm.setString(2, nombreusuario);
				stm.executeUpdate();
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new DataAccesException(e);
		}
		
	}

}
