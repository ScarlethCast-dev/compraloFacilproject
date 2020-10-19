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
@Table(name="t_estado_pedido")
public class TEstadoPedido extends AbstractEntity implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estado_pedido")
	private Long id;
	private String descripcion;
	
	@OneToMany(mappedBy = "tEstadoPedido")
    private List<TPedido> tPedido;
    
	
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

}

