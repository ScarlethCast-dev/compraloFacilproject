package com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TEstadoCuenta;

@Repository
public interface EstadoCuentaRepository extends PagingAndSortingRepository<TEstadoCuenta, Long> {

}
