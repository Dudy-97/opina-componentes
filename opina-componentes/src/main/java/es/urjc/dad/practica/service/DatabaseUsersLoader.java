package es.urjc.dad.practica.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.urjc.dad.practica.model.Usuario;
import es.urjc.dad.practica.repository.UsuarioRepository;

@Component
public class DatabaseUsersLoader {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostConstruct
	private void initDatabase() {
		usuarioRepository.save(new Usuario("angel@email.com", "Angel", "admin", "ROLE_USER", "ROLE_ADMIN"));
		usuarioRepository.save(new Usuario("victor@email.com", "Victor", "admin", "ROLE_USER", "ROLE_ADMIN"));
	}
}
