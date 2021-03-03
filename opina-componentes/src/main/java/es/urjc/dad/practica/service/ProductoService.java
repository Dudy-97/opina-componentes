package es.urjc.dad.practica.service;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.urjc.dad.practica.model.Producto;

@Service
public class ProductoService {

	private ConcurrentMap<Long, Producto> productos = new ConcurrentHashMap<>();
	private AtomicLong nextId = new AtomicLong();
	
	@Autowired
	private CategoriaService categoriaService;
	
	public ProductoService() {}
	
	@PostConstruct
	public void init() {
		save(new Producto("RTX 3070", "una buena grafica", 500, categoriaService.buscarPorNombre("graficas")));
		save(new Producto("RTX 3090", "una grafica mas mejor", 1500, categoriaService.buscarPorNombre("graficas")));
		save(new Producto("Ryzen 9", "el proc", 400, categoriaService.buscarPorNombre("procesadores")));
	}
	
	public void save(Producto producto) {
		long id = nextId.getAndIncrement();
		
		producto.setId(id);
		
		this.productos.put(id, producto);
	}
	
	public Collection<Producto> findAll() {
		return productos.values();
	}
	
	public List<Producto> findAllByCategoria(String categoria) {
		List<Producto> aux = new ArrayList<>();
		for(Producto producto : productos.values()) {
			if(producto.getCategoria().getNombre().equalsIgnoreCase(categoria)) {
				aux.add(producto);
			}
		}
		
		return aux;
	}
	
	public Producto findById(long id) {
		return productos.get(id);
	}
	
	public void deleteById(long id) {
		this.productos.remove(id);
	}
	
	public Producto buscarPorNombre(String nombre) {
		for(Producto producto : productos.values()) {
			if(producto.getNombre().equalsIgnoreCase(nombre)) {
				return producto;
			}
		}
		return null;
	}
}

















