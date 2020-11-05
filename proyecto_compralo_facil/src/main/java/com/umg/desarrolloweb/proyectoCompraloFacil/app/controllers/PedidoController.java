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
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TEstadoPedido;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TMetodoEnvio;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TPedido;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories.ClienteRepository;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories.EstadoPedidoRepository;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories.MetodoEnvioRepository;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories.PedidoRepository;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.util.PageRender;

@Secured("ROLE_ADMIN")
@Controller
public class PedidoController {
	
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EstadoPedidoRepository estadoPedidoRepository;
	
	@Autowired
	private MetodoEnvioRepository metodoEnvioRepository;
	

	@RequestMapping(value = "/listar-pedido", method = RequestMethod.GET)
	public String listarPedidos(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page, 5);

		Page<TPedido> tpedidos = pedidoRepository.findAll(pageRequest);

		PageRender<TPedido> pageRender = new PageRender<TPedido>("/listar-pedido", tpedidos);
		model.addAttribute("titulo", "Listado de pedidos");
		model.addAttribute("pedido", tpedidos);
		model.addAttribute("page", pageRender);
		return "pedidos/pedido";
	}
	
	@RequestMapping(value = "/detalle-pedido/{id}", method = RequestMethod.GET)
	public String detallePedido(@PathVariable(value = "id") Long id, Model model) {

		TPedido tpedidos = pedidoRepository.findById(id).get();
		if (tpedidos == null) {
			return "redirect:/listar-pedido";
		}

		model.addAttribute("titulo", "Detalle Pedido No. : " + tpedidos.getId());
		model.addAttribute("pedido", tpedidos);
		return "pedidos/detalle-pedido-form";
	}
	
	
	@RequestMapping(value = "/nuevo-pedido", method = RequestMethod.GET)
	public String nuevoPedido(Model model) {
		TPedido tpedidos = new TPedido();
		
		model.addAttribute("titulo", "Nuevo Pedido");
		model.addAttribute("pedido", tpedidos);
		return "pedidos/form-pedido";
	}
	
	
	@RequestMapping(value = "/nuevo-pedido", method = RequestMethod.POST)
	public String guardarPedido(TPedido tpedidos) {
		Audit audit = null;
		
		if (tpedidos.getId() != null && tpedidos.getId() > 0) {
			TPedido tpedidos1 = pedidoRepository.findById(tpedidos.getId()).get();
			audit = new Audit("Diego Modificador");
			tpedidos.setAudit(audit);
			tpedidos.setId(tpedidos1.getId());
			tpedidos.getAudit().setTsCreated(tpedidos1.getAudit().getTsCreated());
			tpedidos.getAudit().setUsuCreated(tpedidos1.getAudit().getUsuCreated());
		} else {
			audit = new Audit("Diego Creador");
			tpedidos.setAudit(audit);
		}

		TCliente cliente = clienteRepository.findById(tpedidos.gettCliente().getId()).get();
		TEstadoPedido estado = estadoPedidoRepository.findById(tpedidos.gettEstadoPedido().getId()).get();
		TMetodoEnvio envio = metodoEnvioRepository.findById(tpedidos.gettMetodoEnvio().getId()).get();
		
		tpedidos.settCliente(cliente);
		tpedidos.settEstadoPedido(estado);
		tpedidos.settMetodoEnvio(envio);
			
		pedidoRepository.save(tpedidos);
		return "redirect:listar-pedido";
	}
	
	@RequestMapping(value = "/editar-pedido/{id}", method = RequestMethod.GET)
	public String editarPedido(@PathVariable(value = "id") Long id, Model model) {
		TPedido tpedidos = null;
		if (id > 0) {
			tpedidos = pedidoRepository.findById(id).get();
		} else {
			return "redirect:/listar-pedido";
		}
		model.addAttribute("titulo", "Editar Pedido");
		model.addAttribute("pedido", tpedidos);
		return "pedidos/form-pedido";
	}
	
	@RequestMapping(value = "/eliminar-pedido/{id}", method = RequestMethod.GET)
	public String eliminarPedido(@PathVariable(value = "id") Long id, Model model) {
		TPedido tpedidos = null;
		if (id > 0) {
			tpedidos = pedidoRepository.findById(id).get();
			pedidoRepository.delete(tpedidos);
		} else {
			return "redirect:/listar-pedido";
		}

		return "redirect:/listar-pedido";
	}
	

}
