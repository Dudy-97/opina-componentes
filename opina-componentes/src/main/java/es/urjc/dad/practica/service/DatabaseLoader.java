package es.urjc.dad.practica.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.urjc.dad.practica.model.Categoria;
import es.urjc.dad.practica.model.Producto;
import es.urjc.dad.practica.model.Usuario;
import es.urjc.dad.practica.repository.ProductoRepository;
import es.urjc.dad.practica.repository.UsuarioRepository;
import es.urjc.dad.practica.repository.CategoriaRepository;

@Component
public class DatabaseLoader {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private CategoriaRepository CategoriaRepository;

	@Autowired
	private ProductoRepository ProductoRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@PostConstruct
	private void initDatabase() {
		/*usuarioRepository.save(new Usuario("angel@email.com", "Angel", "admin", "ROLE_USER", "ROLE_ADMIN"));
		usuarioRepository.save(new Usuario("victor@email.com", "Victor", "admin", "ROLE_USER", "ROLE_ADMIN"));	 
		CategoriaRepository.save(new Categoria("Tarjeta grafica"));
		CategoriaRepository.save(new Categoria("Procesador"));
		CategoriaRepository.save(new Categoria("Placa base"));
		ProductoRepository.save(new Producto("RTX 3070", "una buena grafica", 500, categoriaService.findByNombre("Tarjeta grafica").get()));
		ProductoRepository.save(new Producto("RTX 3090", "una grafica mas mejor", 1500, categoriaService.findByNombre("Tarjeta grafica").get()));
		ProductoRepository.save(new Producto("Ryzen 9", "el proce", 400, categoriaService.findByNombre("Procesador").get()));
		ProductoRepository.save(new Producto("Intel 10900K", "el mejor procesador gaming ", 459, categoriaService.findByNombre("Procesador").get()));
		ProductoRepository.save(new Producto("MSI z390", "una placa bien chida", 121200, categoriaService.findByNombre("Placa base").get()));
		ProductoRepository.save(new Producto("Asus Rouge B450", "Placa base gaminmg barata", 40120, categoriaService.findByNombre("Placa base").get()));*/
	     
	}
	
}
