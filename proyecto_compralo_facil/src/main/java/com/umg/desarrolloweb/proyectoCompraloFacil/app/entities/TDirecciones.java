package com.umg.desarrolloweb.proyectoCompraloFacil.app.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_direcciones")
public class TDirecciones extends AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_direcciones")
	private Long idDirecciones;
	
	@Column(name = "desc_direccion")
	private String descDireccion;
	
	@Column(name = "codigo_postal")
	private String codigoPostal;
	
	@Column(name = "cliente_id")
	private String idCliente;
	
	@Column(name = "municipio_id")
	private String idMunicipio;
	
	@Column(name = "departamento_id")
	private String idDepartamento;
	
	
	@ManyToOne
	@JoinColumn(name="cliente_id", insertable = false, updatable = false)
	private TCliente tCliente;
	
	@ManyToOne
	@JoinColumn(name="municipio_id", insertable = false, updatable = false)
	private TMunicipio tMunicipio;
	
	@ManyToOne
	@JoinColumn(name="departamento_id", insertable = false, updatable = false)
	private TDepartamento tDepartamento;
	
	
	

	public Long getIdDirecciones() {
		return idDirecciones;
	}

	public void setIdDirecciones(Long idDirecciones) {
		this.idDirecciones = idDirecciones;
	}

	public String getDescDireccion() {
		return descDireccion;
	}

	public void setDescDireccion(String descDireccion) {
		this.descDireccion = descDireccion;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(String idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public String getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(String idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	
	
	
	
	
	
	
	

}
