package com.umg.desarrolloweb.proyectoCompraloFacil.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")

public class pruebaController{

	@GetMapping("/hola")
	public String prueba(){
		return "<h1> Probando el funcionamiento con el repositorio en GIT 22222 2.0</h1>";
	}
}
