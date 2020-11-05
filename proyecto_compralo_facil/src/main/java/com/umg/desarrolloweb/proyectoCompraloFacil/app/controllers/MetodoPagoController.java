package com.umg.desarrolloweb.proyectoCompraloFacil.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.Audit;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TMetodoPago;

import com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories.MetodoPagoRepository;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.util.PageRender;

@Secured("ROLE_ADMIN")
@Controller
public class MetodoPagoController {
	
	@Autowired
	private MetodoPagoRepository metodoPagoRempository;
	
	
	@RequestMapping(value = "/listar-metodopagos", method = RequestMethod.GET)
	public String listarMetodoPagos(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page, 4);

		Page<TMetodoPago> tmetodopago = metodoPagoRempository.findAll(pageRequest);

		PageRender<TMetodoPago> pageRender = new PageRender<TMetodoPago>("/listar-metodopagos", tmetodopago);
		model.addAttribute("titulo", "Listado de metodo de pago");
		model.addAttribute("metodopagos", tmetodopago);
		model.addAttribute("page", pageRender);
		return "metodoPagos";
	}
	
	
	@RequestMapping(value = "/detalle-metodopago/{id}", method = RequestMethod.GET)
	public String detalleMeotodoPago(@PathVariable(value = "id") Long id, Model model) {

		TMetodoPago tmetodopago = metodoPagoRempository.findById(id).get();
		if (tmetodopago == null) {
			return "redirect:/listar-metodopagos";
		}

		model.addAttribute("titulo", "Detalle Metodo de Pago: " + tmetodopago.getDescripcion());
		model.addAttribute("metodopagos", tmetodopago);
		return "detalle-metodoPago-form";
	}
	
	@RequestMapping(value = "/nuevo-metodopago", method = RequestMethod.GET)
	public String nuevoMetodoPago(Model model) {
		TMetodoPago tmetodopago = new TMetodoPago();
		model.addAttribute("titulo", "Nuevo Metodo de Pago");
		model.addAttribute("metodopagos", tmetodopago);
		return "form-metodoPago";
	}
	
	
	@RequestMapping(value = "/nuevo-metodopago", method = RequestMethod.POST)
	public String guardarMetodoPago( TMetodoPago tmetodopago) {
		Audit audit = null;
		
	
		if (tmetodopago.getId() != null && tmetodopago.getId() > 0) {
			TMetodoPago metodopago2 = metodoPagoRempository.findById(tmetodopago.getId()).get();
			audit = new Audit("Mynor Modificador");
			tmetodopago.setAudit(audit);
			tmetodopago.setId(metodopago2.getId());
			tmetodopago.getAudit().setTsCreated(metodopago2.getAudit().getTsCreated());
			tmetodopago.getAudit().setUsuCreated(metodopago2.getAudit().getUsuCreated());
		} else {
			audit = new Audit("Mynor Creador");
			tmetodopago.setAudit(audit);
		}

		metodoPagoRempository.save(tmetodopago);
		return "redirect:/listar-metodopagos";
	}
	
	@RequestMapping(value = "/editar-metodopago/{id}", method = RequestMethod.GET)
	public String editarMetodoPago(@PathVariable(value = "id") Long id, Model model) {
		TMetodoPago tmetodopago = null;
		if (id > 0) {
			tmetodopago = metodoPagoRempository.findById(id).get();
		} else {
			return "redirect:/listar-metodopagos";
		}
		model.addAttribute("titulo", "Editar MetodoPago");
		model.addAttribute("metodopagos", tmetodopago);
		return "form-metodoPago";
		
	}
	
	@RequestMapping(value = "/eliminar-metodopago/{id}", method = RequestMethod.GET)
	public String eliminarMetodoPago(@PathVariable(value = "id") Long id, Model model) {
		TMetodoPago tmetodopago = null;
		if (id > 0) {
			tmetodopago = metodoPagoRempository.findById(id).get();
			metodoPagoRempository.delete(tmetodopago);
		} else {
			return "redirect:/listar-metodopagos";
		}

		return "redirect:/listar-metodopagos";
	}	
	
	

}
