package com.example.appclinica.service;

import com.example.appclinica.exception.ValidacaoException;
import com.example.appclinica.model.CartVac;
import com.example.appclinica.model.Pet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CartVacService {

    List<CartVac> pesquisar(String query);

    CartVac buscar(Long id) throws ValidacaoException;

    CartVac salvar(CartVac cartao);

    void remover(Long id) throws ValidacaoException;
}
