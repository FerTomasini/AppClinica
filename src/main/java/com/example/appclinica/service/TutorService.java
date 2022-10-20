package com.example.appclinica.service;

import com.example.appclinica.exception.ValidacaoException;
import com.example.appclinica.model.Tutor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TutorService {

	List<Tutor> pesquisar(String query);

	Tutor buscar(Long id) throws ValidacaoException;

	Tutor salvar(Tutor tutor);

	void remover(Long id) throws ValidacaoException;
}
