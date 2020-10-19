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
@Table(name="t_cuenta")
public class TCuenta extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cuenta")
	private Long idCuenta;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date fecha;
	
	@Column(name = "id_pedido")
	private Long idPedido;
	
	@Column(name = "id_estado_cuenta")
	private Long idEstadoCuenta;
	
	@ManyToOne
	@JoinColumn(name="id_pedido", insertable = false, updatable = false)
	private TPedido tPedido;
	
	@ManyToOne
	@JoinColumn(name="id_estado_cuenta", insertable = false, updatable = false)
	private TEstadoCuenta tEstadoCuenta;
	
	@OneToMany(mappedBy = "tCliente")
    private List<TListaDeseos>tListaDeseo;
   
    @OneToMany(mappedBy = "tCliente")
    private List<THistorial>tHistorial;
	
	public Long getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Long idCuenta) {
		this.idCuenta = idCuenta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Long getIdEstadoCuenta() {
		return idEstadoCuenta;
	}

	public void setIdEstadoCuenta(Long idEstadoCuenta) {
		this.idEstadoCuenta = idEstadoCuenta;
	}
	
	
	 
}
