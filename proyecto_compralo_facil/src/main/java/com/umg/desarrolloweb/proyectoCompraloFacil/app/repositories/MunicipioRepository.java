package com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TMunicipio;

@Repository
public interface MunicipioRepository extends PagingAndSortingRepository<TMunicipio, Long> {

}
