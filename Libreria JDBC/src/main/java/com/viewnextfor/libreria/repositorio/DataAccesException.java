package com.viewnextfor.libreria.repositorio;

@SuppressWarnings("serial")
public class DataAccesException extends RuntimeException {

	public DataAccesException(){}
	public DataAccesException(String msg){
		super(msg);
	}
	public DataAccesException(Throwable t){
		super(t);
	}
	
}
