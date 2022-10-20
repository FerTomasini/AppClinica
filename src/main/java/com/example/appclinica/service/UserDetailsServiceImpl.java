package com.example.appclinica.service;

import com.example.appclinica.repository.UsuarioRepository;
import com.example.appclinica.repository.UsuarioTipoRepository;
import com.example.appclinica.security.UserAuth;
import com.example.appclinica.security.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	final UsuarioRepository usuarioRepository;

	final UsuarioTipoRepository usuarioTipoRepository;

	public UserDetailsServiceImpl(UsuarioRepository usuarioRepository, UsuarioTipoRepository usuarioTipoRepository) {
		this.usuarioRepository = usuarioRepository;
		this.usuarioTipoRepository = usuarioTipoRepository;
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = usuarioRepository.findByUsername(username)
		                                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
		return UserAuth.build(user, usuarioTipoRepository.findAllByUsuario(user));
	}
}
