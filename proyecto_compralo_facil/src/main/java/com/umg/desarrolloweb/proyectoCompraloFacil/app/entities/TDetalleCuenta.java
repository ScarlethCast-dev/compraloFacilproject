package com.umg.desarrolloweb.proyectoCompraloFacil.app.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_detalle_cliente")
public class TDetalleCuenta extends AbstractEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_detalle_pago")
	private Long idDetallePago;
	
	private String descripcion;
	private Long monto;
	
	@Column(name = "id_cuenta")
	private Long idCuenta;
	
	@Column(name = "id_metodo_pago")
	private Long idMetodoPago;

	public Long getIdDetallePago() {
		return idDetallePago;
	}

	public void setIdDetallePago(Long idDetallePago) {
		this.idDetallePago = idDetallePago;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getMonto() {
		return monto;
	}

	public void setMonto(Long monto) {
		this.monto = monto;
	}

	public Long getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Long idCuenta) {
		this.idCuenta = idCuenta;
	}

	public Long getIdMetodoPago() {
		return idMetodoPago;
	}

	public void setIdMetodoPago(Long idMetodoPago) {
		this.idMetodoPago = idMetodoPago;
	}
	
	

	
	

}
