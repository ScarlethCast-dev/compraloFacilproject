package com.umg.desarrolloweb.proyectoCompraloFacil.app.controllers;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

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
