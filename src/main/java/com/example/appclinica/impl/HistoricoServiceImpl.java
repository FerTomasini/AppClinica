package com.example.appclinica.impl;

import com.example.appclinica.exception.ValidacaoException;
import com.example.appclinica.model.Historico;
import com.example.appclinica.service.HistoricoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricoServiceImpl implements HistoricoService {

    @Override
    public List<Historico> pesquisar(String query) {
        return null;
    }

    @Override
    public Historico buscar(Long id) throws ValidacaoException {
        return null;
    }

    @Override
    public Historico salvar(Historico historico) {
        return null;
    }

    @Override
    public void remover(Long id) throws ValidacaoException {

    }
}
