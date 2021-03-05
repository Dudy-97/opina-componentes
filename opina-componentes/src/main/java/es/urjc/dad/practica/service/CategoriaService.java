package es.urjc.dad.practica.service;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.urjc.dad.practica.model.Categoria;
import es.urjc.dad.practica.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categorias;
	
	public CategoriaService() {}
	
	@PostConstruct
	public void init() {
		save(new Categoria("Tarjetas graficas"));
		save(new Categoria("Procesadores"));
		save(new Categoria("Placas base"));
	}
	
	public void save(Categoria categoria) {
		categorias.save(categoria);
	}
	
	public Collection<Categoria> findAll() {
		return categorias.findAll();
	}
	
	public Optional<Categoria> findById(long id) {
		return categorias.findById(id);
	}
	
	public void deleteById(long id) {
		this.categorias.deleteById(id);
	}
	
	public Categoria findByNombre(String nombre) {	
		return categorias.findByNombre(nombre);
	}
}
