package es.urjc.dad.practica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.dad.practica.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
