package com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories;

import java.util.List;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TCliente;

public interface ClienteRepository extends PagingAndSortingRepository<TCliente, Long> {
	
	public List<TCliente> findByNombre(String nombre);
	
}
