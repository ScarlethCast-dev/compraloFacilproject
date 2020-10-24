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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="t_pedido")
public class TPedido extends AbstractEntity implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Long id;
	
	@Column(name = "fecha_pedido")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date fechaPedido;

	@ManyToOne(fetch = FetchType.LAZY)
	private TEstadoPedido tEstadoPedido; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	private TCliente tCliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private TMetodoEnvio tMetodoEnvio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private TProducto tProducto;
	
	@OneToMany(mappedBy = "tPedido")
    private List<TCuenta> tCuenta;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_pedido")
    private List<TDetallePedido> tDetallePedidos;
	
	@OneToMany(mappedBy = "tPedido")
    private List<TTracking> tTracking;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name= "id_factura")
	private List<TFactura>tFactura;
	

	public TPedido() {
		this.tDetallePedidos = new ArrayList<TDetallePedido>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public TEstadoPedido gettEstadoPedido() {
		return tEstadoPedido;
	}

	public void settEstadoPedido(TEstadoPedido tEstadoPedido) {
		this.tEstadoPedido = tEstadoPedido;
	}

	public TMetodoEnvio gettMetodoEnvio() {
		return tMetodoEnvio;
	}

	public void settMetodoEnvio(TMetodoEnvio tMetodoEnvio) {
		this.tMetodoEnvio = tMetodoEnvio;
	}

	public TCliente gettCliente() {
		return tCliente;
	}

	public void settCliente(TCliente tCliente) {
		this.tCliente = tCliente;
	}

	public List<TDetallePedido> gettDetallePedidos() {
		return tDetallePedidos;
	}

	public void settDetallePedidos(List<TDetallePedido> tDetallePedidos) {
		this.tDetallePedidos = tDetallePedidos;
	}
	
	

	
	
}
