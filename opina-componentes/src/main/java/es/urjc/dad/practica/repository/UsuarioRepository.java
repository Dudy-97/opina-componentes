package es.urjc.dad.practica.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.dad.practica.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByNombre(String nombre);
	Optional<Usuario> findByEmail(String email);
}
