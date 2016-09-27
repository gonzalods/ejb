package com.viewnextfor.libreria.web.usuario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.viewnextfor.libreria.bean.PerfilBean;
import com.viewnextfor.libreria.dto.Usuario;

/**
 * Servlet implementation class CambiarContrasenaServlet
 */
@WebServlet("/cliente/cambiarpassword")
public class CambiarContrasenaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		String password = request.getParameter("password");

		PerfilBean perfil = new PerfilBean(usuario);
		perfil.setPasswordActualizada(password);
		String pagina = perfil.actualizarPassword();
		
		request.setAttribute("perfil", perfil);
		request.getRequestDispatcher(pagina).forward(request, response);
	}

}
