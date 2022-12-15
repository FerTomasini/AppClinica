package com.example.appclinica.service;

import com.example.appclinica.exception.ValidacaoException;
import com.example.appclinica.model.Pet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PetService {

	List<Pet> pesquisar(String query);

	List<Pet> getAllPets();

	Pet buscar(Long id) throws ValidacaoException;

	Pet salvar(Pet pet);

	void remover(Long id) throws ValidacaoException;
}
