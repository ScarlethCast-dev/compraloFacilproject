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
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TProducto;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories.ProductoRepository;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.util.PageRender;




@Controller
public class ProductoController {
	
	
	@Autowired
	private ProductoRepository productoRepository;
	

	@RequestMapping(value = "/listar-productos", method = RequestMethod.GET)
	public String listarProductos(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page, 4);

		Page<TProducto> tproductos = productoRepository.findAll(pageRequest);

		PageRender<TProducto> pageRender = new PageRender<TProducto>("/listar-productos", tproductos);
		model.addAttribute("titulo", "Listado de productos");
		model.addAttribute("productos", tproductos);
		model.addAttribute("page", pageRender);
		return "productos";
	}
	
	@RequestMapping(value = "/detalle-producto/{id}", method = RequestMethod.GET)
	public String detalleProducto(@PathVariable(value = "id") Long id, Model model) {

		TProducto tproducto = productoRepository.findById(id).get();
		if (tproducto == null) {
			return "redirect:/listar-productos";
		}

		model.addAttribute("titulo", "Detalle Producto: " + tproducto.getNombre());
		model.addAttribute("producto", tproducto);
		return "detalle-producto-form";
	}
	
	
	@RequestMapping(value = "/nuevo-producto", method = RequestMethod.GET)
	public String nuevoProducto(Model model) {
		TProducto tproducto = new TProducto();
		model.addAttribute("titulo", "Nuevo Producto");
		model.addAttribute("producto", tproducto);
		return "templates/form-producto";
	}
	
	@RequestMapping(value = "/nuevo-producto", method = RequestMethod.POST)
	public String guardarProducto(@RequestParam("file") MultipartFile foto, TProducto tproducto) {
		Audit audit = null;
		
		if (!foto.isEmpty()) {

			try {
				
				String path = "/Users/Ubuntu/Desktop/tmp/".concat(foto.getOriginalFilename());

				byte[] bytes = foto.getBytes();
				Path rutaCompleta = Paths.get(path);
				Files.write(rutaCompleta, bytes);
				tproducto.setFoto(foto.getOriginalFilename());

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (tproducto.getId() != null && tproducto.getId() > 0) {
			TProducto producto2 = productoRepository.findById(tproducto.getId()).get();
			audit = new Audit("Marvin Modificador");
			tproducto.setAudit(audit);
			tproducto.setId(producto2.getId());
			tproducto.getAudit().setTsCreated(producto2.getAudit().getTsCreated());
			tproducto.getAudit().setUsuCreated(producto2.getAudit().getUsuCreated());
		} else {
			audit = new Audit("Marvin Creador");
			tproducto.setAudit(audit);
		}

		productoRepository.save(tproducto);
		return "redirect:/listar-productos";
	}
	
	@RequestMapping(value = "/editar-producto/{id}", method = RequestMethod.GET)
	public String editarProducto(@PathVariable(value = "id") Long id, Model model) {
		TProducto tproducto = null;
		if (id > 0) {
			tproducto = productoRepository.findById(id).get();
		} else {
			return "redirect:/listar-productos";
		}
		model.addAttribute("titulo", "Editar Producto");
		model.addAttribute("producto", tproducto);
		return "form-producto";
	}
	
	@RequestMapping(value = "/eliminar-producto/{id}", method = RequestMethod.GET)
	public String eliminarProducto(@PathVariable(value = "id") Long id, Model model) {
		TProducto tproducto = null;
		if (id > 0) {
			tproducto = productoRepository.findById(id).get();
			productoRepository.delete(tproducto);
		} else {
			return "redirect:/listar-productos";
		}

		return "redirect:/listar-productos";
	}	

}
