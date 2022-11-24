package com.example.appclinica.impl;

import com.example.appclinica.exception.ValidacaoException;
import com.example.appclinica.model.CartVac;
import com.example.appclinica.model.Pet;
import com.example.appclinica.repository.CartVacRepository;
import com.example.appclinica.service.CartVacService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;

@Service
public class CartVacServiceImpl implements CartVacService {

    private final CartVacRepository cartaoRepository;

    public CartVacServiceImpl(CartVacRepository cartaoRepository) {
        this.cartaoRepository = cartaoRepository;
    }


    @Override
    public CartVac buscar(Long id) throws ValidacaoException {
        return cartaoRepository.findById(id).orElseThrow(() -> new ValidacaoException("Cadastro não encontrado."));
    }

    @Override
    public CartVac salvar(@Valid CartVac cartao) {
        return cartaoRepository.save(cartao);
    }

    @Override
    public void remover(Long id) throws ValidacaoException {

    }
}
