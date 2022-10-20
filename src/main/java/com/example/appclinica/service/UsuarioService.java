package com.example.appclinica.service;


import br.com.metaway.agendapessoal.exception.ValidacaoException;
import br.com.metaway.agendapessoal.security.ETipo;
import br.com.metaway.agendapessoal.security.Usuario;
import org.springframework.data.util.Pair;

import java.util.List;

public interface UsuarioService {

	Usuario buscar(String username);

	List<Usuario> pesquisar(String query);

	Pair<Usuario, List<ETipo>> buscar(Long id) throws ValidacaoException;

	Usuario salvar(Usuario usuario) throws ValidacaoException;

	Pair<Usuario, List<ETipo>> salvar(Usuario usuario, List<ETipo> tipos) throws ValidacaoException;

}
