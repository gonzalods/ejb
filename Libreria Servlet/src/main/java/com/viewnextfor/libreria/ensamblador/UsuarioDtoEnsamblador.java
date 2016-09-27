package com.viewnextfor.libreria.ensamblador;

import java.util.Collections;
import java.util.Set;

import com.viewnextfor.libreria.dominio.usuario.User;
import com.viewnextfor.libreria.dto.Usuario;

public class UsuarioDtoEnsamblador {

	public Usuario toDto(User user, String rol){
		String rolSel = null;
		
		if(rol != null && user.getAuthority().contains(rol)){
			rolSel = rol;
		}
		Usuario dto = new Usuario(user.getUsername(), rolSel);
		
		return dto;
	}
	
	public User fromDto(Usuario dto, String password){
		User user = new User(dto.getUsername(), password, true);
		Set<String> roles = Collections.singleton(dto.getRol());
		user.setAuthority(roles);
		return user;
	}
}
