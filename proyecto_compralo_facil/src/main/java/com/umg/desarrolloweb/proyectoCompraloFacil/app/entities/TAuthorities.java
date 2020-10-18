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
@Table(name="t_authorities")
public class TAuthorities extends AbstractEntity implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_authorities")
	private Long idAuthorities;
	
	private String authority;
	
	@Column(name = "id_usuario")
	private Long idUsuario;
	
	@ManyToOne
	@JoinColumn(name="id_usuario", insertable=false, updatable = false)
	private TUsuario tUsuario; //Recuperamos la informacion del usuario que tendra autoridad
	
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Long getIdAuthorities() {
		return idAuthorities;
	}

	public void setIdAuthorities(Long idAuthorities) {
		this.idAuthorities = idAuthorities;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
}
