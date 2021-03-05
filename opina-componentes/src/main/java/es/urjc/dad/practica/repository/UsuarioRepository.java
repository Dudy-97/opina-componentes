package es.urjc.dad.practica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.dad.practica.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByNombre(String nombre);
}
