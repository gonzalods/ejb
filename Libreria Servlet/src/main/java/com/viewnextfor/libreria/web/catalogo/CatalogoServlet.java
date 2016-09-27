package com.viewnextfor.libreria.web.catalogo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.viewnextfor.libreria.bean.CatalogoBean;

/**
 * Servlet implementation class CatalogoServlet
 */
@WebServlet({ "/catalogo", "/cliente/catalogo" })
public class CatalogoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		CatalogoBean catalogo = new CatalogoBean();
		request.setAttribute("catalogo", catalogo);
		request.getRequestDispatcher("/WEB-INF/paginas/catalogo/catalogo.jsp")
				.forward(request, response);
	}

}





