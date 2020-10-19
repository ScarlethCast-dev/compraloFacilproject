package com.umg.desarrolloweb.proyectoCompraloFacil.app.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_detalle_pedido")
public class TDetallePedido extends AbstractEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_detalle_pedido")
	private Long idDetallePedido;
	
	@Column(name = "link_producto")
	private String linkProducto;
	
	@Column(name = "detalle_producto")
	private String detalleProducto;

	private BigDecimal precio;
	private Long cantidad;
	
	@Column(name = "id_pedido")
	private String idPedido;
	
	@ManyToOne
	@JoinColumn(name="id_pedido", insertable = false, updatable = false)
	private TPedido tPedido;

	public Long getIdDetallePedido() {
		return idDetallePedido;
	}

	public void setIdDetallePedido(Long idDetallePedido) {
		this.idDetallePedido = idDetallePedido;
	}

	public String getLinkProducto() {
		return linkProducto;
	}

	public void setLinkProducto(String linkProducto) {
		this.linkProducto = linkProducto;
	}

	public String getDetalleProducto() {
		return detalleProducto;
	}

	public void setDetalleProducto(String detalleProducto) {
		this.detalleProducto = detalleProducto;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	public String getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(String idPedido) {
		this.idPedido = idPedido;
	}
	
	
	
	
}
