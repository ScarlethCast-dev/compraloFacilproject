package com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TDepartamento;

@Repository
public interface DepartamentoRepository extends PagingAndSortingRepository<TDepartamento, Long> {

}
