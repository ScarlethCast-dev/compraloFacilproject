package com.umg.desarrolloweb.proyectoCompraloFacil.app.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.umg.desarrolloweb.proyectoCompraloFacil.app.dto.CarritoDTO;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.Audit;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TCliente;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TDetallePedido;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TEstadoPedido;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TMetodoEnvio;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TPedido;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TUsuario;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories.PedidoRepository;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories.UsuarioRepository;

@Secured("ROLE_ADMIN")
@Controller
public class CarritoController {

	private List<CarritoDTO> lista = new ArrayList<>();
	private Integer total;
	
	@Autowired
	private UsuarioRepository userRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;	 
	
	@GetMapping("/form")
	public String form(Model model) {
		return "carrito/form-carrito";
		
	}

	@PostMapping("/carrito")
	public String ingresar(Model model, 
			 @RequestParam(name = "cantidad") Long cantidad,
			 @RequestParam(name = "asin") String codigo,
			 @RequestParam(name = "productTitle") String producto,
			 @RequestParam(name = "precioQuetzales") BigDecimal precio,
			 @RequestParam(name = "mainImage.imageUrl") String imagen,
			 @RequestParam(name = "link") String link) {
	
		CarritoDTO det = new CarritoDTO();
		
		boolean dado=true; 
		Long cantidadSum;
		for (int i = 0; i < lista.size(); i++) {
			if (Objects.equals(lista.get(i).getCodigoProducto(), codigo)) {
				cantidadSum=lista.get(i).getCantidad() + 1;
				det.setCodigoProducto(lista.get(i).getCodigoProducto());
				det.setLink(lista.get(i).getLink());
				det.setDescripcion(lista.get(i).getDescripcion());
				det.setPrecio(lista.get(i).getPrecio());
				det.setCantidad(cantidadSum);
				
				this.lista.set(i, det);
				dado=false;
			}
		}
		
		
		if (dado==true) {
			Long pre= precio.longValue();
			det.setCodigoProducto(codigo);
			det.setLink(link);
			det.setDescripcion(producto);
			det.setPrecio(pre);
			det.setImagenProducto(imagen);
			det.setCantidad(cantidad);
			
			this.lista.add(det);
			
		}
		

		return "redirect:/carrito";	
	}
	
	@GetMapping(value = "/eliminar-producto-carrito/{codigo}") 
	public String eliminar(@PathVariable(value = "codigo") String codigo){
		for (int i = 0; i < lista.size(); i++) {
			if(Objects.equals(lista.get(i).getCodigoProducto(), codigo)) {
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
	public String pago(Model model, Authentication authentication) {
		total();
		
		TUsuario usuario = userRepository.findByUsername(authentication.getName());
		model.addAttribute("titulo", "Formulario de Pago");
		model.addAttribute("total", total);
		model.addAttribute("lista", lista);
		model.addAttribute("usuario", usuario);

		return "carrito/carrito-pago";
		
	}
	
	@GetMapping(value = "/cambiar-suma/{codigo}") 
	public String sumar(@PathVariable(value = "codigo") String codigo){
		CarritoDTO det = new CarritoDTO();
		Long cantidadSum;
		for (int i = 0; i < lista.size(); i++) {
			if(Objects.equals(lista.get(i).getCodigoProducto(), codigo)) {
				cantidadSum=lista.get(i).getCantidad() + 1;				
				det.setCodigoProducto(lista.get(i).getCodigoProducto());
				det.setLink(lista.get(i).getLink());
				det.setDescripcion(lista.get(i).getDescripcion());
				det.setPrecio(lista.get(i).getPrecio());
				det.setImagenProducto(lista.get(i).getImagenProducto());
				det.setCantidad(cantidadSum);
				
				
				this.lista.set(i, det);
				
			}
		}
		return "redirect:/carrito";
	}
	
	@GetMapping(value = "/cambiar-resta/{codigo}") 
	public String restar(@PathVariable(value = "codigo") String codigo){
		CarritoDTO det = new CarritoDTO();
		Long cantidadSum;
		for (int i = 0; i < lista.size(); i++) {
			if(Objects.equals(lista.get(i).getCodigoProducto(), codigo)) {
				
				cantidadSum=lista.get(i).getCantidad() - 1;
				det.setCodigoProducto(lista.get(i).getCodigoProducto());
				det.setLink(lista.get(i).getLink());
				det.setDescripcion(lista.get(i).getDescripcion());
				det.setPrecio(lista.get(i).getPrecio());
				det.setImagenProducto(lista.get(i).getImagenProducto());
				det.setCantidad(cantidadSum);
				
				this.lista.set(i, det);
				
				if (cantidadSum==0) {
					return "redirect:/eliminar-producto-carrito/"+codigo;
				}
				
			}
		}
		return "redirect:/carrito";
	}

	public void total(){
		total=0;
		for(CarritoDTO det1: lista) {
			total += Integer.valueOf(det1.getCantidad().intValue()) * Integer.valueOf(det1.getPrecio().intValue()); 
		}
		
	}
	
	@PostMapping("/generar-pedido")
	public String guardar(TPedido pedido, Authentication authentication) {
		
		for (int i = 0; i < lista.size(); i++) {
			
			TDetallePedido det = new TDetallePedido();
			det.setCodigo(lista.get(i).getCodigoProducto());
			det.setLinkProducto(lista.get(i).getLink());
			det.setDetalleProducto(lista.get(i).getDescripcion());
			det.setPrecio(lista.get(i).getPrecio());
			det.setCantidad(lista.get(i).getCantidad());
			
			pedido.addItemPedido(det);	
		}
		
		
		
		Date fecha= new Date();
		TUsuario usuario = userRepository.findByUsername(authentication.getName());
		
		pedido.setFechaPedido(fecha);
		TCliente cli = new TCliente();
		cli.setId(usuario.getCliente().getId());
		pedido.settCliente(cli);
		TEstadoPedido ped = new TEstadoPedido();
		ped.setId(1l);
		pedido.settEstadoPedido(ped);
		TMetodoEnvio env = new TMetodoEnvio();
		env.setId(1l);
		pedido.settMetodoEnvio(env);
		
		Audit audit = null;
		audit = new Audit("Diego Creador");
		pedido.setAudit(audit);
		
		pedidoRepository.save(pedido);
		
		lista.clear();
		
		return "redirect:/listar-pedido";
		
		
	}
	

}
