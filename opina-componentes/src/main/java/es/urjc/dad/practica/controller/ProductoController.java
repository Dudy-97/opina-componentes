package es.urjc.dad.practica.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import es.urjc.dad.practica.model.*;
import es.urjc.dad.practica.service.*;


@Controller
public class ProductoController {

	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	private RestTemplate restTemplate = new RestTemplate();
	private final String EMAIL_URL = "http://si:9000/sendEmail";
	
	//Metodos de procesadores
	
	@GetMapping("/procesadores")
	public String procesadores(Model model, HttpServletRequest request) {
		List<Producto> procesadores = productoService.findByCategoriaNombre("Procesador");
		
		model.addAttribute("procesadores", procesadores);
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		
		return "procesadores";
	}
	
	@GetMapping("/procesadores/{procesadorId}")
    public String mostrarProcesador(Model model, @PathVariable int procesadorId, HttpServletRequest request) {
        Producto procesador = productoService.findById(procesadorId).orElseThrow();
        
        model.addAttribute("producto", procesador);
        model.addAttribute("admin", request.isUserInRole("ADMIN"));
        model.addAttribute("valoraciones", procesador.getlValoraciones());
        
		return "producto";
    }
	
	@GetMapping("/nuevoprocesador")
    public String nuevoProcesador(Model model, HttpServletRequest request) {
    	return "nuevo_procesador";
    }
    
    @PostMapping("/nuevoprocesador")
    public String nuevoProcesador(Model model, Producto producto, HttpServletRequest request) {
    	
    	if(productoService.yaExiste(producto)) {
    		model.addAttribute("yaExiste", true);
    		return "nuevo_procesador";
    	}
    	
    	Optional<Categoria> categoria = categoriaService.findByNombre("Procesador");
    	if (categoria.isPresent()) {
    		producto.setCategoria(categoria.get()); 	
    		productoService.save(producto);
    		sendEmail(producto.getNombre());
    		return "guardado";
    	} else {
    		return "procesadores";
    	}
    }
	
	
	//Metodos graficas
	@GetMapping("/graficas")
	public String graficas(Model model, HttpServletRequest request) {
		
		List<Producto> graficas = productoService.findByCategoriaNombre("Tarjeta grafica");
		
		model.addAttribute("graficas", graficas);
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		
		return "graficas";
	}
	
	@GetMapping("/graficas/{graficaId}")
	public String mostrarProducto(Model model, @PathVariable int graficaId, HttpServletRequest request) {
		Producto grafica = productoService.findById(graficaId).orElseThrow();
		
		model.addAttribute("producto", grafica);
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("valoraciones", grafica.getlValoraciones());
		
		return "producto";
	}
	
    @GetMapping("/nuevagrafica")
    public String nuevaGrafica(Model model, HttpServletRequest request) {
    	
    	return "nueva_grafica";
    }
    
    @PostMapping("/nuevagrafica")
    public String nuevaGrafica(Model model, Producto producto, HttpServletRequest request) {
    	if(productoService.yaExiste(producto)) {
    		model.addAttribute("yaExiste", true);
    		return "nueva_grafica";
    	}
    	
    	Optional<Categoria> categoria =  categoriaService.findByNombre("Tarjeta grafica");
    	if(categoria.isPresent()) {
    		producto.setCategoria(categoria.get()); 	
    		productoService.save(producto);
    		sendEmail(producto.getNombre());
    		return "guardado";
    	} else {
    		return "graficas";
    	}
    	
    }
	
	
	
	
	//Metodos placas
	@GetMapping("/placas")
	public String placas(Model model, HttpServletRequest request) {
		List<Producto> placas = productoService.findByCategoriaNombre("Placa base");
		
		model.addAttribute("placas", placas);
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		
		return "placas";
	}
	
	@GetMapping("/placas/{placaId}") 
    public String mostrarPlacas(Model model, @PathVariable int placaId, HttpServletRequest request) {
    	Producto placa = productoService.findById(placaId).orElseThrow();
    	
    	model.addAttribute("producto", placa);
    	model.addAttribute("admin", request.isUserInRole("ADMIN"));
    	model.addAttribute("valoraciones", placa.getlValoraciones());
    	
        return "producto";
    }
	
	@GetMapping("/nuevaplaca")
	public String nuevaPlaca(Model model, HttpServletRequest request) {
	    return "nueva_placa";
	}
	    
	@PostMapping("/nuevaplaca")
	public String nuevaPlaca(Model model, Producto producto, HttpServletRequest request) {
		if(productoService.yaExiste(producto)) {
	    	model.addAttribute("yaExiste", true);
	    	return "nueva_placa";
	    }
	    	
	   	Optional<Categoria> categoria = categoriaService.findByNombre("Placa base");
	   	if(categoria.isPresent()) {
	   		producto.setCategoria(categoria.get()); 	
	   		productoService.save(producto);
	   		sendEmail(producto.getNombre());
	   		return "guardado";
	   	} else {
	   		return "placas";
	   	}
	 }
	
	//Metodo eliminar producto
    @GetMapping("/{id}/eliminar")
    public String eliminarProducto(Model model, @PathVariable long id, HttpServletRequest request) {
    	productoService.deleteById(id);
    	
    	return "eliminado";
    }
    
    private void sendEmail(String nombreProducto) {
    	Collection<Usuario> usuarios = usuarioService.findAll();
    	List<String> correos = new ArrayList<>();
    	for (Usuario  u : usuarios) {
    		correos.add(u.getEmail());
    		/*ProductEmailMessage mensaje = new ProductEmailMessage(u.getEmail(), nombreProducto);
    		HttpEntity<ProductEmailMessage> mensajeBody = new HttpEntity<>(mensaje);
    		restTemplate.exchange(EMAIL_URL, HttpMethod.POST, mensajeBody, Void.class);*/
    	}
    	
    	ProductEmailMessage mensaje = new ProductEmailMessage(correos, nombreProducto);
    	HttpEntity<ProductEmailMessage> mensajeBody = new HttpEntity<>(mensaje);
    	restTemplate.exchange(EMAIL_URL, HttpMethod.POST, mensajeBody, Void.class);
    }
}
