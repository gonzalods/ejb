package com.viewnextfor.libreria.bean;

import java.util.Map;

import com.viewnextfor.libreria.dominio.cuenta.Cuenta;
import com.viewnextfor.libreria.dominio.usuario.User;
import com.viewnextfor.libreria.dto.GestionCuenta;
import com.viewnextfor.libreria.dto.Usuario;
import com.viewnextfor.libreria.ensamblador.DetalleCuentaDtoEnsamblador;
import com.viewnextfor.libreria.servicio.ServicioCuenta;
import com.viewnextfor.libreria.servicio.ServicioUsuario;
import com.viewnextfor.libreria.servicio.cuenta.ServicioCuentaFactoria;
import com.viewnextfor.libreria.servicio.usuario.ServicioUsuarioImpl;
import com.viewnextfor.libreria.validator.CuentaValidator;

public class PerfilBean {

	private Usuario usuario;
	private GestionCuenta gestionCuenta;
	private String passwordActualizada;
	private String mensaje;
	private String password_msg;
	private String password_error;
	private Map<String,String> errores;
	
	private CuentaValidator validator;
	
	private ServicioCuenta servicioCuenta;
	private ServicioUsuario servicioUsuario;
	
	public PerfilBean(Usuario usuario) {
		super();
		this.usuario = usuario;
		validator = new CuentaValidator();
		init();
	}
	public PerfilBean() {
		this(null);
	}
	private void init(){
		servicioCuenta = ServicioCuentaFactoria.getInstance();
		servicioUsuario = new ServicioUsuarioImpl();
	}
	public GestionCuenta getGestionCuenta() {
		return gestionCuenta;
	}
	public void setGestionCuenta(GestionCuenta gestionCuenta) {
		this.gestionCuenta = gestionCuenta;
	}
	public String getPasswordActualizada() {
		return passwordActualizada;
	}
	public void setPasswordActualizada(String passwordActualizada) {
		this.passwordActualizada = passwordActualizada;
	}
	public String getMensaje() {
		return mensaje;
	}
	public String getPassword_msg() {
		return password_msg;
	}
	public String getPassword_error() {
		return password_error;
	}
	public Map<String,String> getErrores() {
		return errores;
	}
	public String detallePerfil(){
		
		Cuenta cuenta = servicioCuenta.obtener(usuario.getUsername());
		DetalleCuentaDtoEnsamblador ensamblador = new DetalleCuentaDtoEnsamblador();
		gestionCuenta = ensamblador.toDto(cuenta);
		
		return "/WEB-INF/paginas/cuenta/actualizarCuenta.jsp";
	}
	
	public String actualizarCuenta(){
		errores = validator.validate(gestionCuenta);
		if(!errores.isEmpty()){
			DetalleCuentaDtoEnsamblador ensamblador = new DetalleCuentaDtoEnsamblador();
			Cuenta cuenta = ensamblador.fromDto(gestionCuenta);
			servicioCuenta.actualizar(cuenta);
			mensaje = "Cuenta actualizada correctamente";			
		}
		return "/WEB-INF/paginas/cuenta/actualizarCuenta.jsp";
	}

	public String actualizarPassword(){
		
		User user = new User();
		user.setPassword(passwordActualizada);
		user.setUsername(usuario.getUsername());
		
		servicioUsuario.modificarPassword(user);
		
		password_msg = "Contraseña actualizada correctamente.";
		
		Cuenta cuenta = servicioCuenta.obtener(usuario.getUsername());
		DetalleCuentaDtoEnsamblador ensamblador = new DetalleCuentaDtoEnsamblador();
		gestionCuenta = ensamblador.toDto(cuenta);
		
		return "/WEB-INF/paginas/cuenta/actualizarCuenta.jsp";
	}
	
//	private boolean vaditateCuenta(){
//		boolean result = true;
//		Map<String,String> aux = new LinkedHashMap<>();
//		if(StringUtils.isBlank(gestionCuenta.getNombre())){
//			aux.put("nombre", "El campo Nombre es obligatorio");
//		}
//		if(StringUtils.isBlank(gestionCuenta.getApellidos())){
//			aux.put("apellidos", "El campo Apellidos es obligatorio");
//		}
//		if(StringUtils.isBlank(gestionCuenta.getEmail())){
//			aux.put("email", "El campo Correo Electrónico es obligatorio");
//		}else {
//			Pattern p = Pattern.compile(EMAIL_PATTERN);
//			Matcher m = p.matcher(gestionCuenta.getEmail());
//			if(!m.matches()){
//				aux.put("email", "El campo Correo Electrónico no tiene un formato válido.");
//			}
//		}
//		if(!StringUtils.isBlank(gestionCuenta.getFechaNacimiento())){
//			DateFormat fmt = new  SimpleDateFormat("dd-MM-yyyy");
//			try{
//				fmt.parse(gestionCuenta.getFechaNacimiento());
//			}catch (ParseException e) {
//				aux.put("fechaNacimiento", "El campo Fecha Nacimiento no tiene un formato válido.");
//			}
//		}
//		if(StringUtils.isBlank(gestionCuenta.getCalle())){
//			aux.put("calle", "El campo Calle es obligatorio");
//		}
//		if(StringUtils.isBlank(gestionCuenta.getCiudad())){
//			aux.put("ciudad", "El campo Ciudad es obligatorio");
//		}
//		if(StringUtils.isBlank(gestionCuenta.getCodigoPostal())){
//			aux.put("codigoPostal", "El campo Código Postal es obligatorio");
//		}
//			
//		if(aux.size()!=0){
//			result = false;
//			errores = aux;
//		}
//		return result;
//	}
}
