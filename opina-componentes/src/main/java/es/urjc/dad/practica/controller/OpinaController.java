package es.urjc.dad.practica.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.dad.practica.model.*;
import es.urjc.dad.practica.service.*;

@Controller
public class OpinaController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	//index
	@GetMapping("/")
	public String menuPrincipal(Model model, HttpServletRequest request) {
		
		Optional<Usuario> usuario;
		
		if(request.getUserPrincipal() != null) {
			usuario = usuarioService.findByNombre(request.getUserPrincipal().getName());
			
			if(usuario.isPresent()) {
				model.addAttribute("sesion_iniciada", true);
				model.addAttribute("usuario", usuario.get().getNombre());
			} else {
				model.addAttribute("sesion_iniciada", false);
			}
		}
		return "index";
	}
	
	
	//Todos los caminos llevan a roma
	@GetMapping("/error")
	public String ErrorHandler(Model model, HttpServletRequest request){
		
		return "error";
	}
}
	
	












