package es.urjc.dad.practica.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.dad.practica.model.*;
import es.urjc.dad.practica.service.*;



@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
    
    @GetMapping("/ver_usuarios")
    public String verUsuarios(Model model) {
    	Collection<Usuario> usuarios = usuarioService.findAll();
    	
    	model.addAttribute("usuarios", usuarios);
    	
    	return "ver_usuarios";
    }
    
    @GetMapping("ver_usuarios/{id}")
    public String verUsuario(Model model, @PathVariable long id, HttpServletRequest request) {
    	
    	Usuario usuario = usuarioService.findById(id).orElseThrow();
    
    	
    	
    	if(usuario.getNombre().equals(request.getUserPrincipal().getName() )) {
    		model.addAttribute("usuarioresena", true);
    	}else{
    		model.addAttribute("usuarioresena", false);
    	}
    	
    	model.addAttribute("admin", request.isUserInRole("ADMIN"));
    	model.addAttribute("usuario", usuario);
    	model.addAttribute("numValoraciones", usuario.getlValoraciones().size());
    	model.addAttribute("valoraciones", usuario.getlValoraciones());
    	
    	return "usuario";
    }
    
    @GetMapping("/ver_usuarios/{id}/eliminar")
    public String eliminarUsuario(Model model, @PathVariable long id) {
    	usuarioService.deleteById(id);
    	
    	return "eliminado";
    }
    
    @GetMapping("/registro")
    public String nuevoUsuario(Model model) {
        return "registro";
    }
    
    @PostMapping("/registro")
    public String nuevoUsuario(Model model, @RequestParam("email") String email,
    		@RequestParam("nombre") String nombre, @RequestParam("pass") String pass) {
    	
    	if(email=="" || nombre=="" || pass=="") {
    		model.addAttribute("faltan_campos", true);
    		return "registro";
    	}
    	
    	Usuario usuario = new Usuario(email, nombre, pass, "ROLE_USER");
    	
    	if(usuarioService.yaExiste(usuario)) {
    		model.addAttribute("yaExiste", true);
    		return "registro";
    	} else {
    		usuarioService.save(usuario);
    		return "login";
    	}
    }
    
    @GetMapping("/login") 
	public String login(Model model, HttpServletRequest request) {
	
	CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
	 model.addAttribute("token", token.getToken());
	 System.out.println(token);
	
		return "login";
	}
    
    
	
	@GetMapping("/loginerror")
	public String loginerror() {
		return "loginerror";
	}
}
	

