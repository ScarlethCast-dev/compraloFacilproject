package com.umg.desarrolloweb.proyectoCompraloFacil.app.entities;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "tClientes")
public class MUNICIPIO extends AbstractEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_municipio")
    private Long id;
	@Column(name = "nombre_municipio")
    private String nombreMunicipio;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombreMunicipio() {
		return nombreMunicipio;
	}
	public void setNombreMunicipio(String nombreMunicipio) {
		this.nombreMunicipio = nombreMunicipio;
	}


	

}
