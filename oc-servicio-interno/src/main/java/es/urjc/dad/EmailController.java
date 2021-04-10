package es.urjc.dad;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

	@PostMapping("/sendEmail")
	public ResponseEntity<Void> getEmail(@RequestBody ProductEmailMessage message) {
		System.out.print(message);
		return new ResponseEntity<>( HttpStatus.OK);
	}
}
