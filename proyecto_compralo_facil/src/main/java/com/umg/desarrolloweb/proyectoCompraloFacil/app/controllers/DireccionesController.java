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
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TCliente;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TDepartamento;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TDirecciones;


import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TMunicipio;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories.ClienteRepository;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories.DepartamentoRepository;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories.DireccionesRepository;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories.MunicipioRepository;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.util.PageRender;

@Secured("ROLE_ADMIN")
@Controller
public class DireccionesController {
	
	@Autowired
	private DireccionesRepository direccionesRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private MunicipioRepository municipioRepository;
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@RequestMapping(value = "/listar-direcciones", method = RequestMethod.GET)
	public String listarDirecciones(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page, 5);

		Page<TDirecciones> tdirecciones = direccionesRepository.findAll(pageRequest);

		PageRender<TDirecciones> pageRender = new PageRender<TDirecciones>("/listar-direcciones", tdirecciones);
		model.addAttribute("titulo", "Listado de direcciones");
		model.addAttribute("direcciones", tdirecciones);
		model.addAttribute("page", pageRender);
		return "direcciones/direcciones";
	}
	
	
	@RequestMapping(value = "/detalle-direccion/{id}", method = RequestMethod.GET)
	public String detalleDireccion(@PathVariable(value = "id") Long id, Model model) {

		TDirecciones tdirecciones = direccionesRepository.findById(id).get();
		if (tdirecciones == null) {
			return "redirect:/listar-direcciones";
		}

		model.addAttribute("titulo", "Detalle direcion: " + tdirecciones.getId());
		model.addAttribute("direcciones", tdirecciones);
		return "direcciones/detalle-direccion-form";
	}
	
	@RequestMapping(value = "/nuevo-direccion", method = RequestMethod.GET)
	public String nuevoDireccion(Model model) {
		TDirecciones tdirecciones = new TDirecciones();
		
		model.addAttribute("titulo", "Nuevo Direccion");
		model.addAttribute("direcciones", tdirecciones);
		return "direcciones/form-direccion";
	}
	
	
	@RequestMapping(value = "/nuevo-direccion", method = RequestMethod.POST)
	public String guardarDireccion(TDirecciones tdirecciones) {
		Audit audit = null;
		
		if (tdirecciones.getId() != null && tdirecciones.getId() > 0) {
			TDirecciones tdirecciones1 = direccionesRepository.findById(tdirecciones.getId()).get();
			audit = new Audit("Mynor Modificador");
			tdirecciones.setAudit(audit);
			tdirecciones.setIdDirecciones(tdirecciones1.getId());

			tdirecciones.getAudit().setTsCreated(tdirecciones1.getAudit().getTsCreated());
			tdirecciones.getAudit().setUsuCreated(tdirecciones1.getAudit().getUsuCreated());
		} else {
			audit = new Audit("Mynor Creador");
			tdirecciones.setAudit(audit);
		}

		TCliente cliente = clienteRepository.findById(tdirecciones.gettCliente().getId()).get();
		TMunicipio tmunicipio = municipioRepository.findById(tdirecciones.gettMunicipio().getId()).get();
		TDepartamento tdepartamento = departamentoRepository.findById(tdirecciones.gettDepartamento().getId()).get();
		
		tdirecciones.settCliente(cliente);
		tdirecciones.settMunicipio(tmunicipio);
		tdirecciones.settDepartamento(tdepartamento);
			
		direccionesRepository.save(tdirecciones);
		return "redirect:listar-direcciones";
	}
	
	@RequestMapping(value = "/editar-direccion/{id}", method = RequestMethod.GET)
	public String editarDireccion(@PathVariable(value = "id") Long id, Model model) {
		TDirecciones tdirecciones = null;
		if (id > 0) {
			tdirecciones = direccionesRepository.findById(id).get();
		} else {
			return "redirect:/listar-direcciones";
		}
		model.addAttribute("titulo", "Editar direccion");
		model.addAttribute("direcciones", tdirecciones);
		return "direcciones/form-direccion";
	}
	
	@RequestMapping(value = "/eliminar-direccion/{id}", method = RequestMethod.GET)
	public String eliminarDireccion(@PathVariable(value = "id") Long id, Model model) {
		TDirecciones tdirecciones = null;
		if (id > 0) {
			tdirecciones = direccionesRepository.findById(id).get();
			direccionesRepository.delete(tdirecciones);
		} else {
			return "redirect:/listar-direcciones";
		}

		return "redirect:/listar-direcciones";
	}
	
	

}
