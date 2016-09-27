package com.viewnextfor.libreria.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InicioServlet
 */
@WebServlet("/")
public class InicioServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!request.getRequestURI().endsWith("/")){
			response.sendRedirect(request.getContextPath()+"/");
		}else{
			request.getRequestDispatcher("/WEB-INF/paginas/inicio.jsp").forward(request, response);
		}
	}

}
