package es.urjc.dad.practica.model;

public class Valoracion {

	private long id;
	private Usuario usuario;
	private Producto producto;
	private int nota;
	private String texto;
	
	public Valoracion() {}
	
	public Valoracion(Usuario usuario, Producto producto, int nota, String texto) {
		super();
		this.usuario = usuario;
		this.producto = producto;
		this.nota = nota;
		this.texto = texto;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "Valoracion [id=" + id + ", usuario=" + usuario + ", producto=" + producto + ", nota=" + nota
				+ ", texto=" + texto + "]";
	}
	
	
}
