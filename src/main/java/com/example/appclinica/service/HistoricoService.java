package com.example.appclinica.service;

import com.example.appclinica.exception.ValidacaoException;
import com.example.appclinica.model.Historico;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HistoricoService {

    List<Historico> pesquisar(String query);

    Historico buscar(Long id) throws ValidacaoException;

    Historico salvar(Historico historico);

    void remover(Long id) throws ValidacaoException;
}