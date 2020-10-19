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
@Table(name = "t_detalle_factura")
public class TDetalleFactura extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_detalle_factura")
	private Long idDetalleFactura;
	private BigDecimal precio;
	
	private Long cantidad;
	
	@Column(name = "descripcion_producto")
	private Long descripcionProducto;
	
	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	@Column(name = "id_factura")
	private Long idFactura;
	
	@ManyToOne
	@JoinColumn(name="id_factura", insertable = false, updatable = false)
	private TFactura tFactura;

	public Long getIdDetalleFactura() {
		return idDetalleFactura;
	}

	public void setIdDetalleFactura(Long idDetalleFactura) {
		this.idDetalleFactura = idDetalleFactura;
	}

	public Long getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(Long descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Long getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}
	
	
}
