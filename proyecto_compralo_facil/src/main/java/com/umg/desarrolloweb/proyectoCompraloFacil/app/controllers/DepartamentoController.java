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
import org.springframework.web.multipart.MultipartFile;

import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.Audit;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TDepartamento;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories.DepartamentoRepository;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.util.PageRender;

@Controller
public class DepartamentoController {
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@RequestMapping(value = "/listar-departamentos", method = RequestMethod.GET)
	public String listarDepartamentos(@RequestParam(name = "pages", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page, 4);

		Page<TDepartamento> tDepartamentos = departamentoRepository.findAll(pageRequest);

		PageRender<TDepartamento> pageRender = new PageRender<TDepartamento>("/listar-departamentos", tDepartamentos);
		model.addAttribute("titulo", "Listado de departamentos");
		model.addAttribute("departamentos", tDepartamentos);
		model.addAttribute("page", pageRender);
		return "departamentos";
	}
	
	
	@RequestMapping(value = "/detalle-departamento/{id}", method = RequestMethod.GET)
	public String detalleDepartamento(@PathVariable(value = "id") Long id, Model model) {

		TDepartamento tDepartamentos = departamentoRepository.findById(id).get();
		if (tDepartamentos == null) {
			return "redirect:/listar-departamentos";
		}

		model.addAttribute("titulo", "Detalle Departamento: " + tDepartamentos.getNombreDepartamento());
		model.addAttribute("departamento", tDepartamentos);
		return "detalle-departamento-form";
	}
	
	
	@RequestMapping(value = "/nuevo-departamento", method = RequestMethod.GET)
	public String nuevoDepartamento(Model model) {
		TDepartamento tdepartamento = new TDepartamento();
		model.addAttribute("titulo", "Nuevo Departamento");
		model.addAttribute("departamento", tdepartamento);
		return "form-departamento";
	}
	
	@RequestMapping(value = "/nuevo-departamento", method = RequestMethod.POST)
	public String guardarDepartamento(@RequestParam("file") MultipartFile foto, TDepartamento tdepartamento) {
		Audit audit = null;
		

		if (tdepartamento.getId() != null && tdepartamento.getId() > 0) {
			TDepartamento departamento2 = departamentoRepository.findById(tdepartamento.getId()).get();
			audit = new Audit("Diego Modificador");
			tdepartamento.setAudit(audit);
			tdepartamento.setId(departamento2.getId());
			tdepartamento.getAudit().setTsCreated(departamento2.getAudit().getTsCreated());
			tdepartamento.getAudit().setUsuCreated(departamento2.getAudit().getUsuCreated());
		} else {
			audit = new Audit("Diego Creador");
			tdepartamento.setAudit(audit);
		}

		departamentoRepository.save(tdepartamento);
		return "redirect:/listar-departamentos";
	}
	
	@RequestMapping(value = "/editar-departamento/{id}", method = RequestMethod.GET)
	public String editarDepartamento(@PathVariable(value = "id") Long id, Model model) {
		TDepartamento tdepartamento = null;
		if (id > 0) {
			tdepartamento = departamentoRepository.findById(id).get();
		} else {
			return "redirect:/listar-departamentos";
		}
		model.addAttribute("titulo", "Editar Departamento");
		model.addAttribute("departamento", tdepartamento);
		return "form-departamento";
	}
	
	@RequestMapping(value = "/eliminar-departamento/{id}", method = RequestMethod.GET)
	public String eliminarDepartamento(@PathVariable(value = "id") Long id, Model model) {
		TDepartamento tdepartamento = null;
		if (id > 0) {
			tdepartamento = departamentoRepository.findById(id).get();
			departamentoRepository.delete(tdepartamento);
		} else {
			return "redirect:/listar-departamentos";
		}

		return "redirect:/listar-departamentos";
	}	

}
