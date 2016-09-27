package com.viewnextfor.libreria.bean;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.viewnextfor.libreria.dominio.carrito.Carrito;
import com.viewnextfor.libreria.dominio.carrito.ItemCarrito;
import com.viewnextfor.libreria.dominio.libro.Categoria;
import com.viewnextfor.libreria.dominio.libro.Libro;
import com.viewnextfor.libreria.dto.DetalleLibro;
import com.viewnextfor.libreria.dto.ListaLibro;
import com.viewnextfor.libreria.dto.Usuario;
import com.viewnextfor.libreria.ensamblador.LibroDetalleDtoEnsamblador;
import com.viewnextfor.libreria.ensamblador.LibroListaDtoEnsamblador;
import com.viewnextfor.libreria.servicio.ServicioLibro;
import com.viewnextfor.libreria.servicio.bean.FiltroBusqueda;
import com.viewnextfor.libreria.servicio.libro.ServicioLibroFactoria;

public class CatalogoBean {

	private List<Categoria> categorias;
	private List<ListaLibro>  listLibros;
	private DetalleLibro detalleLibro;
	private String titulo;
	private String categoria;
	private Usuario usuario;
	private Carrito carrito;
	private String msg_busqueda;
	private String cantidad;
	private String msg_carrito;
	
	private ServicioLibro servicioLibro;
	
	public CatalogoBean() {
		this(null,null);
	}
	
	
	public CatalogoBean(Usuario usuario, Carrito carrito) {
		this.carrito = carrito;
		this.usuario = usuario;
		init();
	}

	private void init(){
		servicioLibro = ServicioLibroFactoria.getInstance();
	}
	
	public List<Categoria> getCategorias() {
		if(this.categorias == null){
			this.categorias = servicioLibro.buscarTodasCategorias();
		}
		return this.categorias;
	}
	public List<ListaLibro> getListLibros() {
		return listLibros;
	}
	public void setListLibros(List<ListaLibro> listLibros) {
		this.listLibros = listLibros;
	}
	public DetalleLibro getDetalleLibro() {
		return detalleLibro;
	}
	public void setDetalleLibro(DetalleLibro detalleLibro) {
		this.detalleLibro = detalleLibro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public Carrito getCarrito() {
		return carrito;
	}
	public String getMsg_busqueda() {
		return msg_busqueda;
	}
	public void setMsg_busqueda(String msg_busqueda) {
		this.msg_busqueda = msg_busqueda;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getMsg_carrito() {
		return msg_carrito;
	}


	public void setMsg_carrito(String msg_carrito) {
		this.msg_carrito = msg_carrito;
	}


	public String buscar(){
		FiltroBusqueda filtro = new FiltroBusqueda();
		filtro.setTitulo(titulo);
		filtro.setCategoria(categoria!=null?Long.parseLong(categoria):null);
		
		List<Libro> libros = servicioLibro.buscarLibros(filtro);
		LibroListaDtoEnsamblador libroEnsamblador = new LibroListaDtoEnsamblador(); 
		listLibros = libroEnsamblador.toDtoList(libros);
		
		if(listLibros.isEmpty()){
			msg_busqueda = "No hay resultado para el criterio de búsqueda";
		}
		return "/WEB-INF/paginas/catalogo/catalogo.jsp";
	}
	
	public String detalle(){
		Long id = Long.valueOf(detalleLibro.getId());
		Libro libro = servicioLibro.buscarLibro(id);
		LibroDetalleDtoEnsamblador ensamblador = new LibroDetalleDtoEnsamblador();
		detalleLibro = ensamblador.toDto(libro);
		return "/WEB-INF/paginas/catalogo/catalogo.jsp";
	}
	
	public String anadirACarrito(){
		Long id = Long.valueOf(detalleLibro.getId());
		Libro libro = servicioLibro.buscarLibro(id);
		LibroDetalleDtoEnsamblador ensamblador = new LibroDetalleDtoEnsamblador();
		detalleLibro = ensamblador.toDto(libro);
		if(!StringUtils.isNumeric(cantidad)){
			msg_carrito = "Cantidad tiene que ser alfanumérico.";
			return "/WEB-INF/paginas/catalogo/catalogo.jsp";
		}
		
		ItemCarrito newItem = new ItemCarrito();
		newItem.setId(libro.getId());
		newItem.setTitulo(libro.getTitulo());
		newItem.setPrecio(libro.getPrecio());
		newItem.setCantidad(Integer.valueOf(cantidad));
		carrito.addItem(newItem);
		
		return "/WEB-INF/paginas/catalogo/catalogo.jsp";
	}
}
