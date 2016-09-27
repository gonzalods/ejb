package com.viewnextfor.libreria.repositorio.libro;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.viewnextfor.libreria.dominio.libro.Categoria;
import com.viewnextfor.libreria.dominio.libro.Libro;
import com.viewnextfor.libreria.repositorio.DataAccesException;
import com.viewnextfor.libreria.repositorio.Repositorio;
import com.viewnextfor.libreria.repositorio.RepositorioLibro;

public class RepositorioLibroImpl extends Repositorio implements RepositorioLibro{

	private static RepositorioLibroImpl INSTANCE;
	
	private RepositorioLibroImpl(){
	}
	
	public static RepositorioLibro getInstance(){
		if(INSTANCE==null)
			INSTANCE = new RepositorioLibroImpl();
		return INSTANCE;
	}
	
	@Override
	public Libro buscarPorId(Long id){
		Libro libro = null;
		String sql = "SELECT L.*, A.NOMBRE AS AUTOR, C.DESCRIPCION AS CAT_DESCRIPCIOM, " +
				"C.ID AS CAT_ID FROM LIB_LIBRO L " +
				"LEFT JOIN LIB_CATEGORIA C ON (C.ID = L.CATEGORIA) " +
				"LEFT JOIN LIB_AUTOR A ON (L.ID = A.ID_LIBRO) " +
				"WHERE L.ID = ?";
		try(Connection con = ds.getConnection();
				PreparedStatement stm = con.prepareStatement(sql)){
			stm.setLong(1, id);
			try(ResultSet rs = stm.executeQuery()){
				while(rs.next()){
					if(libro == null){
						libro = new Libro();
						libro.setId(rs.getLong("ID"));
						libro.setTitulo(rs.getString("TITULO"));
						libro.setDescripcion(rs.getString("DESCRIPCION"));
						libro.setAnno(rs.getInt("ANNO"));
						
						libro.setIsbn(rs.getString("ISBN"));
						libro.setPrecio(rs.getBigDecimal("PRECIO"));
						Categoria categoria = new Categoria();
						categoria.setId(rs.getLong("CAT_ID"));
						categoria.setDescripcion(rs.getString("CAT_DESCRIPCIOM"));
						libro.setCategoria(categoria);
					}
					libro.addAutor(rs.getString("AUTOR"));
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new DataAccesException(e);
		}
		return libro;
	}
	

	@Override
	public List<Libro> busquedaPorTituloYCategoriaId(String titulo, Long cat) {
		List<Libro> aux =  new ArrayList<Libro>();
		String sql = "SELECT ID, TITULO, DESCRIPCION, PRECIO, " +
				"	ANNO, A.NOMBRE AS AUTOR, ISBN, CATEGORIA, C.DESCRIPCION AS CAT_DESCRIPCION " +
				"FROM LIB_LIBRO AS L " +
				"LEFT JOIN LIB_CATEGORIA AS C ON (C.ID=L.CATEGORIA) " +
				"LEFT JOIN LIB_AUTOR A ON (L.ID = A.ID_LIBRO) " +
				"WHERE CATEGORIA=? AND TITULO LIKE '%" + titulo + "%'";
		try (Connection con = ds.getConnection();
				PreparedStatement stm = con.prepareStatement(sql)){
			stm.setLong(1, cat);
			
			try(ResultSet result = stm.executeQuery()){
				Long id = 0L;
				Libro libro = null;
				while (result.next()) {
					Long nuevoId = result.getLong("ID");
					if(nuevoId != id){
						libro = new Libro();
						id = nuevoId;
						libro.setId(id);
						libro.setTitulo(result.getString("TITULO"));
						libro.setDescripcion(result.getString("DESCRIPCION"));
						libro.setAnno(result.getInt("ANNO"));
						libro.setIsbn(result.getString("ISBN"));
						libro.setPrecio(result.getBigDecimal("PRECIO"));
						
						Categoria categoria = new Categoria();
						categoria.setId(result.getLong("CATEGORIA"));
						categoria.setDescripcion(result.getString("CAT_DESCRIPCION"));
						libro.setCategoria(categoria);
						aux.add(libro);
					}
					libro.addAutor(result.getString("AUTOR"));
				
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccesException(e);
		}
		return Collections.unmodifiableList(aux);
	}
	
	@Override
	public List<Libro> buscarPorCategoria(Long cat){
		List<Libro> aux =  new ArrayList<Libro>();
		String sql = "SELECT ID, TITULO, DESCRIPCION, PRECIO, " +
				"	ANNO, A.NOMBRE AS AUTOR, ISBN, CATEGORIA, C.DESCRIPCION AS CAT_DESCRIPCION " +
				"FROM LIB_LIBRO AS L " +
				"LEFT JOIN LIB_CATEGORIA AS C ON (C.ID=L.CATEGORIA) " +
				"LEFT JOIN LIB_AUTOR A ON (L.ID = A.ID_LIBRO) " +
				"WHERE CATEGORIA=? ";
		try (Connection con = ds.getConnection();
				PreparedStatement stm = con.prepareStatement(sql)){
			stm.setLong(1, cat);
			
			try(ResultSet result = stm.executeQuery()){
				Long id = 0L;
				Libro libro = null;
				while (result.next()) {
					Long nuevoId = result.getLong("ID");
					if(nuevoId != id){
						libro = new Libro();
						id = nuevoId;
						libro.setId(id);
						libro.setTitulo(result.getString("TITULO"));
						libro.setDescripcion(result.getString("DESCRIPCION"));
						libro.setAnno(result.getInt("ANNO"));
						libro.setIsbn(result.getString("ISBN"));
						libro.setPrecio(result.getBigDecimal("PRECIO"));
						
						Categoria categoria = new Categoria();
						categoria.setId(result.getLong("CATEGORIA"));
						categoria.setDescripcion(result.getString("CAT_DESCRIPCION"));
						libro.setCategoria(categoria);
						aux.add(libro);
					}
					libro.addAutor(result.getString("AUTOR"));
				
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccesException(e);
		}
		return Collections.unmodifiableList(aux);
	}
	
	@Override
	public List<Libro> buscarPorTitulo(String titulo){
		List<Libro> aux =  new ArrayList<Libro>();
		String sql = "SELECT ID, TITULO, DESCRIPCION, PRECIO, " +
				"	ANNO, A.NOMBRE AS AUTOR, ISBN, CATEGORIA, C.DESCRIPCION AS CAT_DESCRIPCION " +
				"FROM LIB_LIBRO AS L " +
				"LEFT JOIN LIB_CATEGORIA AS C ON (C.ID=L.CATEGORIA) " +
				"LEFT JOIN LIB_AUTOR A ON (L.ID = A.ID_LIBRO) " +
				"WHERE TITULO LIKE '%" + titulo + "%'";
		try(Connection con = ds.getConnection();
				PreparedStatement stm = con.prepareStatement(sql);
				ResultSet result = stm.executeQuery()){
			
			Long id = 0L;
			Libro libro = null;
			while (result.next()) {
				Long nuevoId = result.getLong("ID");
				if(nuevoId != id){
					libro = new Libro();
					id = nuevoId;
					libro.setId(id);
					libro.setTitulo(result.getString("TITULO"));
					libro.setDescripcion(result.getString("DESCRIPCION"));
					libro.setAnno(result.getInt("ANNO"));
					libro.setIsbn(result.getString("ISBN"));
					libro.setPrecio(result.getBigDecimal("PRECIO"));
					
					Categoria categoria = new Categoria();
					categoria.setId(result.getLong("CATEGORIA"));
					categoria.setDescripcion(result.getString("CAT_DESCRIPCION"));
					libro.setCategoria(categoria);
					aux.add(libro);
				}
				libro.addAutor(result.getString("AUTOR"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccesException(e);
		}
		return Collections.unmodifiableList(aux);
	}

	@Override
	public void guardarLibro(Libro libro) {
		String sql = "INSERT INTO LIB_LIBROS " +
				"(TITULO,DESCRIPCION,ANNO,ISBN,CATEGORIA,PRECIO) " +
				"VALUES(?,?,?,?,?,?)";
		
		try (Connection con = ds.getConnection();
			PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			stm.setString(1, libro.getTitulo());
			stm.setString(2, libro.getDescripcion());
			stm.setInt(3, libro.getAnno()!=null?libro.getAnno():0);
			stm.setString(4, libro.getIsbn());
			stm.setLong(5, libro.getCategoria().getId()!=null?libro.getCategoria().getId():0);
			stm.setBigDecimal(6, libro.getPrecio()!=null?libro.getPrecio():new BigDecimal("0.0"));
			
			int  result = stm.executeUpdate();
			if(result==1){
				try(ResultSet keys = stm.getGeneratedKeys();){
					keys.next();
					libro.setId(keys.getLong(1));
					keys.close();
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccesException(e);
		}
	}

	@Override
	public void guardarAutor(Set<String> autores, Long id_libro) {
		String sql = "INSERT INTO LIB_AUTOR " +
				"(ID_LIBRO,NOMBRE) VALUES(?,?)";
		
		try (Connection con = ds.getConnection();
				PreparedStatement stm = con.prepareStatement(sql)){
			for (String autor : autores) {
				stm.setLong(1, id_libro);
				stm.setString(2, autor);
				stm.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccesException(e);
		}
		
	}

}
