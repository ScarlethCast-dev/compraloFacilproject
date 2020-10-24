package com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TFactura;

public interface FacturaRepository extends PagingAndSortingRepository<TFactura, Long> {

}
