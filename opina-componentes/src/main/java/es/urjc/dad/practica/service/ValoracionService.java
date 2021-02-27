package es.urjc.dad.practica.service;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.urjc.dad.practica.model.Valoracion;

@Service
public class ValoracionService {

	private ConcurrentMap<Long, Valoracion> valoraciones = new ConcurrentHashMap<>();
	private AtomicLong nextId = new AtomicLong();
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ProductoService productoService;
	
	public ValoracionService() {}
	
	@PostConstruct
	public void init() {
		save(new Valoracion(usuarioService.buscarPorNombre("angel"), productoService.buscarPorNombre("RTX 3070"),
				85, "Ta wapa"));
		save(new Valoracion(usuarioService.buscarPorNombre("victor"), productoService.buscarPorNombre("RTX 3070"),
				90, "PC master race"));
	}
	
	public void save(Valoracion valoracion) {
		long id = nextId.getAndIncrement();
		
		valoracion.setId(id);
		
		this.valoraciones.put(id, valoracion);
	}
	
	public Collection<Valoracion> findAll() {
		return valoraciones.values();
	}
	
	public Valoracion findById(long id) {
		return valoraciones.get(id);
	}
	
	public void deleteById(long id) {
		this.valoraciones.remove(id);
	}
}




















