package es.urjc.dad.practica.model;

import java.util.ArrayList;
import java.util.List;

public class Producto {

    private long id;
    private String nombre;
    private String descripcion;
    private float precio;
    private Categoria categoria;
    
    private List<Valoracion> valoraciones;

    public Producto() {}

    public Producto(String nombre, String descripcion, float precio, Categoria categoria) {
        super();
    	this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        
        valoraciones = new ArrayList<>();
    }
    
    public void addValoracion(Valoracion valoracion) {
    	valoraciones.add(valoracion);
    }
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Valoracion> getValoraciones() {
		return valoraciones;
	}

	public void setValoraciones(List<Valoracion> valoraciones) {
		this.valoraciones = valoraciones;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", categoria=" + categoria + "]";
	}
    
    
}
