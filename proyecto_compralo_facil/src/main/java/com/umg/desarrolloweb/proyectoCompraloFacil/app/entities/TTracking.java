package com.umg.desarrolloweb.proyectoCompraloFacil.app.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="t_tracking")
public class TTracking extends AbstractEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tracking")
    private Long idTracking;
	
    private String descripcion;
    private String comentario;

	@Column(name = "id_pedido")
    private Long idPedido;
	
	
	@ManyToOne
	@JoinColumn(name="id_pedido", insertable=false, updatable = false)
	private TPedido tPedido; 
	
	
	
	
	

	public Long getIdTracking() {
		return idTracking;
	}

	public void setIdTracking(Long idTracking) {
		this.idTracking = idTracking;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
    
	
	
	

}
