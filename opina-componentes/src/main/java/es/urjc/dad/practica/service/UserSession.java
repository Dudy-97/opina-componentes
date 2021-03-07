package es.urjc.dad.practica.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import es.urjc.dad.practica.model.Usuario;

@Component
@SessionScope
public class UserSession {

	private Usuario usuario;
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
}
