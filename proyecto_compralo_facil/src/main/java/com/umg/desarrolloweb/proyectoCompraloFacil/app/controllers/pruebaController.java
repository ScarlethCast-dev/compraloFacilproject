package com.umg.desarrolloweb.proyectoCompraloFacil.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/test")
@Controller
public class pruebaController{

	@GetMapping("/hola")
	public String prueba(){
		return "<h1> Probando el funcionamiento con el repositorio en GIT 22222 2.0</h1>";
	}
	
	@GetMapping("/hola1")
	public String pruebaPorDiego(){
		return "index";
	}
	
	@GetMapping("/hola2")
	public String pruebaPorMynor(){
		return "index";
	}
}
