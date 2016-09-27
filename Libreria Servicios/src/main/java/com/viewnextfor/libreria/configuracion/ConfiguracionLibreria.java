package com.viewnextfor.libreria.configuracion;

public class ConfiguracionLibreria {

	private static boolean seguro;
	private static boolean ioc;
	private static BBDD basedatos = new BBDD();
	
	public static boolean isSeguro(){
		return seguro;
	}
	
	public static void setSeguro(boolean seguro){
		ConfiguracionLibreria.seguro = seguro;
	}

	public static boolean isIoc() {
		return ioc;
	}

	public static void setIoc(boolean ioc) {
		ConfiguracionLibreria.ioc = ioc;
	}
	
	public static boolean isBaseDatos(){
		return basedatos.esBBDD;
	}
	public static String getBasedatos() {
		return basedatos.tipo;
	}

	public static void setBasedatos(String basedatos) {
		ConfiguracionLibreria.basedatos.esBBDD=true;
		ConfiguracionLibreria.basedatos.tipo = basedatos;
	}

	private static class BBDD{
		boolean esBBDD;
		String tipo="jdbc";
	}
}
