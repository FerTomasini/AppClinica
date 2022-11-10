package com.example.appclinica.impl;

import com.example.appclinica.exception.ValidacaoException;
import com.example.appclinica.model.Pet;
import com.example.appclinica.service.PetService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PetServiceImpl implements PetService {
    @Override
    public List<Pet> pesquisar(String query) {
        return null;
    }

    @Override
    public Pet buscar(Long id) throws ValidacaoException {
        return null;
    }

    @Override
    public Pet salvar(Pet pet) {
        return null;
    }

    @Override
    public void remover(Long id) throws ValidacaoException {

    }
}
