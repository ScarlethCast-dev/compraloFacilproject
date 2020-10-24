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
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TCuenta;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TDetalleCuenta;

import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TMetodoPago;

import com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories.CuentaRepository;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories.DetalleCuentaRepository;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories.MetodoPagoRepository;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.util.PageRender;

@Controller
public class DetalleCuentaController {
	
	@Autowired
	private DetalleCuentaRepository detalleCuentaRepository;
	
	@Autowired
	private CuentaRepository cuentaRepository;
	
	@Autowired
	private MetodoPagoRepository metodoPagoRepository;
	
	
	
	@RequestMapping(value = "/listar-detallecuentas", method = RequestMethod.GET)
	public String listarDetalleCuentas(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page, 5);

		Page<TDetalleCuenta> tdetallecuenta = detalleCuentaRepository.findAll(pageRequest);

		PageRender<TDetalleCuenta> pageRender = new PageRender<TDetalleCuenta>("/listar-direcciones", tdetallecuenta);
		model.addAttribute("titulo", "Listado de detalle cuentas");
		model.addAttribute("detallecuentas", tdetallecuenta);
		model.addAttribute("page", pageRender);
		return "detalleCuenta/detalleCuentas";
	}
	
	@RequestMapping(value = "/detalle-detallecuenta/{id}", method = RequestMethod.GET)
	public String detalleDetalleCuenta(@PathVariable(value = "id") Long id, Model model) {

		TDetalleCuenta tdetallecuenta = detalleCuentaRepository.findById(id).get();
		if (tdetallecuenta == null) {
			return "redirect:/listar-detallecuentas";
		}

		model.addAttribute("titulo", "Detalle de las cuentas: " + tdetallecuenta.getId());
		model.addAttribute("detallecuentas", tdetallecuenta);
		return "detalleCuenta/detalle-detalleCuenta-form";
	}
	
	@RequestMapping(value = "/nuevo-detallecuenta", method = RequestMethod.GET)
	public String nuevoDetalleCuenta(Model model) {
		TDetalleCuenta tdetallecuenta = new TDetalleCuenta();
		
		model.addAttribute("titulo", "Nuevo Detalle Cuenta");
		model.addAttribute("detallecuentas", tdetallecuenta);
		return "detallecuenta/form-detalleCuenta";
	}
	
	@RequestMapping(value = "/nuevo-detallecuenta", method = RequestMethod.POST)
	public String guardarDetalleCuenta(TDetalleCuenta tdetallecuenta) {
		Audit audit = null;
		
		if (tdetallecuenta.getId() != null && tdetallecuenta.getId() > 0) {
			TDetalleCuenta tdetallecuenta2 = detalleCuentaRepository.findById(tdetallecuenta.getId()).get();
			audit = new Audit("Mynor Modificador");
			tdetallecuenta.setAudit(audit);
			tdetallecuenta.setId(tdetallecuenta.getId());	
			tdetallecuenta.getAudit().setTsCreated(tdetallecuenta2.getAudit().getTsCreated());
			tdetallecuenta.getAudit().setUsuCreated(tdetallecuenta2.getAudit().getUsuCreated());
		} else {
			audit = new Audit("Mynor Creador");
			tdetallecuenta.setAudit(audit);
		}
		
		TCuenta tcuenta = cuentaRepository.findById(tdetallecuenta.gettCuenta().getId()).get();
		TMetodoPago tmetodopago = metodoPagoRepository.findById(tdetallecuenta.gettMetodoPago().getId()).get();
		
		tdetallecuenta.settCuenta(tcuenta);
		tdetallecuenta.settMetodoPago(tmetodopago);

			
		detalleCuentaRepository.save(tdetallecuenta);
		return "redirect:listar-detallecuentas";
		
	}
	
	@RequestMapping(value = "/editar-detallecuenta/{id}", method = RequestMethod.GET)
	public String editarDetalleCuenta(@PathVariable(value = "id") Long id, Model model) {
		TDetalleCuenta tdetallecuenta = null;
		if (id > 0) {
			tdetallecuenta = detalleCuentaRepository.findById(id).get();
		} else {
			return "redirect:/listar-detallecuentas";
		}
		model.addAttribute("titulo", "Editar Cuenta");
		model.addAttribute("detallecuentas", tdetallecuenta);
		return "detalleCuenta/form-detalleCuenta";
	}

	@RequestMapping(value = "/eliminar-detallecuenta/{id}", method = RequestMethod.GET)
	public String eliminarDetalleCuenta(@PathVariable(value = "id") Long id, Model model) {
		TDetalleCuenta tdetallecuenta = null;
		if (id > 0) {
			tdetallecuenta = detalleCuentaRepository.findById(id).get();
			detalleCuentaRepository.delete(tdetallecuenta);
		} else {
			return "redirect:/listar-detallecuentas";
		}

		return "redirect:/listar-detallecuentas";
	}
	
}
