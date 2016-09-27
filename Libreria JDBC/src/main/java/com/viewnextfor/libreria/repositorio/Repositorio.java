package com.viewnextfor.libreria.repositorio;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public abstract class Repositorio {

	protected DataSource ds;
	
	public Repositorio() {
		try {
			ds = (DataSource)new InitialContext().lookup("jdbc/LibreriaDB");
		} catch (NamingException e) {e.printStackTrace();}
		
	}

//	protected Connection conectar() throws SQLException{
//		Connection con = UnidadTrasaccion.get();
//		if(con==null){
//			con = ds.getConnection();
//		}
//		return con;
//	}
//	
//	protected void desconectar(Connection con, Statement stm, ResultSet rs) {
//		try {
//			if(rs!=null)
//				rs.close();
//		} catch (SQLException e) {
//		}
//		try {
//			if(stm!=null)
//				stm.close();
//		} catch (SQLException e) {
//		}
//		try {
//			if(UnidadTrasaccion.get()==null && con!=null)
//				con.close();
//		} catch (SQLException e) {
//		}
//	}
}
