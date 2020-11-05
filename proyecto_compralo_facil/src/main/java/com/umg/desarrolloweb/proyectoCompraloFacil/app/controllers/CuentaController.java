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
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TCuenta;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TEstadoCuenta;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TPedido;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories.CuentaRepository;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories.EstadoCuentaRepository;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories.PedidoRepository;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.util.PageRender;

@Secured("ROLE_ADMIN")
@Controller
public class CuentaController {
	
	@Autowired
	private CuentaRepository cuentaRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private EstadoCuentaRepository estadoCuentaRespository;
	
	
	@RequestMapping(value = "/listar-cuentas", method = RequestMethod.GET)
	public String listarCuentas(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page, 5);

		Page<TCuenta> tcuenta = cuentaRepository.findAll(pageRequest);

		PageRender<TCuenta> pageRender = new PageRender<TCuenta>("/listar-direcciones", tcuenta);
		model.addAttribute("titulo", "Listado de cuentas");
		model.addAttribute("cuentas", tcuenta);
		model.addAttribute("page", pageRender);
		return "cuenta/cuentas";
	}
	
	@RequestMapping(value = "/detalle-cuenta/{id}", method = RequestMethod.GET)
	public String detalleCuenta(@PathVariable(value = "id") Long id, Model model) {

		TCuenta tcuenta = cuentaRepository.findById(id).get();
		if (tcuenta == null) {
			return "redirect:/listar-cuentas";
		}

		model.addAttribute("titulo", "Detalle Cuenta: " + tcuenta.getId());
		model.addAttribute("cuentas", tcuenta);
		return "cuenta/detalle-cuenta-form";
	}
	
	@RequestMapping(value = "/nuevo-cuenta", method = RequestMethod.GET)
	public String nuevoCuenta(Model model) {
		TCuenta tcuenta = new TCuenta();
		
		model.addAttribute("titulo", "Nuevo Cuenta");
		model.addAttribute("cuentas", tcuenta);
		return "cuenta/form-cuenta";
	}
	
	@RequestMapping(value = "/nuevo-cuenta", method = RequestMethod.POST)
	public String guardarCuenta(TCuenta tcuenta) {
		Audit audit = null;
		
		if (tcuenta.getId() != null && tcuenta.getId() > 0) {
			TCuenta tcuenta2 = cuentaRepository.findById(tcuenta.getId()).get();
			audit = new Audit("Mynor Modificador");
			tcuenta.setAudit(audit);
			tcuenta.setId(tcuenta.getId());	
			tcuenta.getAudit().setTsCreated(tcuenta2.getAudit().getTsCreated());
			tcuenta.getAudit().setUsuCreated(tcuenta2.getAudit().getUsuCreated());
		} else {
			audit = new Audit("Mynor Creador");
			tcuenta.setAudit(audit);
		}
		
		TPedido tpedido = pedidoRepository.findById(tcuenta.gettPedido().getId()).get();
		TEstadoCuenta testadocuenta = estadoCuentaRespository.findById(tcuenta.gettEstadoCuenta().getId()).get();
		

		tcuenta.settPedido(tpedido);
		tcuenta.settEstadoCuenta(testadocuenta);

			
		cuentaRepository.save(tcuenta);
		return "redirect:listar-cuentas";
		
	}
	
	@RequestMapping(value = "/editar-cuenta/{id}", method = RequestMethod.GET)
	public String editarCuenta(@PathVariable(value = "id") Long id, Model model) {
		TCuenta tcuenta = null;
		if (id > 0) {
			tcuenta = cuentaRepository.findById(id).get();
		} else {
			return "redirect:/listar-cuentas";
		}
		model.addAttribute("titulo", "Editar Cuenta");
		model.addAttribute("cuentas", tcuenta);
		return "cuenta/form-cuenta";
	}
	
	@RequestMapping(value = "/eliminar-cuenta/{id}", method = RequestMethod.GET)
	public String eliminarCuenta(@PathVariable(value = "id") Long id, Model model) {
		TCuenta tcuenta = null;
		if (id > 0) {
			tcuenta = cuentaRepository.findById(id).get();
			cuentaRepository.delete(tcuenta);
		} else {
			return "redirect:/listar-cuentas";
		}

		return "redirect:/listar-cuentas";
	}
	
	


}
