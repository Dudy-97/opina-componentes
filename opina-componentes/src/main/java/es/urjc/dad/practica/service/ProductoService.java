package es.urjc.dad.practica.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.urjc.dad.practica.model.Producto;
import es.urjc.dad.practica.repository.ProductoRepository;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames="cacheOC")
@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository productos;
	
	@Autowired
	private CategoriaService categoriaService;
	
	public ProductoService() {}
	
	@PostConstruct
	public void init() {
	}
	
	
	@CacheEvict(allEntries = true)
	public void save(Producto producto) {
		productos.save(producto);
	}
	
	@Cacheable
	public Collection<Producto> findAll() {
		return productos.findAll();
	}
	
	@Cacheable
	public List<Producto> findByCategoriaNombre(String categoria) {
		return productos.findByCategoriaNombre(categoria);
	}
	
	@Cacheable
	public Optional<Producto> findById(long id) {
		return productos.findById(id);
	}
	
	@CacheEvict
	public void deleteById(long id) {
		this.productos.deleteById(id);
	}
	
	@Cacheable
	public Optional<Producto> findByNombre(String nombre) {
		return productos.findByNombre(nombre);
	}
	
	public Boolean yaExiste(Producto producto) {
		if(productos.findByNombre(producto.getNombre()).isPresent()) {
			return true;
		}
		return false;
	}
}

















