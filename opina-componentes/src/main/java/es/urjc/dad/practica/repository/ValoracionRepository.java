package es.urjc.dad.practica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.dad.practica.model.Valoracion;

public interface ValoracionRepository extends JpaRepository<Valoracion, Long> {

}
