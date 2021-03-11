package es.urjc.dad.practica.controller;

import java.util.List;

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
public class ProductoController {

	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private ProductoService productoService;
	
	
	
	//Metodos de procesadores
	
	@GetMapping("/procesadores")
	public String procesadores(Model model) {
		List<Producto> procesadores = productoService.findByCategoriaNombre("Procesador");
		
		model.addAttribute("procesadores", procesadores);
		
		return "procesadores";
	}
	
	@GetMapping("/procesadores/{procesadorId}")
    public String mostrarProcesador(Model model, @PathVariable int procesadorId) {
        Producto procesador = productoService.findById(procesadorId).orElseThrow();
        
        model.addAttribute("producto", procesador);
        model.addAttribute("valoraciones", procesador.getlValoraciones());
        
		return "producto";
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
	
	
	
	
	
	//Metodos graficas
	@GetMapping("/graficas")
	public String graficas(Model model) {
		List<Producto> graficas = productoService.findByCategoriaNombre("Tarjeta grafica");
		
		model.addAttribute("graficas", graficas);
		
		return "graficas";
	}
	
	@GetMapping("/graficas/{graficaId}")
	public String mostrarProducto(Model model, @PathVariable int graficaId) {
		Producto grafica = productoService.findById(graficaId).orElseThrow();
		
		model.addAttribute("producto", grafica);
		model.addAttribute("valoraciones", grafica.getlValoraciones());
		
		return "producto";
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
	
	
	
	
	//Metodos placas
	@GetMapping("/placas")
	public String placas(Model model) {
		List<Producto> placas = productoService.findByCategoriaNombre("Placa base");
		
		model.addAttribute("placas", placas);
		
		return "placas";
	}
	
	@GetMapping("/placas/{placaId}") 
    public String mostrarPlacas(Model model, @PathVariable int placaId) {
    	Producto placa = productoService.findById(placaId).orElseThrow();
    	
    	model.addAttribute("producto", placa);
    	model.addAttribute("valoraciones", placa.getlValoraciones());
    	
        return "producto";
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
	

	
	//Metodo eliminar producto
    @GetMapping("/{id}/eliminar")
    public String eliminarProducto(Model model, @PathVariable long id) {
    	productoService.deleteById(id);
    	
    	return "eliminado";
    }
}
