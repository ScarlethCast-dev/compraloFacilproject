package com.umg.desarrolloweb.proyectoCompraloFacil.app.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="t_metodo_envio")
public class TMetodoEnvio extends AbstractEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_metodo_envio")
    private Long id;

    private String descripcion;
    
    @OneToMany(mappedBy = "tMetodoEnvio")
    private List<TPedido> tPedido;
    
    
    

	public TMetodoEnvio() {
		this.tPedido = new ArrayList<TPedido>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<TPedido> gettPedido() {
		return tPedido;
	}

	public void settPedido(List<TPedido> tPedido) {
		this.tPedido = tPedido;
	}
    
	

}
