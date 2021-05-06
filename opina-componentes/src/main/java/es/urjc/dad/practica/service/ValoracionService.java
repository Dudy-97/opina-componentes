package es.urjc.dad.practica.service;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.urjc.dad.practica.model.Valoracion;
import es.urjc.dad.practica.repository.ValoracionRepository;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames = "cacheOC")
@Service
public class ValoracionService {

	@Autowired
	private ValoracionRepository valoraciones;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ProductoService productoService;
	
	public ValoracionService() {}
	
	@PostConstruct
	public void init() {
	}
	
	@CacheEvict(allEntries = true)
	public void save(Valoracion valoracion) {
		valoraciones.save(valoracion);
	}
	
	@Cacheable
	public Collection<Valoracion> findAll() {
		return valoraciones.findAll();
	}
	
	@Cacheable
	public Optional<Valoracion> findById(long id) {
		return valoraciones.findById(id);
	}
	
	@Cacheable
	public Optional<Valoracion> find(long id) {
		return valoraciones.findById(id);
	}
	
	@CacheEvict
	public void deleteById(long id) {
		this.valoraciones.deleteById(id);
	}

}




















