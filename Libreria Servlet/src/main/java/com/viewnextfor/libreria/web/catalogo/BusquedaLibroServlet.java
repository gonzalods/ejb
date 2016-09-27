package com.viewnextfor.libreria.web.catalogo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.viewnextfor.libreria.bean.CatalogoBean;
import com.viewnextfor.libreria.dominio.carrito.Carrito;
import com.viewnextfor.libreria.dto.Usuario;

/**
 * Servlet implementation class BusquedaLibroServlet
 */
@WebServlet({"/busquedaLibro", "/cliente/busquedaLibro"})
public class BusquedaLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String titulo = request.getParameter("titulo");
		String idCat = request.getParameter("categoria");

		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		Carrito carrito = (Carrito)request.getSession().getAttribute("carrito");
		CatalogoBean catalogoBean = new CatalogoBean(usuario, carrito);
		catalogoBean.setCategoria(idCat);
		catalogoBean.setTitulo(titulo);
		
		String pagina = catalogoBean.buscar();
		
		request.setAttribute("catalogo", catalogoBean);
		request.getRequestDispatcher(pagina).forward(request, response);
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	
	
}	












