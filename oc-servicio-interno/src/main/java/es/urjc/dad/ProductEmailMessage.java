package es.urjc.dad;

public class ProductEmailMessage {

	private String email;
	private String nombreProducto;

	public ProductEmailMessage(String email, String nombreProducto) {
		this.email = email;
		this.nombreProducto = nombreProducto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	@Override
	public String toString() {
		return "ProductEmailMessage [email=" + email + ", nombreProducto=" + nombreProducto + "]";
	}

	
}
