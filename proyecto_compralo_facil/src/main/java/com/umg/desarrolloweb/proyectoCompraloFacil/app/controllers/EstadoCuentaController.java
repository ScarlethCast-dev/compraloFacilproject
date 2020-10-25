package com.umg.desarrolloweb.proyectoCompraloFacil.app.controllers;

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

import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.Audit;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TEstadoCuenta;

import com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories.EstadoCuentaRepository;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.util.PageRender;

@Controller
public class EstadoCuentaController {
	
	@Autowired
	private EstadoCuentaRepository estadoCuentaRepository;
	
	@RequestMapping(value = "/listar-estadocuentas", method = RequestMethod.GET)
	public String listarEstadosCuentas(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page, 4);

		Page<TEstadoCuenta> testadocuenta = estadoCuentaRepository.findAll(pageRequest);

		PageRender<TEstadoCuenta> pageRender = new PageRender<TEstadoCuenta>("/listar-estadocuentas", testadocuenta);
		model.addAttribute("titulo", "Listado de estado cuentas");
		model.addAttribute("estadocuentas", testadocuenta);
		model.addAttribute("page", pageRender);
		return "estadoCuenta/estadoCuentas";
	}
	
	@RequestMapping(value = "/detalle-estadocuenta/{id}", method = RequestMethod.GET)
	public String detalleEstadoCuenta(@PathVariable(value = "id") Long id, Model model) {

		TEstadoCuenta testadocuenta = estadoCuentaRepository.findById(id).get();
		if (testadocuenta == null) {
			return "redirect:/listar-estadocuentas";
		}

		model.addAttribute("titulo", "Detalle Estado Cuenta: " + testadocuenta.getDescripcion());
		model.addAttribute("estadocuentas", testadocuenta);
		return "estadoCuenta/detalle-estadoCuenta-form";
	}
	
	@RequestMapping(value = "/nuevo-estadocuenta", method = RequestMethod.GET)
	public String nuevoEstadoCuenta(Model model) {
		TEstadoCuenta testadocuenta = new TEstadoCuenta();
		model.addAttribute("titulo", "Nuevo Estado Cuenta");
		model.addAttribute("estadocuentas", testadocuenta);
		return "estadoCuenta/form-estadoCuenta";
	}
	
	@RequestMapping(value = "/nuevo-estadocuenta", method = RequestMethod.POST)
	public String guardarEstadoCuenta( TEstadoCuenta testadocuenta) {
		Audit audit = null;
		
	
		if (testadocuenta.getId() != null && testadocuenta.getId() > 0) {
			TEstadoCuenta testadocuenta2 = estadoCuentaRepository.findById(testadocuenta.getId()).get();
			audit = new Audit("Mynor Modificador");
			testadocuenta.setAudit(audit);
			testadocuenta.setId(testadocuenta2.getId());
			testadocuenta.getAudit().setTsCreated(testadocuenta2.getAudit().getTsCreated());
			testadocuenta.getAudit().setUsuCreated(testadocuenta2.getAudit().getUsuCreated());
		} else {
			audit = new Audit("Mynor Creador");
			testadocuenta.setAudit(audit);
		}

		estadoCuentaRepository.save(testadocuenta);
		return "redirect:/listar-estadocuentas";
	}
	
	@RequestMapping(value = "/editar-estadocuenta/{id}", method = RequestMethod.GET)
	public String editarEstadoCuenta(@PathVariable(value = "id") Long id, Model model) {
		TEstadoCuenta testadocuenta = null;
		if (id > 0) {
			testadocuenta = estadoCuentaRepository.findById(id).get();
		} else {
			return "redirect:/listar-estadocuentas";
		}
		model.addAttribute("titulo", "Editar Estado Cuenta");
		model.addAttribute("estadocuentas", testadocuenta);
		return "estadoCuenta/form-estadoCuenta";
	}
	
	
	@RequestMapping(value = "/eliminar-estadocuenta/{id}", method = RequestMethod.GET)
	public String eliminarEstadoCuenta(@PathVariable(value = "id") Long id, Model model) {
		TEstadoCuenta testadocuenta = null;
		if (id > 0) {
			testadocuenta = estadoCuentaRepository.findById(id).get();
			estadoCuentaRepository.delete(testadocuenta);
		} else {
			return "redirect:/listar-estadocuentas";
		}

		return "redirect:/listar-estadocuentas";
	}	
	
	

}
