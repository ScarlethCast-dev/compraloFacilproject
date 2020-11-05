package com.umg.desarrolloweb.proyectoCompraloFacil.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = {"/inicio","/"}, method = RequestMethod.GET)
	public String mostrarHome() {
		return "home";
	}
	
	@RequestMapping(value = "/sobreNosotros", method = RequestMethod.GET)
	public String sobreNostros() {
		return "home/sobreNosotros";
	}
	
	@RequestMapping(value = "/contacto", method = RequestMethod.GET)
	public String contactanos() {
		return "home/contacto";
	}
	
	

}
