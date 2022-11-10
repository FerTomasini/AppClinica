package com.example.appclinica.service;

import com.example.appclinica.exception.ValidacaoException;
import com.example.appclinica.security.ETipo;
import com.example.appclinica.security.Usuario;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component
public interface UsuarioService {

	Usuario buscar(String username);

	List<Usuario> pesquisar(String query);

	Pair<Usuario, List<ETipo>> buscar(Long id) throws ValidacaoException;

	Usuario salvar(Usuario usuario) throws ValidacaoException;

	Pair<Usuario, List<ETipo>> salvar(Usuario usuario, List<ETipo> tipos) throws ValidacaoException;

}
