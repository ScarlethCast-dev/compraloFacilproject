package com.umg.desarrolloweb.proyectoCompraloFacil.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class prueba {
	
	@PostMapping("/prueba")
	public String ingresar(Model model,
			 @RequestParam(name = "asin") String codigo,
			 @RequestParam(name = "productTitle") String producto,
			 @RequestParam(name = "precioQuetzales") String precio,
			 @RequestParam(name = "mainImage.imageUrl") String imagen,
			 @RequestParam(name = "link") String link) {
		
		
			model.addAttribute("codigo",codigo );
			model.addAttribute("producto",producto );
			model.addAttribute("precio",precio );
			model.addAttribute("imagen",imagen );
			model.addAttribute("link",link );
		
			return "prueba";
		
	}

}
