package es.urjc.dad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/sendEmail")
	public ResponseEntity<Void> getEmail(@RequestBody ProductEmailMessage message) {
		String to = message.getEmail();
		String from = "OpinaComponentes";
		String subject = "Se ha añadido un nuevo producto";
		String text = "Hola!\n"
				+ "Hemos añadido un nuevo producto a nuestra página: " + message.getNombreProducto() + "\n"
				+ "Entra en la web para saber la opinión nuestros usuarios y dinos la tuya.";
		emailService.sendSimpleMessage(to, from, subject, text);
		return new ResponseEntity<>( HttpStatus.OK);
	}
}
