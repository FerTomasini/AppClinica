package com.example.appclinica.security;

import javax.persistence.*;

@Entity
@Table(name = "usuario_tipo")
public class UsuarioTipo {

	@EmbeddedId
	private UsuarioTipoId id = new UsuarioTipoId();

	@ManyToOne(optional = false)
	@MapsId("usuarioId")
	@JoinColumn(name = "usuario_id", insertable = false, updatable = false)
	private Usuario usuario;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", insertable = false, updatable = false)
	private ETipo tipo;

	public UsuarioTipo() {
	}

	public UsuarioTipo(Usuario usuario, ETipo tipo) {
		this.id = new UsuarioTipoId(usuario.getId(), tipo);
		this.usuario = usuario;
		this.tipo = tipo;
	}

	public UsuarioTipoId getId() {
		return id;
	}

	public void setId(UsuarioTipoId id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ETipo getTipo() {
		return tipo;
	}

	public void setTipo(ETipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "UsuarioTipo{" +
				"Usuario=" + usuario +
				", tipo='" + tipo + '\'' +
				'}';
	}

}


