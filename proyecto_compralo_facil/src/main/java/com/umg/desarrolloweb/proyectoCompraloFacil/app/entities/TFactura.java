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
	 
	 @Column(name = "id_cliente")
	 private Long idCliente;
	 
	 @Column(name = "id_pedido")
	 private Long idPedido;
	 
	 @ManyToOne
	 @JoinColumn(name="id_cliente", insertable = false, updatable = false)
	 private TCliente tCliente;
	 
	 @ManyToOne
	 @JoinColumn(name="id_pedido", insertable = false, updatable = false)
	 private TPedido tPedido;

	 @OneToMany(mappedBy = "tFactura")
	 private List<TDetalleFactura> tDetalleFactura;
	 

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

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	 
	 
		
		
}
