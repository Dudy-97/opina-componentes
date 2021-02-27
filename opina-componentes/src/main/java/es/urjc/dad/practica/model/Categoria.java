package es.urjc.dad.practica.model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

	private Long id;
	private String nombre;

	private List<Producto> productos;
	
	public Categoria() {}
	
	public Categoria(String nombre) {
		super();
		this.nombre = nombre;
		
		productos = new ArrayList<>();
	}
	
	public void addProducto(Producto producto) {
		productos.add(producto);
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

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + "]";
	}
}
