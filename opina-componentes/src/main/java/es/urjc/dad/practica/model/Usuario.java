package es.urjc.dad.practica.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private Long id;
	private String email;
	private String nombre;
	private String pass;
	
	private List<Valoracion> valoraciones; 
	
	public Usuario() {}
	
	public Usuario(String email, String nombre, String pass) {
		this.email = email;
		this.nombre = nombre;
		this.pass = pass;
		
		valoraciones = new ArrayList<>();
	}
	
	public void addValoracion(Valoracion valoracion) {
		valoraciones.add(valoracion);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public List<Valoracion> getValoraciones() {
		return valoraciones;
	}

	public void setValoraciones(List<Valoracion> valoraciones) {
		this.valoraciones = valoraciones;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", nombre=" + nombre + ", pass=" + pass + "]";
	}
}
