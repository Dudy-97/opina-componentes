package es.urjc.dad.practica.service;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import es.urjc.dad.practica.model.Categoria;

@Service
public class CategoriaService {

	private ConcurrentMap<Long, Categoria> categorias = new ConcurrentHashMap<>();
	private AtomicLong nextId = new AtomicLong();
	
	public CategoriaService() {
		save(new Categoria("Graficas"));
		save(new Categoria("Procesadores"));
		save(new Categoria("Placas base"));
	}
	
	public void save(Categoria categoria) {
		long id = nextId.getAndIncrement();
		
		categoria.setId(id);
		
		this.categorias.put(id, categoria);
	}
	
	public Collection<Categoria> findAll() {
		return categorias.values();
	}
	
	public Categoria findById(long id) {
		return categorias.get(id);
	}
	
	public void deleteById(long id) {
		this.categorias.remove(id);
	}
	
	public Categoria buscarPorNombre(String nombre) {	
		for(Categoria categoria : categorias.values()) {
			if(categoria.getNombre().equalsIgnoreCase(nombre)) {
				return categoria;
			}
		}
		return null;
	}
}
