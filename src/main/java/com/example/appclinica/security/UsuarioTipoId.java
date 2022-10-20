package com.example.appclinica.security;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UsuarioTipoId implements Serializable {

	@Column(name = "usuario_id")
	private Long usuarioId;

	@Enumerated(EnumType.STRING)
	private ETipo tipo;

	public UsuarioTipoId() {
	}

	public UsuarioTipoId(Long usuarioId, ETipo tipo) {
		this.usuarioId = usuarioId;
		this.tipo = tipo;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public ETipo getTipo() {
		return tipo;
	}

	public void setTipo(ETipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UsuarioTipoId that = (UsuarioTipoId) o;
		return Objects.equals(usuarioId, that.usuarioId) && tipo == that.tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(usuarioId, tipo);
	}
}


