package com.viewnextfor.libreria.web.cuenta;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.viewnextfor.libreria.bean.PerfilBean;
import com.viewnextfor.libreria.dto.GestionCuenta;
import com.viewnextfor.libreria.dto.Usuario;

/**
 * Servlet implementation class ActualizarCuentaServlet
 */
@WebServlet("/cliente/cuenta")
public class ActualizarCuentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		
		PerfilBean perfil = new PerfilBean(usuario);
		String pagina = perfil.detallePerfil();
		request.setAttribute("perfil", perfil);
		request.getRequestDispatcher(pagina).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		
		PerfilBean perfil = new PerfilBean(usuario);
		
		GestionCuenta gestionCuenta = new GestionCuenta();
		gestionCuenta.setId(request.getParameter("id"))
			.setNombre(request.getParameter("nombre"))
			.setApellidos(request.getParameter("apellidos"))
			.setEmail(request.getParameter("email"))
			.setNombreusuario(usuario.getUsername())
			.setFechaNacimiento(request.getParameter("fechaNacimiento"))
			.setCalle(request.getParameter("calle"))
			.setNumero(request.getParameter("numero"))
			.setPiso(request.getParameter("piso"))
			.setCiudad(request.getParameter("ciudad"))
			.setCodigoPostal(request.getParameter("codigoPostal"));
		
		perfil.setGestionCuenta(gestionCuenta);
		String pagina = perfil.actualizarCuenta();
		
		request.setAttribute("perfil", perfil);
		request.getRequestDispatcher(pagina).forward(request, response);
	}

}























