package com.umg.desarrolloweb.proyectoCompraloFacil.app.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private Long idDetalleCompra;
	private Long cantidad;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="id_producto")
	private TProducto tproducto;
	
	
	public Long getIdDetalleCompra() {
		return idDetalleCompra;
	}

	public void setIdDetalleCompra(Long idDetalleCompra) {
		this.idDetalleCompra = idDetalleCompra;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	public Double calcularImporte(){ //calcular el importe de cada item, esto se hara multiplicando la cantidad por el precio 
		return cantidad.doubleValue()*tproducto.getPrecio();
	}
	
	
}
