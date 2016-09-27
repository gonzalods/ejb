package com.viewnextfor.libreria.web.ordencompra;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.viewnextfor.libreria.bean.OrdenBean;

/**
 * Servlet implementation class ConfirmarOrdenServlet
 */
@WebServlet("/cliente/confirmarorden")
public class ConfirmarOrdenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OrdenBean orden = (OrdenBean)request.getSession().getAttribute("orden");
		String pagina = orden.confirmar();
		
		request.getSession().removeAttribute("orden");
		request.getSession().removeAttribute("carrito");
		
		request.setAttribute("orden", orden);
		request.getRequestDispatcher(pagina).forward(request, response);
	}

}
