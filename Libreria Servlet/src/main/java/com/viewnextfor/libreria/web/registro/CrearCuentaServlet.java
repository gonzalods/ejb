package com.viewnextfor.libreria.web.registro;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.viewnextfor.libreria.bean.RegistroBean;
import com.viewnextfor.libreria.dto.GestionCuenta;

/**
 * Servlet implementation class CrearCuentaServlet
 */
@WebServlet("/crearcuenta")
public class CrearCuentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RegistroBean registro = (RegistroBean)request.getSession().getAttribute("registro");
		
		GestionCuenta gestionCuenta = new GestionCuenta();
		gestionCuenta.setId(request.getParameter("id"))
			.setNombre(request.getParameter("nombre"))
			.setApellidos(request.getParameter("apellidos"))
			.setEmail(request.getParameter("email"))
			.setFechaNacimiento(request.getParameter("fechaNacimiento"))
			.setCalle(request.getParameter("calle"))
			.setNumero(request.getParameter("numero"))
			.setPiso(request.getParameter("piso"))
			.setCiudad(request.getParameter("ciudad"))
			.setCodigoPostal(request.getParameter("codigoPostal"));
		
		registro.setCuenta(gestionCuenta);
		String pagina = registro.crearCuenta();
		
		if(StringUtils.startsWith(pagina, "redirect:")){
			String redirect = StringUtils.removeStart(pagina, "redirect:");
			request.getSession().setAttribute("usuario", registro.getUsuario());
			request.getSession().removeAttribute("registro");
			response.sendRedirect(redirect);
		}else{
			request.getRequestDispatcher(pagina).forward(request, response);
		}
		
	}

}
