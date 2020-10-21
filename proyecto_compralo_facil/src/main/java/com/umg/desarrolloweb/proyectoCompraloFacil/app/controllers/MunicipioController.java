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

import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TMunicipio;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories.MunicipioRepository;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.util.PageRender;

@Controller
public class MunicipioController {
	
	@Autowired
	private MunicipioRepository municipioRepository;
	
	@RequestMapping(value = "/listar-municipios", method = RequestMethod.GET)
	public String listarMunicipios(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page, 4);

		Page<TMunicipio> tmunicipios = municipioRepository.findAll(pageRequest);

		PageRender<TMunicipio> pageRender = new PageRender<TMunicipio>("/listar-municipios", tmunicipios);
		model.addAttribute("titulo", "Listado de municipios");
		model.addAttribute("municipios", tmunicipios);
		model.addAttribute("page", pageRender);
		return "municipios";
	}
	
	@RequestMapping(value = "/detalle-municipio/{id}", method = RequestMethod.GET)
	public String detalleMunicipio(@PathVariable(value = "id") Long id, Model model) {

		TMunicipio tmunicipio = municipioRepository.findById(id).get();
		if (tmunicipio == null) {
			return "redirect:/listar-municipios";
		}

		model.addAttribute("titulo", "Detalle Municipio: " + tmunicipio.getNombreMunicipio());
		model.addAttribute("municipio", tmunicipio);
		return "detalle-municipio-form";
	}
	
	
	@RequestMapping(value = "/nuevo-municipio", method = RequestMethod.GET)
	public String nuevoMunicipio(Model model) {
		TMunicipio tmunicipio = new TMunicipio();
		model.addAttribute("titulo", "Nuevo Municipio");
		model.addAttribute("municipio", tmunicipio);
		return "form-municipio";
	}
	
	@RequestMapping(value = "/nuevo-municipio", method = RequestMethod.POST)
	public String guardarMunicipio( TMunicipio tmunicipio) {
		Audit audit = null;
		
	
		if (tmunicipio.getId() != null && tmunicipio.getId() > 0) {
			TMunicipio municipio2 = municipioRepository.findById(tmunicipio.getId()).get();
			audit = new Audit("Mynor Modificador");
			tmunicipio.setAudit(audit);
			tmunicipio.setId(municipio2.getId());
			tmunicipio.getAudit().setTsCreated(municipio2.getAudit().getTsCreated());
			tmunicipio.getAudit().setUsuCreated(municipio2.getAudit().getUsuCreated());
		} else {
			audit = new Audit("Mynor Creador");
			tmunicipio.setAudit(audit);
		}

		municipioRepository.save(tmunicipio);
		return "redirect:/listar-municipios";
	}
	
	@RequestMapping(value = "/editar-municipio/{id}", method = RequestMethod.GET)
	public String editarMunicipio(@PathVariable(value = "id") Long id, Model model) {
		TMunicipio tmunicipio = null;
		if (id > 0) {
			tmunicipio = municipioRepository.findById(id).get();
		} else {
			return "redirect:/listar-municipios";
		}
		model.addAttribute("titulo", "Editar Municipio");
		model.addAttribute("municipio", tmunicipio);
		return "form-municipio";
	}
	
	@RequestMapping(value = "/eliminar-municipio/{id}", method = RequestMethod.GET)
	public String eliminarMunicipio(@PathVariable(value = "id") Long id, Model model) {
		TMunicipio tmunicipio = null;
		if (id > 0) {
			tmunicipio = municipioRepository.findById(id).get();
			municipioRepository.delete(tmunicipio);
		} else {
			return "redirect:/listar-municipios";
		}

		return "redirect:/listar-municipios";
	}	
	


}
