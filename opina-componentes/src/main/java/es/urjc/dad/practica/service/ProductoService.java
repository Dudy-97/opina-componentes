package es.urjc.dad.practica.service;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.urjc.dad.practica.model.Producto;
import es.urjc.dad.practica.repository.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository productos;
	
	@Autowired
	private CategoriaService categoriaService;
	
	public ProductoService() {}
	
	@PostConstruct
	public void init() {
		save(new Producto("RTX 3070", "una buena grafica", 500, categoriaService.buscarPorNombre("tarjetas graficas")));
		save(new Producto("RTX 3090", "una grafica mas mejor", 1500, categoriaService.buscarPorNombre("tarjetas graficas")));
		save(new Producto("Ryzen 9", "el proce", 400, categoriaService.buscarPorNombre("procesadores")));
	}
	
	public void save(Producto producto) {
		productos.save(producto);
	}
	
	public Collection<Producto> findAll() {
		return productos.findAll();
	}
	
	public List<Producto> findAllByCategoria(String categoria) {
		List<Producto> aux = new ArrayList<>();
		for(Producto producto : productos.findAll()) {
			if(producto.getCategoria().getNombre().equalsIgnoreCase(categoria)) {
				aux.add(producto);
			}
		}
		
		return aux;
	}
	
	public Optional<Producto> findById(long id) {
		return productos.findById(id);
	}
	
	public void deleteById(long id) {
		this.productos.deleteById(id);
	}
	
	public Producto buscarPorNombre(String nombre) {
		for(Producto producto : productos.findAll()) {
			if(producto.getNombre().equalsIgnoreCase(nombre)) {
				return producto;
			}
		}
		return null;
	}
}

















