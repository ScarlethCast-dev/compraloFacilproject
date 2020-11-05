package com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TUsuario;

@Repository
public interface UsuarioRepository  extends CrudRepository<TUsuario, Long>{
	
	public TUsuario findByUsername(String username);

}
