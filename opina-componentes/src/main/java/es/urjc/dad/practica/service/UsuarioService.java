package es.urjc.dad.practica.service;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.urjc.dad.practica.model.Usuario;
import es.urjc.dad.practica.repository.UsuarioRepository;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames="cacheOC")
@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarios;
	
	public UsuarioService() {
	}
	
	@PostConstruct
	public void init() {
		/*save(new Usuario("angel", "angel", "1234"));
		save(new Usuario("victor", "victor", "1234"));*/
	}
	
	@CacheEvict(allEntries = true)
	public void save(Usuario usuario) {
		usuarios.save(usuario);
	}
	
	@Cacheable
	public Collection<Usuario> findAll() {
		return usuarios.findAll();
	}
	
	@Cacheable
	public Optional<Usuario> findById(long id) {
		return usuarios.findById(id);
	}
	
	@CacheEvict
	public void deleteById(long id) {
		this.usuarios.deleteById(id);
	}
	
	@Cacheable
	public Optional<Usuario> findByNombre(String nombre) {
		return usuarios.findByNombre(nombre);
	}
	
	@Cacheable
	public Optional<Usuario> findByEmail(String email) {
		return usuarios.findByEmail(email);
	}
	
	public Boolean yaExiste(Usuario usuario) {
		if(usuarios.findByEmail(usuario.getEmail()).isPresent() || usuarios.findByNombre(usuario.getNombre()).isPresent()) {
			return true;
		}
		return false;
	}
}

















