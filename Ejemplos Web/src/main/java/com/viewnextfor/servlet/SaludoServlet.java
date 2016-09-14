package com.viewnextfor.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.viewnextfor.bean.SaludoBean;
import com.viewnextfor.servicio.SaludoNewApi;
import com.viewnextfor.servicio.ServicioSaludo;

/**
 * Servlet implementation class SaludoServlet
 */
@WebServlet("/saludo")
public class SaludoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/paginas/datospersona.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		SaludoBean saludo = new SaludoBean();
		saludo.setNombre(nombre);
		ServicioSaludo servicio = new SaludoNewApi();
		servicio.crearSaludo(saludo);
		request.setAttribute("saludo", saludo);
		request.getRequestDispatcher("/WEB-INF/paginas/saludo.jsp").forward(request, response);
	}

}
