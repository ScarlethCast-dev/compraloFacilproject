package com.umg.desarrolloweb.proyectoCompraloFacil.app.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Secured("ROLE_ADMIN")
@Controller
public class menuAdminController {
	@GetMapping({"menuAdmin"})
	public String menuAdministrador() {
		return"menuAdmin/adminMenu";
	}
	/*
	
	@GetMapping({"informacionPersonal"})
	public String InformacionPersonal() {
		return"cuentaClientes/informacionP";
	}
	
	@GetMapping({"paquetesDePago"})
	public String paqueteDePagoPersonal() {
		return"cuentaClientes/pagoP";
	}
	
	@GetMapping({"libretaDeDirecciones"})
	public String direccionesPersonal() {
		return"cuentaClientes/direccionP";
	}

*/
}
