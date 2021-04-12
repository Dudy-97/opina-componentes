package es.urjc.dad.practica.service;

import java.util.Collection;
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
		/*save(new Producto("RTX 3070", "una buena grafica", 500, categoriaService.findByNombre("Tarjeta grafica")));
		save(new Producto("RTX 3090", "una grafica mas mejor", 1500, categoriaService.findByNombre("Tarjeta grafica")));
		save(new Producto("Ryzen 9", "el proce", 400, categoriaService.findByNombre("Procesador")));
        save(new Producto("Intel 10900K", "el mejor procesador gaming ", 459, categoriaService.findByNombre("Procesador")));
        save(new Producto("MSI z390", "una placa bien chida", 121200, categoriaService.findByNombre("Placa base")));
        save(new Producto("Asus Rouge B450", "Placa base gaminmg barata", 40120, categoriaService.findByNombre("Placa base")));*/
	}
	
	public void save(Producto producto) {
		productos.save(producto);
	}
	
	public Collection<Producto> findAll() {
		return productos.findAll();
	}
	
	public List<Producto> findByCategoriaNombre(String categoria) {
		return productos.findByCategoriaNombre(categoria);
	}
	
	public Optional<Producto> findById(long id) {
		return productos.findById(id);
	}
	
	public void deleteById(long id) {
		this.productos.deleteById(id);
	}
	
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

















