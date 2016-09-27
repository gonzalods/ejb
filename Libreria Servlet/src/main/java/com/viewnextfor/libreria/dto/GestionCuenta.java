package com.viewnextfor.libreria.dto;

public class GestionCuenta {

	private String id;
	private String nombre;
	private String apellidos;
	private String fechaNacimiento;
	private String email;
	private String calle;
	private String numero;
	private String piso;
	private String ciudad;
	private String codigoPostal;
	private String nombreusuario;
	
	public GestionCuenta(String id, String nombre, 
			String apellidos, String email, String calle, 
			String ciudad,	String codigoPostal, 
			String nombreusuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.calle = calle;
		this.ciudad = ciudad;
		this.codigoPostal = codigoPostal;
		this.nombreusuario = nombreusuario;
	}
	public GestionCuenta() {
		super();
	}
	public String getId() {
		return id;
	}
	public GestionCuenta setId(String id) {
		this.id = id;
		return this;
	}
	public String getNombre() {
		return nombre;
	}
	public GestionCuenta setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
	public String getApellidos() {
		return apellidos;
	}
	public GestionCuenta setApellidos(String apellidos) {
		this.apellidos = apellidos;
		return this;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public GestionCuenta setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public GestionCuenta setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getCalle() {
		return calle;
	}
	public GestionCuenta setCalle(String calle) {
		this.calle = calle;
		return this;
	}
	public String getNumero() {
		return numero;
	}
	public GestionCuenta setNumero(String numero) {
		this.numero = numero;
		return this;
	}
	public String getPiso() {
		return piso;
	}
	public GestionCuenta setPiso(String piso) {
		this.piso = piso;
		return this;
	}
	public String getCiudad() {
		return ciudad;
	}
	public GestionCuenta setCiudad(String ciudad) {
		this.ciudad = ciudad;
		return this;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public GestionCuenta setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
		return this;
	}
	public String getNombreusuario() {
		return nombreusuario;
	}
	public GestionCuenta setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
		return this;
	}
	
}
