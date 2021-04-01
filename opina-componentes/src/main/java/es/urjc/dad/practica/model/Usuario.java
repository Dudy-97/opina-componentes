package es.urjc.dad.practica.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(unique=true)
	private String email;
	
	@Column(unique=true)
	private String nombre;
	
	private String pass;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;
	
	@OneToMany(mappedBy="usuario", cascade = CascadeType.ALL)
	private List<Valoracion> lValoraciones; 
	
	public Usuario() {}
	
	public Usuario(String email, String nombre, String pass) {
		super();
		this.email = email;
		this.nombre = nombre;
		this.pass = pass;
		
		lValoraciones = new ArrayList<>();
	}

	public void addValoracion(Valoracion valoracion) {
		lValoraciones.add(valoracion);
		valoracion.setUsuario(this);
	}
	
	public void removeValoracion(Valoracion valoracion) {
		lValoraciones.remove(valoracion);
		valoracion.setUsuario(null);
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

	public List<Valoracion> getlValoraciones() {
		return lValoraciones;
	}

	public void setlValoraciones(List<Valoracion> lValoraciones) {
		this.lValoraciones = lValoraciones;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", nombre=" + nombre + ", pass=" + pass + ", lValoraciones="
				+ lValoraciones + "]";
	}
}
