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
		
		boolean dado=true; 
		Long cantidadSum;
		for (int i = 0; i < lista.size(); i++) {
			if (Objects.equals(lista.get(i).getIdDetallePedido(), tDetallePedido.getIdDetallePedido())) {
				cantidadSum=lista.get(i).getCantidad() + 1;
				det.setIdDetallePedido(lista.get(i).getIdDetallePedido());
				det.setLinkProducto(lista.get(i).getLinkProducto());
				det.setDetalleProducto(lista.get(i).getDetalleProducto());
				det.setPrecio(lista.get(i).getPrecio());
				det.setCantidad(cantidadSum);
				
				this.lista.set(i, det);
				dado=false;
			}
		}
		
		if (dado==true) {
			det.setIdDetallePedido(tDetallePedido.getIdDetallePedido());
			det.setLinkProducto(tDetallePedido.getLinkProducto());
			det.setDetalleProducto(tDetallePedido.getDetalleProducto());
			det.setPrecio(tDetallePedido.getPrecio());
			det.setCantidad(tDetallePedido.getCantidad());
			
			this.lista.add(det);
			
		}
		

		return "redirect:/carrito";	
	}
	
	@GetMapping(value = "/eliminar-producto-carrito/{id}") 
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
	
	@GetMapping("/carrito-pago")
	public String pago(Model model) {
		total();
		
		model.addAttribute("titulo", "Formulario de Pago");
		model.addAttribute("total", total);
		model.addAttribute("lista", lista);

		return "carrito/carrito-pago";
		
	}
	
	@GetMapping(value = "/cambiar-suma/{id}") 
	public String sumar(@PathVariable(value = "id") Long id){
		TDetallePedido det = new TDetallePedido();
		Long cantidadSum;
		for (int i = 0; i < lista.size(); i++) {
			if(Objects.equals(lista.get(i).getIdDetallePedido(), id)) {
				cantidadSum=lista.get(i).getCantidad() + 1;
				det.setIdDetallePedido(lista.get(i).getIdDetallePedido());
				det.setLinkProducto(lista.get(i).getLinkProducto());
				det.setDetalleProducto(lista.get(i).getDetalleProducto());
				det.setPrecio(lista.get(i).getPrecio());
				det.setCantidad(cantidadSum);
				
				this.lista.set(i, det);
				
			}
		}
		return "redirect:/carrito";
	}
	
	@GetMapping(value = "/cambiar-resta/{id}") 
	public String restar(@PathVariable(value = "id") Long id){
		TDetallePedido det = new TDetallePedido();
		Long cantidadSum;
		for (int i = 0; i < lista.size(); i++) {
			if(Objects.equals(lista.get(i).getIdDetallePedido(), id)) {
				
				cantidadSum=lista.get(i).getCantidad() - 1;
				det.setIdDetallePedido(lista.get(i).getIdDetallePedido());
				det.setLinkProducto(lista.get(i).getLinkProducto());
				det.setDetalleProducto(lista.get(i).getDetalleProducto());
				det.setPrecio(lista.get(i).getPrecio());
				det.setCantidad(cantidadSum);
				
				this.lista.set(i, det);
				
				if (cantidadSum==0) {
					return "redirect:/eliminar-producto-carrito/"+id;
				}
				
			}
		}
		return "redirect:/carrito";
	}
	
	
	
	public void total(){
		total=0;
		for(TDetallePedido det1: lista) {
			total += Integer.valueOf(det1.getCantidad().intValue()) * Integer.valueOf(det1.getPrecio().intValue()); 
		}
		
	}

}
