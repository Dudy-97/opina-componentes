package es.urjc.dad.practica.model;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Column(unique=true)
    private String nombre;
    
    private String descripcion;
    private float precio;
    
    @ManyToOne
    private Categoria categoria;
    
    @OneToMany(mappedBy="producto", cascade=CascadeType.ALL)
    private List<Valoracion> lValoraciones;

    public Producto() {}

    public Producto(String nombre, String descripcion, float precio, Categoria categoria) {
        super();
    	this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        
        lValoraciones = new ArrayList<>();
    }
    
    public void addValoracion(Valoracion valoracion) {
    	lValoraciones.add(valoracion);
    	valoracion.setProducto(this);
    }
    
    public void removeValoracion(Valoracion valoracion) {
    	lValoraciones.remove(valoracion);
    	valoracion.setProducto(null);
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

	public List<Valoracion> getlValoraciones() {
		return lValoraciones;
	}

	public void setlValoraciones(List<Valoracion> lValoraciones) {
		this.lValoraciones = lValoraciones;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", categoria=" + categoria + ", lValoraciones=" + lValoraciones + "]";
	}
}
