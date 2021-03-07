package es.urjc.dad.practica.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;



@Component
@SessionScope
public class UserSession {

	private Usuario usuario;
}
