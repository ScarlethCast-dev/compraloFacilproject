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
import com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories.ClienteRepository;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.util.PageRender;


@Controller
public class ClienteController {
	
	
	@Autowired
	private ClienteRepository clienteRepository;
	

	
	@RequestMapping(value = {"/listar-clientes","/listar-clientes{param}"}, method = RequestMethod.GET)
	public String listarClientes(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page, 4);

		Page<TCliente> tclientes = clienteRepository.findAll(pageRequest);

		PageRender<TCliente> pageRender = new PageRender<TCliente>("/listar-clientes", tclientes);
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", tclientes);
		model.addAttribute("page", pageRender);
		return "clientes/clientes";
	}

	
	@RequestMapping(value = "/detalle-cliente/{id}", method = RequestMethod.GET)
	public String detalleCliente(@PathVariable(value = "id") Long id, Model model) {

		TCliente tcliente = clienteRepository.findById(id).get();
		if (tcliente == null) {
			return "redirect:/listar-clientes";
		}

		model.addAttribute("titulo", "Detalle Cliente: " + tcliente.getNombre());
		model.addAttribute("cliente", tcliente);
		return "clientes/detalle-cliente-form";
	}
	
	
	@RequestMapping(value = "/nuevo-cliente", method = RequestMethod.GET)
	public String nuevoCliente(Model model) {
		TCliente tcliente = new TCliente();
		model.addAttribute("titulo", "Nuevo Cliente");
		model.addAttribute("cliente", tcliente);
		return "clientes/form-cliente";
	}
	
	@RequestMapping(value = "/nuevo-cliente", method = RequestMethod.POST)
	public String guardarCliente(@RequestParam("file") MultipartFile foto, TCliente tcliente) {
		Audit audit = null;
		
		if (!foto.isEmpty()) {

			try {
				
				String path = "/Users/Ubuntu/Desktop/tmp/".concat(foto.getOriginalFilename());

				byte[] bytes = foto.getBytes();
				Path rutaCompleta = Paths.get(path);
				Files.write(rutaCompleta, bytes);
				tcliente.setFoto(foto.getOriginalFilename());

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (tcliente.getId() != null && tcliente.getId() > 0) {
			TCliente cliente2 = clienteRepository.findById(tcliente.getId()).get();
			audit = new Audit("Diego Modificador");
			tcliente.setAudit(audit);
			tcliente.setId(cliente2.getId());
			tcliente.getAudit().setTsCreated(cliente2.getAudit().getTsCreated());
			tcliente.getAudit().setUsuCreated(cliente2.getAudit().getUsuCreated());
		} else {
			audit = new Audit("Diego Creador");
			tcliente.setAudit(audit);
		}

		clienteRepository.save(tcliente);
		return "redirect:/listar-clientes";
	}
	
	@RequestMapping(value = "/editar-cliente/{id}", method = RequestMethod.GET)
	public String editarCliente(@PathVariable(value = "id") Long id, Model model) {
		TCliente tcliente = null;
		if (id > 0) {
			tcliente = clienteRepository.findById(id).get();
		} else {
			return "redirect:/listar-clientes";
		}
		model.addAttribute("titulo", "Editar Cliente");
		model.addAttribute("cliente", tcliente);
		return "clientes/form-cliente";
	}
	
	@RequestMapping(value = "/eliminar-cliente/{id}", method = RequestMethod.GET)
	public String eliminarCliente(@PathVariable(value = "id") Long id, Model model) {
		TCliente tcliente = null;
		if (id > 0) {
			tcliente = clienteRepository.findById(id).get();
			clienteRepository.delete(tcliente);
		} else {
			return "redirect:/listar-clientes";
		}

		return "redirect:/listar-clientes";
	}	

}
