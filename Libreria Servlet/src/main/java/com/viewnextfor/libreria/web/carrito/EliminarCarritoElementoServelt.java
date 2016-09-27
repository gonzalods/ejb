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
 * Servlet implementation class EliminarCarritoElementoServelt
 */
@WebServlet({"/anonimo/eliminarElementoCarrito", "/cliente/eliminarElementoCarrito"})
public class EliminarCarritoElementoServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarCarritoElementoServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idEliminar = request.getParameter("id");
		
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		Carrito car = (Carrito)request.getSession().getAttribute("carrito");
		
		CarritoBean carrito = new CarritoBean(usuario,car);
		carrito.setIdEliminar(idEliminar);
		String pagina = carrito.elimiarItem();
		
		if(carrito.getCarrito() == null){
			request.getSession().removeAttribute("carrito");
		}else{
			request.setAttribute("carritoBean", carrito);
		}
		request.getRequestDispatcher(pagina).forward(request, response);
		
	}
}











