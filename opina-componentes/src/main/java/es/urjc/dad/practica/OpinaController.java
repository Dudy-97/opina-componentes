package es.urjc.dad.practica;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class OpinaController {

	@GetMapping("/hola")
	public String hola (Model model) {
		
		return "hola.html";
	}	
	
	@GetMapping("/home")
	public String home(Model model) {
		return "home-page";
	}
	
	@GetMapping("/componente")
	public String componente (Model model) {
		
		return "componente-page";
	}
	
	@GetMapping("/graficas")
	public String graficas (Model model) {
		
		return "graficas-page";
		
	}
	
	@GetMapping("/login")
	public String login (Model model) {
		
		return "login-page";
		
	}
	
	@GetMapping("/user")
	public String user (Model model) {
		
		return "user-page";
	}
	
}
