package com.umg.desarrolloweb.proyectoCompraloFacil.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.umg.desarrolloweb.proyectoCompraloFacil.app.dto.AmazonProductLinkDTO;

@Controller
public class HomeController {
	
	@RequestMapping(value = {"/inicio","/"}, method = RequestMethod.GET)
	public String mostrarHome(Model model) {
		AmazonProductLinkDTO producto = new AmazonProductLinkDTO();
		model.addAttribute("producto", producto);
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
