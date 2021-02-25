package es.urjc.dad.practica.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogController {

    private Logger log = LoggerFactory.getLogger(LogController.class);

    @GetMapping("/log_page")
    public String page(Model model) {
    	
        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("A INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");

        return "log-page";
    }
}