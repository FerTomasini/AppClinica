package com.example.appclinica.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserAuth implements UserDetails {

	public static final long serialVersionUID = 1L;
	private final Long id;
	private final String nome;
	private final String cpf;
	private final String username;
	private final String password;
	private final Collection<? extends GrantedAuthority> authorities;

	public UserAuth(Long id, String nome, String cpf, String username, String password, Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserAuth build(Usuario user, Collection<UsuarioTipo> tipos) {
		List<GrantedAuthority> authorities = tipos.stream()
		                                          .map(tipo -> new SimpleGrantedAuthority(tipo.getTipo().name()))
		                                          .collect(Collectors.toList());
		return new UserAuth(
				user.getId(),
				user.getNome(),
				user.getCpf(),
				user.getUsername(),
				user.getPassword(),
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		UserAuth user = (UserAuth) obj;
		return Objects.equals(id, user.id);
	}
}

