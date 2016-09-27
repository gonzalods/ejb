package com.viewnextfor.libreria.repositorio.categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.viewnextfor.libreria.dominio.libro.Categoria;
import com.viewnextfor.libreria.repositorio.DataAccesException;
import com.viewnextfor.libreria.repositorio.Repositorio;
import com.viewnextfor.libreria.repositorio.RepositorioCategoria;



public class RepositorioCategoriaImpl extends Repositorio implements RepositorioCategoria {

	private static RepositorioCategoria INSTANCE;
	
	private RepositorioCategoriaImpl(){}
	
	public static RepositorioCategoria getInstance(){
		if(INSTANCE==null)
			INSTANCE=new RepositorioCategoriaImpl();
		return INSTANCE;
	}
	
	@Override
	public List<Categoria> buscarTodos() {
		List<Categoria> aux = new ArrayList<Categoria>();
		String sql = "SELECT ID, DESCRIPCION " +
				"FROM LIB_CATEGORIA";
		try (Connection	con = ds.getConnection();
			Statement stm = con.createStatement();
			ResultSet result = stm.executeQuery(sql)){

			while (result.next()) {
				Categoria categoria = new Categoria();
				categoria.setId(result.getLong("ID"));
				categoria.setDescripcion(result.getString("DESCRIPCION"));
				aux.add(categoria);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccesException(e);
		}
		return Collections.unmodifiableList(aux);
	}

	@Override
	public Categoria buscarPorId(Long id) {
		Categoria categoria = new Categoria();
		String sql = "SELECT ID, DESCRIPCION" +
				"FROM LIB_CATEGORIA " +
				"WHERE ID=?";
		try (Connection con = ds.getConnection();
			PreparedStatement stm = con.prepareStatement(sql)){
			stm.setLong(1, id);
			
			try(ResultSet result = stm.executeQuery()){
				while (result.next()) {
					categoria.setId(result.getLong("ID"));
					categoria.setDescripcion("DESCRIPCION");
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccesException(e);
		}
		return categoria;
	}

	@Override
	public void guardarCategoria(Categoria categoria) {
		String sql = "INSERT INTO LIB_CATEGORIA " +
				"(DESCRIPCION) " +
				"VALUES(?)";
		
		try (Connection conn = ds.getConnection();
			PreparedStatement stm = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
			stm.setString(1, categoria.getDescripcion());
			
			int result = stm.executeUpdate();
			if(result==1){
				try(ResultSet keys = stm.getGeneratedKeys()){
					if(keys.next()){
						categoria.setId(keys.getLong(1));
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccesException(e);
		}
	}

}
