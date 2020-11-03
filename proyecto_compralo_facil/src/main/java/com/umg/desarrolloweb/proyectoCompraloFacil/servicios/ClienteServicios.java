package com.umg.desarrolloweb.proyectoCompraloFacil.servicios;

import java.util.List;

import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TCliente;

public interface ClienteServicios {

	public List<TCliente> findByNombreStartsWith(String nombre, String apellido);
}
