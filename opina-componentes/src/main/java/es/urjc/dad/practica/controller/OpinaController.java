package es.urjc.dad.practica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import es.urjc.dad.practica.model.*;
import es.urjc.dad.practica.service.*;

@Controller
public class OpinaController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/login")
	public String login(Model model) {
		
		return "login";
	}
	
	@GetMapping("/registro")
	public String registro(Model model) {
		
		return "registro";
	}
	
	@GetMapping("/procesadores")
	public String procesadores(Model model) {
		
		return "procesadores";
	}
	
	@GetMapping("/graficas")
	public String graficas(Model model) {
		
		return "graficas";
	}
	
	@GetMapping("/placas")
	public String placas(Model model) {
		
		return "placas";
	}
	
	@GetMapping("/graficas/{graficaId}")
	public String mostrarProducto(Model model, @PathVariable int graficaId) {
		
		return "producto";
	}
	
	@GetMapping("/procesadores/{procesadorId}")
    public String mostrarProcesador(Model model, @PathVariable int procesadorId) {

        return "producto";
    }

    @GetMapping("/placas/{placaId}") 
    public String mostrarPlacas(Model model, @PathVariable int placaId) {

        return "producto";
    }
}












