package com.viewnextfor.libreria.web.catalogo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.viewnextfor.libreria.bean.CatalogoBean;
import com.viewnextfor.libreria.dominio.carrito.Carrito;
import com.viewnextfor.libreria.dto.DetalleLibro;
import com.viewnextfor.libreria.dto.Usuario;

/**
 * Servlet implementation class DetalleServlet
 */
@WebServlet({"/detalleLibro","/cliente/detalleLibro"})
public class DetalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idLibro = request.getParameter("id");
		String titulo = request.getParameter("titulo");
		String categoria = request.getParameter("categoria");
		
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		Carrito carrito = (Carrito)request.getSession().getAttribute("carrito");

		DetalleLibro detalle = new DetalleLibro();
		detalle.setId(idLibro);
		
		CatalogoBean catalogo = new CatalogoBean(usuario, carrito);
		catalogo.setTitulo(titulo);
		catalogo.setCategoria(categoria);
		catalogo.setDetalleLibro(detalle);
		String pagina = catalogo.detalle();
		
		request.setAttribute("catalogo", catalogo);
		request.getRequestDispatcher(pagina).forward(request, response);
	}

}
