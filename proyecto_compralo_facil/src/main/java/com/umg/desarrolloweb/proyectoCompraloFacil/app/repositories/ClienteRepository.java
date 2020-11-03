package com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TCliente;

public interface ClienteRepository extends PagingAndSortingRepository<TCliente, Long> {
	
//	@Query("select c from TCliente c where c.nombre like %1%")
//	public List<TCliente> findByName(String term);
	
}
