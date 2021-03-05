package es.urjc.dad.practica.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(unique=true)
	private String nombre;

	@OneToMany(mappedBy="categoria", cascade=CascadeType.ALL)
	private List<Producto> lProductos;
	
	public Categoria() {}
	
	public Categoria(String nombre) {
		super();
		this.nombre = nombre;
		
		lProductos = new ArrayList<>();
	}
	
	public void addProducto(Producto producto) {
		lProductos.add(producto);
		producto.setCategoria(this);
	}
	
	public void removeProducto(Producto producto) {
		lProductos.remove(producto);
		producto.setCategoria(null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Producto> getlProductos() {
		return lProductos;
	}

	public void setlProductos(List<Producto> lProductos) {
		this.lProductos = lProductos;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + ", lProductos=" + lProductos + "]";
	}
}
