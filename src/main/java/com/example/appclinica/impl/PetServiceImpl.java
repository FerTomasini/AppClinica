package com.example.appclinica.impl;

import com.example.appclinica.exception.ValidacaoException;
import com.example.appclinica.model.Pet;
import com.example.appclinica.repository.PetRepository;
import com.example.appclinica.service.PetService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public List<Pet> pesquisar(String query) {
        return petRepository.findByNomeContainsOrUsernameContainsOrCpfContainsAllIgnoreCase(query);
    }

    @Override
    public Pet buscar(Long id) throws ValidacaoException {
        return petRepository.findByIdContaining(id);
    }

    @Override
    public Pet salvar(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public void remover(Long id) throws ValidacaoException {
        petRepository.deleteById(id);
    }
}
