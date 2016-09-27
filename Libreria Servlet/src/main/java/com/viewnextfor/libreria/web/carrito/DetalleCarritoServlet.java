package com.viewnextfor.libreria.web.carrito;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.viewnextfor.libreria.bean.CarritoBean;
import com.viewnextfor.libreria.dominio.carrito.Carrito;
import com.viewnextfor.libreria.dto.Usuario;

/**
 * Servlet implementation class DetalleCarritoServlet
 */
@WebServlet("/cliente/verCarrito")
public class DetalleCarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		Carrito car = (Carrito)request.getSession().getAttribute("carrito");
		
		CarritoBean carrito = new CarritoBean(usuario,car);
		String pagina = carrito.detalle();
		
		request.setAttribute("carritoBean", carrito);
		request.getRequestDispatcher(pagina).forward(request, response);
	}

}
