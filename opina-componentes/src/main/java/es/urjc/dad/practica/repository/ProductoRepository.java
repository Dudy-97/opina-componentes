package es.urjc.dad.practica.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.dad.practica.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

	List<Producto> findByCategoriaNombre(String nombre);
	
	Optional<Producto> findByNombre(String nombre);
}
