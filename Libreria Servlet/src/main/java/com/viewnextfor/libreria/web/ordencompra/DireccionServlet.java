package com.viewnextfor.libreria.web.ordencompra;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.viewnextfor.libreria.bean.OrdenBean;
import com.viewnextfor.libreria.dominio.carrito.Carrito;
import com.viewnextfor.libreria.dto.DireccionDto;
import com.viewnextfor.libreria.dto.Usuario;

/**
 * Servlet implementation class DireccionServlet
 */
@WebServlet({ "/cliente/direccion", "/cliente/obtenerdirentrega", "/cliente/resumen","/cliente/vueltadireccion" })
public class DireccionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String pagina = null;
		if(uri.endsWith("/direccion")){
			Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
			Carrito carrito = (Carrito)request.getSession().getAttribute("carrito");
			OrdenBean orden = new OrdenBean(usuario, carrito);
			pagina = orden.direccion();
			request.getSession().setAttribute("orden", orden);
		}else if(uri.endsWith("/obtenerdirentrega")){
			String cobroIgualEntrega = request.getParameter("cobroIgualEntrega");
			OrdenBean orden = (OrdenBean)request.getSession().getAttribute("orden");
			orden.setCobroIgualEntrega(cobroIgualEntrega != null?true:false);
			pagina = orden.obtenerdirentrega();
		}else if(uri.endsWith("/vueltadireccion")){
			OrdenBean orden = (OrdenBean)request.getSession().getAttribute("orden");
			pagina = orden.vueltadireccion();
		}
		request.getRequestDispatcher(pagina).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrdenBean orden = (OrdenBean)request.getSession().getAttribute("orden");
		boolean cobroIgualEntrega = orden.isCobroIgualEntrega();
		if(!cobroIgualEntrega){
			String calle = request.getParameter("calle");
			String piso = request.getParameter("piso");
			String numero = request.getParameter("numero");
			String ciudad = request.getParameter("ciudad");
			String codigoPosta = request.getParameter("codigoPostal");
			DireccionDto dirEntrega = new DireccionDto();
			dirEntrega.setCalle(calle);
			dirEntrega.setPiso(piso);
			dirEntrega.setNumero(numero);
			dirEntrega.setCiudad(ciudad);
			dirEntrega.setCodigoPostal(codigoPosta);
			orden.setDirEntrega(dirEntrega);
		}
		String pagina = orden.resumen();
		request.getRequestDispatcher(pagina).forward(request, response);
		
	}

}
