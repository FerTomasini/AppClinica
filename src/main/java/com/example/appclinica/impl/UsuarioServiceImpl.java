package com.example.appclinica.impl;

import com.example.appclinica.exception.ValidacaoException;
import com.example.appclinica.repository.UsuarioRepository;
import com.example.appclinica.repository.UsuarioTipoRepository;
import com.example.appclinica.security.ETipo;
import com.example.appclinica.security.Usuario;
import com.example.appclinica.security.UsuarioTipo;
import com.example.appclinica.service.UsuarioService;
import org.springframework.data.util.Pair;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioTipoRepository usuarioTipoRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, UsuarioTipoRepository usuarioTipoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioTipoRepository = usuarioTipoRepository;
    }

    @Override
    public Usuario buscar(String username) {
        return this.usuarioRepository.findByUsername(username).orElse(null);
    }

    @Override
    public List<Usuario> pesquisar(String query) {
        return usuarioRepository.findByNomeContainsOrUsernameContainsOrCpfContainsAllIgnoreCase(query);
    }

    @Override
    public Pair<Usuario, List<ETipo>> buscar(Long id) throws ValidacaoException {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ValidacaoException("Cadastro nÃ£o encontrado."));
        return Pair.of(usuario, usuarioTipoRepository.findAllByUsuario(usuario)
                .stream()
                .map(UsuarioTipo::getTipo)
                .toList());
    }

    @Transactional
    @Override
    public Usuario salvar(@Valid Usuario usuario) throws ValidacaoException {
        Optional<Usuario> pUser = usuarioRepository.findByUsername(usuario.getUsername());
        if (pUser.isEmpty() || Objects.equals(pUser.get().getId(), usuario.getId())) {
            if (pUser.isEmpty()) {
                usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
            }
            return usuarioRepository.save(usuario);
        } else {
            throw new ValidacaoException("Nome de usuÃ¡rio jÃ¡ utilizado.");
        }
    }

    @Transactional
    @Override
    public Pair<Usuario, List<ETipo>> salvar(@Valid Usuario usuario, List<ETipo> tipos) throws ValidacaoException {
        Usuario usuarioP = this.salvar(usuario);
        usuarioTipoRepository.deleteAll(usuarioTipoRepository.findAllByUsuario(usuarioP)
                .stream()
                .filter(ut -> !tipos.contains(ut.getTipo()))
                .collect(Collectors.toList()));

        return Pair.of(usuarioP, usuarioTipoRepository.saveAll(tipos.stream()
                        .map(t -> new UsuarioTipo(usuarioP, t))
                        .collect(Collectors.toList()))
                .stream()
                .map(UsuarioTipo::getTipo)
                .toList());
    }
}
