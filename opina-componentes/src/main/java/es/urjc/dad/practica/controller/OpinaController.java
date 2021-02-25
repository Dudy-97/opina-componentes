package es.urjc.dad.practica.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import es.urjc.dad.practica.model.*;

@Controller
public class OpinaController {
	
	private List<Producto> lProductos = new ArrayList<>();
	
	public OpinaController() {
		lProductos.add(new Producto("RTX 3070", "Una grafica", 700));
		lProductos.add(new Producto("RTX 3070", "Una grafica", 700));
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		
		return "login";
	}
	
	@GetMapping("/procesadores")
	public String procesadores(Model model) {
		
		return "procesadores";
	}
	
	@GetMapping("/graficas")
	public String graficas(Model model) {
		model.addAttribute("graficas", lProductos);
		
		return "graficas";
	}
	
	@GetMapping("/placas")
	public String placas(Model model) {
		
		return "placas";
	}
	
	@GetMapping("/graficas/{graficaId}")
	public String mostrarProducto(Model model, @PathVariable int graficaId) {
		Producto producto = lProductos.get(graficaId - 1);
		
		model.addAttribute("producto", producto);
		model.addAttribute("graficaId", graficaId);
		
		return "producto";
	}
}












