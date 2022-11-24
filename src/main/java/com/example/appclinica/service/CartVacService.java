package com.example.appclinica.service;

import com.example.appclinica.exception.ValidacaoException;
import com.example.appclinica.model.CartVac;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CartVacService {

    CartVac buscar(Long id) throws ValidacaoException;

    CartVac salvar(CartVac cartao);

    void remover(Long id) throws ValidacaoException;
}
