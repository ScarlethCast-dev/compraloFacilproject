package com.umg.desarrolloweb.proyectoCompraloFacil.app.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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

	@ManyToOne
	//@JoinColumn(name="id_estado_pedido", insertable=false, updatable = false)
	private TEstadoPedido tEstadoPedido; 
	
	@ManyToOne
	//@JoinColumn(name="id_cliente", insertable=false, updatable=false)
	private TCliente tCliente;
	
	@ManyToOne
	//@JoinColumn(name="id_metodo_envio", insertable=false, updatable=false)
	private TMetodoEnvio tMetodoEnvio;
	
	@ManyToOne
	//@JoinColumn(name = "id_producto", insertable=false, updatable=false)
	private TProducto tProducto;
	
	@OneToMany(mappedBy = "tPedido")
    private List<TCuenta> tCuenta;
	
	@OneToMany(mappedBy = "tPedido")
    private List<TDetallePedido> tDetallePedidos;
	
	@OneToMany(mappedBy = "tPedido")
    private List<TFactura> tFactura;
	
	@OneToMany(mappedBy = "tPedido")
    private List<TTracking> tTracking;

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
	
	

	
	
}
