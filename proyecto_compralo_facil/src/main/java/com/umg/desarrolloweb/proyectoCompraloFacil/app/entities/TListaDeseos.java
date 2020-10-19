package com.umg.desarrolloweb.proyectoCompraloFacil.app.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="t_lista_deseos")
public class TListaDeseos extends AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_lista")
	private Long id;
	@Column(name = "link_producto")
	private String linkProducto;
	@Column(name = "fecha_busqueda")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date fechaBusqueda;
	
	@Column(name = "id_cliente")
	private Long idCliente;


	@ManyToOne
	@JoinColumn(name = "id_cliente" , insertable = false, updatable = false)
	private TCliente tCliente;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLinkProducto() {
		return linkProducto;
	}


	public void setLinkProducto(String linkProducto) {
		this.linkProducto = linkProducto;
	}


	public Date getFechaBusqueda() {
		return fechaBusqueda;
	}


	public void setFechaBusqueda(Date fechaBusqueda) {
		this.fechaBusqueda = fechaBusqueda;
	}
	public Long getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	
	
}
