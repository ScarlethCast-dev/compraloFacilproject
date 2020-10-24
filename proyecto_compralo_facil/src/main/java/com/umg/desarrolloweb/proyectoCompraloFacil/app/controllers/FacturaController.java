package com.umg.desarrolloweb.proyectoCompraloFacil.app.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.Audit;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TCliente;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TFactura;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TMetodoPago;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories.ClienteRepository;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories.FacturaRepository;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.util.PageRender;

@Controller
public class FacturaController {

	@Autowired
	private FacturaRepository facturaRepository;
	

	@RequestMapping(value = "/listar-facturas", method = RequestMethod.GET)
	public String listarFacturas(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page, 4);

		Page<TFactura> tfacturas = facturaRepository.findAll(pageRequest);

		PageRender<TFactura> pageRender = new PageRender<TFactura>("/listar-facturas", tfacturas);
		model.addAttribute("titulo", "Listado de Facturas");
		model.addAttribute("factura", tfacturas);
		model.addAttribute("page", pageRender);
		return "facturas";
	}
	
	@RequestMapping(value = "/detalle-factura/{id}", method = RequestMethod.GET)
	public String detalleFactura(@PathVariable(value = "id") Long id, Model model) {

		TFactura tfactura = facturaRepository.findById(id).get();
		if (tfactura == null) {
			return "redirect:/listar-facturas";
		}

		model.addAttribute("titulo", "Detalle Factura: " + tfactura.getIdCliente());
		model.addAttribute("factura", tfactura);
		return "detalle-factura-form";
	}
	
	
	@RequestMapping(value = "/nueva-factura", method = RequestMethod.GET)
	public String nuevaFactura(Model model) {
		TFactura tfactura = new TFactura();
		model.addAttribute("titulo", "Nueva Factura");
		model.addAttribute("factura", tfactura);
		return "form-factura";
	}
	
	@RequestMapping(value = "/nueva-factura", method = RequestMethod.POST)
	public String guardarFactura( TFactura tfactura) {
		Audit audit = null;
		
		if (tfactura.getIdFactura() != null && tfactura.getIdFactura() > 0) {
			TFactura tfactura2 = facturaRepository.findById(tfactura.getIdFactura()).get();
			audit = new Audit("Diego Modificador");
			tfactura.setAudit(audit);
			tfactura.setIdFactura(tfactura2.getIdFactura());
			tfactura.getAudit().setTsCreated(tfactura2.getAudit().getTsCreated());
			tfactura.getAudit().setUsuCreated(tfactura2.getAudit().getUsuCreated());
		} else {
			audit = new Audit("Diego Creador");
			tfactura.setAudit(audit);
		}

		facturaRepository.save(tfactura);
		return "redirect:/listar-facturas";
	}
	
	@RequestMapping(value = "/editar-factura/{id}", method = RequestMethod.GET)
	public String editarFactura(@PathVariable(value = "id") Long id, Model model) {
		TFactura tfactura = null;
		if (id > 0) {
			tfactura = facturaRepository.findById(id).get();
		} else {
			return "redirect:/listar-facturas";
		}
		model.addAttribute("titulo", "Editar Factura");
		model.addAttribute("factura", tfactura);
		return "form-factura";
	}
	
	@RequestMapping(value = "/eliminar-factura/{id}", method = RequestMethod.GET)
	public String eliminarFactura(@PathVariable(value = "id") Long id, Model model) {
		TFactura tfactura = null;
		if (id > 0) {
			tfactura = facturaRepository.findById(id).get();
			facturaRepository.delete(tfactura);
		} else {
			return "redirect:/listar-facturas";
		}

		return "redirect:/listar-facturas";
	}	

	
	
	
}
