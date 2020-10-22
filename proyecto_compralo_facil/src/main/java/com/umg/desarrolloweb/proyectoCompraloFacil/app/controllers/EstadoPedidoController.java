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

import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TEstadoPedido;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories.EstadoPedidoRepository;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.util.PageRender;

@Controller
public class EstadoPedidoController {
	
	@Autowired
	private EstadoPedidoRepository estadoPedidoRepository;
	
	@RequestMapping(value = "/listar-estadoPedidos", method = RequestMethod.GET)
	public String listarEstadoPedidos(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page, 4);

		Page<TEstadoPedido> testadoPedidos = estadoPedidoRepository.findAll(pageRequest);

		PageRender<TEstadoPedido> pageRender = new PageRender<TEstadoPedido>("/listar-estadoPedidos", testadoPedidos);
		model.addAttribute("titulo", "Listado de Estado de Pedidos");
		model.addAttribute("estadoPedidos", testadoPedidos);
		model.addAttribute("page", pageRender);
		return "estadoPedido/estadoPedidos";
	}
	
	@RequestMapping(value = "/detalle-estadoPedidos/{id}", method = RequestMethod.GET)
	public String detalleEstadoPedido(@PathVariable(value = "id") Long id, Model model) {

		TEstadoPedido testadoPedido = estadoPedidoRepository.findById(id).get();
		if (testadoPedido == null) {
			return "redirect:/listar-estadoPedidos";
		}

		model.addAttribute("titulo", "Detalle Estado Pedido: " + testadoPedido.getDescripcion());
		model.addAttribute("estadoPedido", testadoPedido);
		return "estadoPedido/detalle-estadoPedido-form";
	}
	
	
	@RequestMapping(value = "/nuevo-estadoPedido", method = RequestMethod.GET)
	public String nuevoEstadoPedido(Model model) {
		TEstadoPedido testadoPedido = new TEstadoPedido();
		model.addAttribute("titulo", "Nuevo EstadoPedido");
		model.addAttribute("estadoPedido", testadoPedido);
		return "estadoPedido/form-estadoPedido";
	}
	
	@RequestMapping(value = "/nuevo-estadoPedido", method = RequestMethod.POST)
	public String guardarEstadoPedido( TEstadoPedido testadoPedido) {
		Audit audit = null;
		
	
		if (testadoPedido.getId() != null && testadoPedido.getId() > 0) {
			TEstadoPedido estadoPedido2 = estadoPedidoRepository.findById(testadoPedido.getId()).get();
			audit = new Audit("Marvin Modificador");
			testadoPedido.setAudit(audit);
			testadoPedido.setId(estadoPedido2.getId());
			testadoPedido.getAudit().setTsCreated(estadoPedido2.getAudit().getTsCreated());
			testadoPedido.getAudit().setUsuCreated(estadoPedido2.getAudit().getUsuCreated());
		} else {
			audit = new Audit("Marvin Creador");
			testadoPedido.setAudit(audit);
		}

		estadoPedidoRepository.save(testadoPedido);
		return "redirect:/listar-estadoPedidos";
	}
	
	@RequestMapping(value = "/editar-estadoPedido/{id}", method = RequestMethod.GET)
	public String editarEstadoPedido(@PathVariable(value = "id") Long id, Model model) {
		TEstadoPedido testadoPedido = null;
		if (id > 0) {
			testadoPedido = estadoPedidoRepository.findById(id).get();
		} else {
			return "redirect:/listar-estadoPedidos";
		}
		model.addAttribute("titulo", "Editar EstadoPedido");
		model.addAttribute("estadoPedido", testadoPedido);
		return "estadoPedido/form-estadoPedido";
	}
	
	@RequestMapping(value = "/eliminar-estadoPedido/{id}", method = RequestMethod.GET)
	public String eliminarEstadoPedido(@PathVariable(value = "id") Long id, Model model) {
		TEstadoPedido testadoPedido = null;
		if (id > 0) {
			testadoPedido = estadoPedidoRepository.findById(id).get();
			estadoPedidoRepository.delete(testadoPedido);
		} else {
			return "redirect:/listar-estadoPedidos";
		}

		return "redirect:/listar-estadoPedidos";
	}	
	


}
