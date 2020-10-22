package com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;


import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TProducto;

public interface ProductoRepository extends PagingAndSortingRepository<TProducto, Long> {

}