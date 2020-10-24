package com.umg.desarrolloweb.proyectoCompraloFacil.app.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "t_factura")
public class TFactura extends AbstractEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_factura")
	private Long idFactura;
	
	@Column(name = "fecha_factura")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date fechaFactura;
	@PrePersist
	public void prePersit() {
		fechaFactura = new Date();
	}
	
	private String descripcion;
	private String observaciones;
	

	 
//	 @Column(name = "id_cliente")
//	 private Long idCliente;
//	 
//	 @Column(name = "id_pedido")
//	 private Long idPedido;
//	  	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="cliente", insertable = false, updatable = false)
	 private TCliente tCliente;
	 
//	 @ManyToOne
//	 @JoinColumn(name="id_pedido", insertable = false, updatable = false)
//	 private TPedido tPedido;

//	 @OneToMany(mappedBy = "tFactura")
//	 private List<TDetalleFactura> tDetalleFactura;
	

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="id_factura")
	private List<TDetalleFactura> tDetalleFactura;
	 
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pedido")
	private TPedido tpedido;

	public TFactura() {
		this.tDetalleFactura = new ArrayList<TDetalleFactura>();
	}

	public Long getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}

	public Date getFechaFactura() {
		return fechaFactura;
	}

	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	 
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
//	 public TPedido getTpedido() {
//		return tpedido;
//	}
//
//	public void setTpedido(TPedido tpedido) {
//		this.tpedido = tpedido;
//	}

	public TCliente gettCliente() {
		return tCliente;
	}

	public void settCliente(TCliente tCliente) {
		this.tCliente = tCliente;
	}
	 

	public List<TDetalleFactura> gettDetalleFactura() {
		return tDetalleFactura;
	}

	public void settDetalleFactura(List<TDetalleFactura> tDetalleFactura) {
		this.tDetalleFactura = tDetalleFactura;
	}
	
	public void addItemAFactura(TDetalleFactura item){ //anadir un item a la factura
		this.tDetalleFactura.add(item);
	}
		
	public Double calcularTotal(){
		Double total= 0.0;
		int size= tDetalleFactura.size();
		
		for(int i=0; i<=size; i++){
			total+= tDetalleFactura.get(i).calcularImporte();
			
		}
		return total;
		
	}
		
}
