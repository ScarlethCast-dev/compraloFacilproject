package com.umg.desarrolloweb.proyectoCompraloFacil.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TDetallePedido;

@Controller

public class CarritoController {

	private List<TDetallePedido> lista = new ArrayList<>();
	private Integer total;
	
	@GetMapping("/form")
	public String form(Model model) {
		return "carrito/form-carrito";
		
	}

	@PostMapping("/carrito")
	public String ingresar(TDetallePedido tDetallePedido,  Model model) {
		
		TDetallePedido det = new TDetallePedido();
		
		det.setIdDetallePedido(tDetallePedido.getIdDetallePedido());
		det.setLinkProducto(tDetallePedido.getLinkProducto());
		det.setDetalleProducto(tDetallePedido.getDetalleProducto());
		det.setPrecio(tDetallePedido.getPrecio());
		det.setCantidad(tDetallePedido.getCantidad());
		
		this.lista.add(det);

		return "redirect:/carrito";	
	}
	
	@GetMapping(value = "/eliminar-producto/{id}") 
	public String eliminar(@PathVariable(value = "id") Long id){
		for (int i = 0; i < lista.size(); i++) {
			if(Objects.equals(lista.get(i).getIdDetallePedido(), id)) {
				this.lista.remove(i);
			}
		}
		return "redirect:/carrito";
	}
	
	@GetMapping("/carrito")
	public String listar(Model model) {
		total();
		
		model.addAttribute("titulo", "Carrito");
		model.addAttribute("tDetallePedido", lista);
		model.addAttribute("total", total);

		return "carrito/carrito-lista";
		
	}
	
	public void total(){
		total=0;
		for(TDetallePedido det1: lista) {
			total += Integer.valueOf(det1.getCantidad().intValue()) * Integer.valueOf(det1.getPrecio().intValue()); 
		}
		
	}

}
