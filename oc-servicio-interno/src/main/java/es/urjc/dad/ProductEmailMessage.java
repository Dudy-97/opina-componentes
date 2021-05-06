package es.urjc.dad;

import java.util.ArrayList;
import java.util.List;

public class ProductEmailMessage {

	private List<String> emails;
	private String nombreProducto;
	
	public ProductEmailMessage(List<String> emails, String nombreProducto) {
		this.emails = new ArrayList<>(emails);
		this.nombreProducto = nombreProducto;
	}
	
	public List<String> getEmails() {
		return emails;
	}
	
	public void setEmail(List<String> emails) {
		this.emails = new ArrayList<>(emails);
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	@Override
	public String toString() {
		return "ProductEmailMessage [emails=" + emails + ", nombreProducto=" + nombreProducto + "]";
	}	
}
