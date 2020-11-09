package com.umg.desarrolloweb.proyectoCompraloFacil.app.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;


import com.umg.desarrolloweb.proyectoCompraloFacil.app.dto.AmazonProductLinkDTO;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.Audit;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TProducto;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories.ProductoRepository;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.util.PageRender;

import ch.qos.logback.classic.Logger;

@Secured("ROLE_ADMIN")
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
	//	model.addAttribute("productos", consultarApi());
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
		model.addAttribute("productos", tproducto);
		return "detalle-producto-form";
	}

	@RequestMapping(value = "/nuevo-producto", method = RequestMethod.GET)
	public String nuevoProducto(Model model) {
		TProducto tproducto = new TProducto();
		model.addAttribute("titulo", "Nuevo Producto");
		model.addAttribute("productos", tproducto);
		return "form-producto";
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
		model.addAttribute("productos", tproducto);
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
	
	private HttpHeaders createHttpHeaders(String key, String value) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set(key, value);
		return headers;
	}

	private AmazonProductLinkDTO consultarapi(String urlProduct) {

		RestTemplate restTemplate = new RestTemplate();
		String host = "http://api-prd.axesso.de/amz/amazon-lookup-product?url=";
		AmazonProductLinkDTO producto = new AmazonProductLinkDTO();
		try {

			HttpHeaders headers = createHttpHeaders("axesso-api-key", "19d3c470-db2f-4c5d-9d51-81ccb9d1774a");
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			ResponseEntity<AmazonProductLinkDTO> response = restTemplate.exchange(host + urlProduct, HttpMethod.GET, entity,
					AmazonProductLinkDTO.class);
			producto = response.getBody();
		} catch (Exception e) {
			System.out.println(e);
		}
		return producto;
	}

}
