package com.example.appclinica.response;

import com.example.appclinica.security.Usuario;

import java.util.List;

public class UsuarioTiposResponse {
	private Usuario usuario;
	private List<String> tipos;

	public UsuarioTiposResponse() {
	}

	public UsuarioTiposResponse(Usuario usuario, List<String> tipos) {
		this.usuario = usuario;
		this.tipos = tipos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<String> getTipos() {
		return tipos;
	}

	public void setTipos(List<String> tipos) {
		this.tipos = tipos;
	}
}
