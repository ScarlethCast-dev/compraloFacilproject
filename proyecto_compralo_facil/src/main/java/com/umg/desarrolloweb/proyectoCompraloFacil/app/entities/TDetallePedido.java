package com.umg.desarrolloweb.proyectoCompraloFacil.app.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_detalle_pedido")
public class TDetallePedido implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_detalle_pedido")
	private Long idDetallePedido;
	
	private String codigo;
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Column(name = "link_producto", length = 1000)
	private String linkProducto;
	
	@Column(name = "detalle_producto")
	private String detalleProducto;

	private Long precio;
	private Long cantidad;
	
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


	public Long getPrecio() {
		return precio;
	}

	public void setPrecio(Long precio) {
		this.precio = precio;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
		
}
