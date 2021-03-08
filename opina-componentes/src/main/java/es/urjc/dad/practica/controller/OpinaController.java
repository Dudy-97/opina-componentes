package es.urjc.dad.practica.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;

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
	
	@Autowired
	private UserSession userSession;
	
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
	
	@GetMapping("/cerrar_sesion")
	public String cerrarSesion(Model model) {
		userSession.setUsuario(null);
		model.addAttribute("sesion_iniciada", false);
		return "index";
	}
	
	@GetMapping("/procesadores")
	public String procesadores(Model model) {
		List<Producto> procesadores = productoService.findByCategoriaNombre("Procesador");
		
		model.addAttribute("procesadores", procesadores);
		
		return "procesadores";
	}
	
	@GetMapping("/graficas")
	public String graficas(Model model) {
		List<Producto> graficas = productoService.findByCategoriaNombre("Tarjeta grafica");
		
		model.addAttribute("graficas", graficas);
		
		return "graficas";
	}
	
	@GetMapping("/placas")
	public String placas(Model model) {
		List<Producto> placas = productoService.findByCategoriaNombre("Placa base");
		
		model.addAttribute("placas", placas);
		
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
        model.addAttribute("valoraciones", procesador.getlValoraciones());
        
		return "producto";
    }

    @GetMapping("/placas/{placaId}") 
    public String mostrarPlacas(Model model, @PathVariable int placaId) {
    	Producto placa = productoService.findById(placaId).orElseThrow();
    	
    	model.addAttribute("producto", placa);
    	model.addAttribute("valoraciones", placa.getlValoraciones());
    	
        return "producto";
    }
    
	 @GetMapping("/{categoriaId}/{productoId}/nueva_valoracion") 
	 public String nuevaValoracionForm(Model model, @PathVariable long categoriaId, @PathVariable long productoId) {
	 
		 if(userSession.getUsuario() == null) {
			 return "login";
		 }
		 
		 return "nueva_valoracion"; 
	}
    

    @PostMapping("/{categoriaId}/{productoId}/nueva_valoracion")
    public String nuevaValoracion(Model model, Valoracion valoracion, @PathVariable long categoriaId, @PathVariable long productoId) {
    	
    	Usuario usuario = userSession.getUsuario();
    	
    	valoracion.setUsuario(usuario);
    	valoracion.setProducto(productoService.findById(productoId).orElseThrow());
    	
    	valoracionService.save(valoracion);
    	
    	return "guardado";
    }
   
    @GetMapping("/valoracion/{id}/eliminar")
    public String eliminarValoracion(Model model, @PathVariable long id) {
    	valoracionService.deleteById(id);
    	
    	return "eliminado";
    }
    
    @GetMapping("/graficas/nueva")
    public String nuevaGrafica(Model model) {
    	
    	return "nueva_grafica";
    }
    
    @PostMapping("/graficas/nueva")
    public String nuevaGrafica(Model model, Producto producto) {
    	if(productoService.yaExiste(producto)) {
    		model.addAttribute("yaExiste", true);
    		return "nueva_grafica";
    	}
    	
    	producto.setCategoria(categoriaService.findByNombre("Tarjeta grafica")); 	
    	productoService.save(producto);
    	
    	return "guardado";
    }
    
    @GetMapping("/procesadores/nuevo")
    public String nuevoProcesador(Model model) {
    	return "nuevo_procesador";
    }
    
    @PostMapping("/procesadores/nuevo")
    public String nuevoProcesador(Model model, Producto producto) {
    	if(productoService.yaExiste(producto)) {
    		model.addAttribute("yaExiste", true);
    		return "nuevo_procesador";
    	}
    	
    	producto.setCategoria(categoriaService.findByNombre("Procesador")); 	
    	productoService.save(producto);
    	
    	return "guardado";
    }
    
    @GetMapping("/placas/nueva")
    public String nuevaPlaca(Model model) {
    	return "nueva_placa";
    }
    
    @PostMapping("/placas/nueva")
    public String nuevaPlaca(Model model, Producto producto) {
    	if(productoService.yaExiste(producto)) {
    		model.addAttribute("yaExiste", true);
    		return "nueva_placa";
    	}
    	
    	producto.setCategoria(categoriaService.findByNombre("Placa base")); 	
    	productoService.save(producto);
    	
    	return "guardado";
    }
    
    @GetMapping("/{id}/eliminar")
    public String eliminarProducto(Model model, @PathVariable long id) {
    	productoService.deleteById(id);
    	
    	return "eliminado";
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
    
	@GetMapping("/login")
	public String login(Model model) {
		
		return "login";
	}
	
	@PostMapping("/login")
	public String login(Model model, Usuario usuario) {
		Usuario auxUsuario = usuarioService.findByNombre(usuario.getNombre());
		
		if(auxUsuario != null && auxUsuario.getPass().equals(usuario.getPass()))
		{
			userSession.setUsuario(auxUsuario);
			model.addAttribute("sesion_iniciada", true);
			return "index";
		}
		
		model.addAttribute("incorrectos", true);
		
		return "login";
	}
}












