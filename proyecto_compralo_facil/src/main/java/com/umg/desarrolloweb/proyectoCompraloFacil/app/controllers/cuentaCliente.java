package com.umg.desarrolloweb.proyectoCompraloFacil.app.controllers;


import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Secured("ROLE_ADMIN")
@Controller
public class cuentaCliente {
	
	@GetMapping({"cuentaCliente"})
	public String CuentaCliente() {
		return"cuentaClientes/cuentaCliente";
	}
	
	@GetMapping({"informacionPersonal"})
	public String InformacionPersonal() {
		return"cuentaClientes/informacionP";
	}


}
