package es.urjc.dad.practica.service;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import es.urjc.dad.practica.model.Usuario;

@Service
public class UsuarioService {

	private ConcurrentMap<Long, Usuario> usuarios = new ConcurrentHashMap<>();
	private AtomicLong nextId = new AtomicLong();
	
	public UsuarioService() {
		save(new Usuario("angel", "angel", "1234"));
		save(new Usuario("victor", "victor", "1234"));
	}
	
	public void save(Usuario usuario) {
		long id = nextId.getAndIncrement();
		
		usuario.setId(id);
		
		this.usuarios.put(id, usuario);
	}
	
	public Collection<Usuario> findAll() {
		return usuarios.values();
	}
	
	public Usuario findById(long id) {
		return usuarios.get(id);
	}
	
	public void deleteById(long id) {
		this.usuarios.remove(id);
	}
	
	public Usuario buscarPorNombre(String nombre) {
		for(Usuario usuario : usuarios.values()) {
			if(usuario.getNombre().equalsIgnoreCase(nombre)) {
				return usuario;
			}
		}
		return null;
	}
}

















