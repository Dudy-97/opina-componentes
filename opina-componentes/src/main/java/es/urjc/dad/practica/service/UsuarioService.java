package es.urjc.dad.practica.service;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.urjc.dad.practica.model.Usuario;
import es.urjc.dad.practica.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarios;
	
	public UsuarioService() {
	}
	
	@PostConstruct
	public void init() {
		save(new Usuario("angel", "angel", "1234"));
		save(new Usuario("victor", "victor", "1234"));
	}
	
	public void save(Usuario usuario) {
		usuarios.save(usuario);
	}
	
	public Collection<Usuario> findAll() {
		return usuarios.findAll();
	}
	
	public Optional<Usuario> findById(long id) {
		return usuarios.findById(id);
	}
	
	public void deleteById(long id) {
		this.usuarios.deleteById(id);
	}
	
	public Usuario buscarPorNombre(String nombre) {
		for(Usuario usuario : usuarios.findAll()) {
			if(usuario.getNombre().equalsIgnoreCase(nombre)) {
				return usuario;
			}
		}
		return null;
	}
}

















