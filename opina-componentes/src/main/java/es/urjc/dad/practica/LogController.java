package es.urjc.dad.practica;

import org.springframework.stereotype.Controller;

import ch.qos.logback.classic.Logger;

@Controller
public class LogController {

	private Logger log = LoggerFactory.getLogger(LogController.class);
}
