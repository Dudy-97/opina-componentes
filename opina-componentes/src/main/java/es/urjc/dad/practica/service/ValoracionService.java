package es.urjc.dad.practica.service;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.urjc.dad.practica.model.Valoracion;
import es.urjc.dad.practica.repository.ValoracionRepository;

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
		/*save(new Valoracion(usuarioService.findByNombre("angel"), productoService.findByNombre("RTX 3070"),
				85, "Ta wapa"));
		save(new Valoracion(usuarioService.findByNombre("victor"), productoService.findByNombre("RTX 3070"),
				90, "PC master race"));*/
	}
	
	public void save(Valoracion valoracion) {
		valoraciones.save(valoracion);
	}
	
	public Collection<Valoracion> findAll() {
		return valoraciones.findAll();
	}
	
	public Optional<Valoracion> findById(long id) {
		return valoraciones.findById(id);
	}
	
	public void deleteById(long id) {
		this.valoraciones.deleteById(id);
	}
}




















