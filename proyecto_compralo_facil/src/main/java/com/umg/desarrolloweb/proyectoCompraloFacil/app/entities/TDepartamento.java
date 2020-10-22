package com.umg.desarrolloweb.proyectoCompraloFacil.app.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="t_departamento")
public class TDepartamento extends AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_departamento")
    private Long id;
	@Column(name = "nombre_depart")
    private String nombreDepartamento;
	
    @OneToMany(mappedBy = "tDepartamento")
    private List<TDirecciones>tDirecciones;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombreDepartamento() {
		return nombreDepartamento;
	}
	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}
	public List<TDirecciones> gettDirecciones() {
		return tDirecciones;
	}
	public void settDirecciones(List<TDirecciones> tDirecciones) {
		this.tDirecciones = tDirecciones;
	}
	
	

	
}
