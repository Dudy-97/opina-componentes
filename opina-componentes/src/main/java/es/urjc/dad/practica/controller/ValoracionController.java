package es.urjc.dad.practica.controller;


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
public class ValoracionController {

	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private ValoracionService valoracionService;
	
	@Autowired
	private UserSession userSession;
	
	
	
	
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
	
	
	
}
