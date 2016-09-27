package com.viewnextfor.libreria.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.viewnextfor.libreria.bean.LoginBean;
import com.viewnextfor.libreria.dto.Usuario;



/**
 * Servlet implementation class RegistroServlet
 */
@WebServlet({"/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/paginas/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Usuario usuario = new Usuario(username, null);
		LoginBean login = new LoginBean();
		login.setPassword(password);
		login.setUsuario(usuario);
		
		String pagina = login.login();
		
		request.setAttribute("login", login);
		if(StringUtils.startsWith(pagina, "redirect:")){
			String redirect = StringUtils.removeStart(pagina, "redirect:");
			request.getSession().setAttribute("usuario", login.getUsuario());
			
			response.sendRedirect(redirect);
		}else{
			request.getRequestDispatcher(pagina).forward(request, response);
		}
	}

}












