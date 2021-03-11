package es.urjc.dad.practica.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import es.urjc.dad.practica.model.*;
import es.urjc.dad.practica.service.*;



@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UserSession userSession;
	
	
	@GetMapping("/cerrar_sesion")
	public String cerrarSesion(Model model) {
		userSession.setUsuario(null);
		model.addAttribute("sesion_iniciada", false);
		return "index";
	}
    
    @GetMapping("/ver_usuarios")
    public String verUsuarios(Model model) {
    	Collection<Usuario> usuarios = usuarioService.findAll();
    	
    	model.addAttribute("usuarios", usuarios);
    	
    	return "ver_usuarios";
    }
    
    @GetMapping("ver_usuarios/{id}")
    public String verUsuario(Model model, @PathVariable long id) {
    	Usuario usuario = usuarioService.findById(id).orElseThrow();
    	
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
    public String nuevoUsuario(Model model, Usuario usuario) {
    	
    	if(usuario.getEmail()==null || usuario.getNombre()==null || usuario.getPass()==null) {
    		model.addAttribute("faltan_campos", true);
    		return "registro";
    	} else if(usuarioService.yaExiste(usuario)) {
    		model.addAttribute("yaExiste", true);
    		return "registro";
    	}
    	
    	usuarioService.save(usuario);
    	
    	userSession.setUsuario(usuario);
    	
    	model.addAttribute("sesion_iniciada", true);
    	
    	return "guardado";
    }
	
	
	
}
