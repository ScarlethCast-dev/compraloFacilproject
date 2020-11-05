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

import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TMetodoEnvio;

import com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories.MetodoEnvioRepository;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.util.PageRender;

@Secured("ROLE_ADMIN")
@Controller
public class MetodoEnvioController {
	
	@Autowired
	private MetodoEnvioRepository metodoEnvioRepository;
	
	@RequestMapping(value = "/listar-metodoenvios", method = RequestMethod.GET)
	public String listarMetodoEnvios(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page, 4);

		Page<TMetodoEnvio> tmetodoenvio = metodoEnvioRepository.findAll(pageRequest);

		PageRender<TMetodoEnvio> pageRender = new PageRender<TMetodoEnvio>("/listar-metodoenvio", tmetodoenvio);
		model.addAttribute("titulo", "Listado de Metodo Envio");
		model.addAttribute("metodoenvios", tmetodoenvio);
		model.addAttribute("page", pageRender);
		return "metodoEnvios";
	}
	
	@RequestMapping(value = "/detalle-metodoenvio/{id}", method = RequestMethod.GET)
	public String detalleMetodoEnvio(@PathVariable(value = "id") Long id, Model model) {

		TMetodoEnvio tmetodoenvio = metodoEnvioRepository.findById(id).get();
		if (tmetodoenvio == null) {
			return "redirect:/listar-metodoenvios";
		}

		model.addAttribute("titulo", "Detalle Metodo Envio: " + tmetodoenvio.getDescripcion());
		model.addAttribute("metodoenvios", tmetodoenvio);
		return "detalle-metodoEnvio-form";
	}
	
	@RequestMapping(value = "/nuevo-metodoenvio", method = RequestMethod.GET)
	public String nuevoMetodoEnvio(Model model) {
		TMetodoEnvio tmetodoenvio = new TMetodoEnvio();
		model.addAttribute("titulo", "Nuevo Metodo Envio");
		model.addAttribute("metodoenvios", tmetodoenvio);
		return "form-metodoEnvio";
	}
	
	@RequestMapping(value = "/nuevo-metodoenvio", method = RequestMethod.POST)
	public String guardarMetodoEnvio( TMetodoEnvio tmetodoenvio) {
		Audit audit = null;
		
	
		if (tmetodoenvio.getId() != null && tmetodoenvio.getId() > 0) {
			TMetodoEnvio metodoenvio2 = metodoEnvioRepository.findById(tmetodoenvio.getId()).get();
			audit = new Audit("Mynor Modificador");
			tmetodoenvio.setAudit(audit);
			tmetodoenvio.setId(metodoenvio2.getId());
			tmetodoenvio.getAudit().setTsCreated(metodoenvio2.getAudit().getTsCreated());
			tmetodoenvio.getAudit().setUsuCreated(metodoenvio2.getAudit().getUsuCreated());
		} else {
			audit = new Audit("Mynor Creador");
			tmetodoenvio.setAudit(audit);
		}

		metodoEnvioRepository.save(tmetodoenvio);
		return "redirect:/listar-metodoenvios";
	}
	
	@RequestMapping(value = "/editar-metodoenvio/{id}", method = RequestMethod.GET)
	public String editarMetodoEnvio(@PathVariable(value = "id") Long id, Model model) {
		TMetodoEnvio tmetodoenvio = null;
		if (id > 0) {
			tmetodoenvio = metodoEnvioRepository.findById(id).get();
		} else {
			return "redirect:/listar-metodoenvios";
		}
		model.addAttribute("titulo", "Editar Metodo Envio");
		model.addAttribute("metodoenvios", tmetodoenvio);
		return "form-metodoEnvio";
		
	}
	
	@RequestMapping(value = "/eliminar-metodoenvio/{id}", method = RequestMethod.GET)
	public String eliminarMetodoEnvio(@PathVariable(value = "id") Long id, Model model) {
		TMetodoEnvio tmetodoenvio = null;
		if (id > 0) {
			tmetodoenvio = metodoEnvioRepository.findById(id).get();
			metodoEnvioRepository.delete(tmetodoenvio);
		} else {
			return "redirect:/listar-metodoenvios";
		}

		return "redirect:/listar-metodoenvios";
	}	
	
	
	
	

}
