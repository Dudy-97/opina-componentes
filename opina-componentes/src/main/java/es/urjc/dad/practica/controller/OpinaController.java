package es.urjc.dad.practica.controller;


import java.util.Optional;

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
	
	@Autowired
	private UserSession userSession;
	
	
	//index
	@GetMapping("/")
	public String menuPrincipal(Model model) {
		
		Usuario usuario = userSession.getUsuario();
		
    	if(usuario != null  ) {
    		model.addAttribute("sesion_iniciada", true);
    		model.addAttribute("usuario", usuario);
    	} else {
    		model.addAttribute("sesion_iniciada", false);
    	}
		return "index";
	}
	
    
	@GetMapping("/login")
	public String login(Model model) {
		
		return "login";
	}
	
	@PostMapping("/login")
	public String login(Model model, Usuario usuario) {
		
		
		return "login";
	}
}












