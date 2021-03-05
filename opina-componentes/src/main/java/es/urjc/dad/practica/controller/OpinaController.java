package es.urjc.dad.practica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.dad.practica.model.*;
import es.urjc.dad.practica.service.*;

@Controller
public class OpinaController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private ValoracionService valoracionService;
	
	@GetMapping("/login")
	public String login(Model model) {
		
		return "login";
	}
	
	@GetMapping("/procesadores")
	public String procesadores(Model model) {
		List<Producto> procesadores = productoService.findByCategoriaNombre("Procesadores");
		
		model.addAttribute("procesadores", procesadores);
		
		return "procesadores";
	}
	
	@GetMapping("/graficas")
	public String graficas(Model model) {
		List<Producto> graficas = productoService.findByCategoriaNombre("Tarjetas graficas");
		
		model.addAttribute("graficas", graficas);
		
		return "graficas";
	}
	
	@GetMapping("/placas")
	public String placas(Model model) {
		
		return "placas";
	}
	
	@GetMapping("/graficas/{graficaId}")
	public String mostrarProducto(Model model, @PathVariable int graficaId) {
		Producto grafica = productoService.findById(graficaId).orElseThrow();
		
		model.addAttribute("producto", grafica);
		model.addAttribute("valoraciones", grafica.getlValoraciones());
		
		return "producto";
	}
	
	@GetMapping("/procesadores/{procesadorId}")
    public String mostrarProcesador(Model model, @PathVariable int procesadorId) {
        Producto procesador = productoService.findById(procesadorId).orElseThrow();
        
        model.addAttribute("producto", procesador);
        
		return "producto";
    }

    @GetMapping("/placas/{placaId}") 
    public String mostrarPlacas(Model model, @PathVariable int placaId) {

        return "producto";
    }
    
    @GetMapping("/{categoriaId}/{productoId}/nueva_valoracion")
    public String nuevaValoracionForm(Model model) {
    	return "nueva_valoracion";
    }
    
    @PostMapping("/{categoriaId}/{productoId}/nueva_valoracion")
    public String nuevaValoracion(Model model, Valoracion valoracion, @PathVariable long categoriaId, @PathVariable long productoId) {
    	valoracionService.save(valoracion);
    	
    	return "nueva_valoracion";
    }
    
    @GetMapping("/usuario")
    public String mostrar_usuario(Model model, @RequestParam String user) {

        Usuario usuario = usuarioService.buscarPorNombre(user);
        model.addAttribute(usuario);

        return "usuario";
    }
    
//  @PostMapping("/usuario") 
//  public String save(Model model, @RequestParam String user, @RequestParam String pass) {
//
//
//      model.addAttribute("nombre", user);
//      model.addAttribute("pass", pass);
//
//      return "usuario";
//  }
    
    @GetMapping("/registro")//login save
    public String nuevoUsuario(Model model, Usuario user) {

        usuarioService.save(user);

        return "registro";
    }
}












