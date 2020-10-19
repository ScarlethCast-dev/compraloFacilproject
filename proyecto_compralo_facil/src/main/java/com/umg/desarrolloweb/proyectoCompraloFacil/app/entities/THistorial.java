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
@Table(name="t_historial")
public class THistorial extends AbstractEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_historial")
    private Long idHistorial;
	
	@Column(name = "link_producto")
	private String linkProducto;
	
    @Column(name = "fecha_busqueda")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date fechaBusqueda;
	
	@Column(name = "id_cliente")
	private Long idcliente;
	
	
    
	@ManyToOne
	@JoinColumn(name = "id_cliente" , insertable = false, updatable = false)
	private TCliente tCliente;



	public Long getIdHistorial() {
		return idHistorial;
	}



	public void setIdHistorial(Long idHistorial) {
		this.idHistorial = idHistorial;
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



	public Long getIdcliente() {
		return idcliente;
	}



	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}


	
}
