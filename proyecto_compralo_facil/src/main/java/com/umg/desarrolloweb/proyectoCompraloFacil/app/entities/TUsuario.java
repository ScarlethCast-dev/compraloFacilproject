package com.umg.desarrolloweb.proyectoCompraloFacil.app.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class TUsuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 30, unique = true)
	private String username;
	@Column(length = 65)
	private String password;
	private Boolean enabled;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_usuario")
	private List<TAuthorities> tAuthorities;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id")
	private TCliente cliente;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<TAuthorities> gettAuthorities() {
		return tAuthorities;
	}

	public void settAuthorities(List<TAuthorities> tAuthorities) {
		this.tAuthorities = tAuthorities;
	}

	public TCliente getCliente() {
		return cliente;
	}

	public void setCliente(TCliente cliente) {
		this.cliente = cliente;
	}



	private static final long serialVersionUID = 1L;

}
