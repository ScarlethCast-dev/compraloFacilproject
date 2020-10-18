package com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TCliente;

public interface ClienteRepository extends PagingAndSortingRepository<TCliente, Long> {

}
