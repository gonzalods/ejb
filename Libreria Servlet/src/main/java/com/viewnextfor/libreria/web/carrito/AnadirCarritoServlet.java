package com.viewnextfor.libreria.web.carrito;

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
 * Servlet implementation class AnadirCarritoServlet
 */
@WebServlet("/cliente/anadirCarrito")
public class AnadirCarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String strId = request.getParameter("id");
		String strCantidad = request.getParameter("cantidad");
		String titulo = request.getParameter("titulo");
		String categoria = request.getParameter("categoria");
				
		
		Carrito carrito = (Carrito)request.getSession().getAttribute("carrito");
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		if(carrito==null){
			carrito = new Carrito();
			request.getSession().setAttribute("carrito", carrito);
		}
		
		DetalleLibro detalle = new DetalleLibro();
		detalle.setId(strId);
		CatalogoBean catalogo = new CatalogoBean(usuario, carrito);
		catalogo.setCantidad(strCantidad);
		catalogo.setDetalleLibro(detalle);
		catalogo.setTitulo(titulo);
		catalogo.setCategoria(categoria);
		
		String pagina = catalogo.anadirACarrito();
		
		request.setAttribute("catalogo", catalogo);
		request.getRequestDispatcher(pagina).forward(request, response);
		
		
	}

}
