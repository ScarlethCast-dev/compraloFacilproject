package com.umg.desarrolloweb.proyectoCompraloFacil.app.controllers;

import java.util.Optional;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TCliente;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TFactura;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories.ClienteRepository;


@Controller
public class FacturaController {


	@Autowired
	private ClienteRepository clienteRepository;
	
	@RequestMapping(value = "/nueva-factura/{id}", method = RequestMethod.GET)
	public String nuevaFactura(@PathVariable(value = "id") Long id, Model model) {	
		
		TCliente tcliente = clienteRepository.findById(id).get();
		
		if(tcliente == null){
			return "redirect:/listar-clientes";
		}
		TFactura tfactura = new TFactura();
			tfactura.settCliente(tcliente);
			model.addAttribute("titulo", "Nueva Factura");
			model.addAttribute("factura", tfactura);
			return "facturas/form-factura";
			
	}
	

	
}
