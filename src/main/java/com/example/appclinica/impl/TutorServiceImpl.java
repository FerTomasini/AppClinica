package com.example.appclinica.impl;

import com.example.appclinica.exception.ValidacaoException;
import com.example.appclinica.model.Tutor;
import com.example.appclinica.repository.EnderecoRepository;
import com.example.appclinica.repository.PetRepository;
import com.example.appclinica.repository.TutorRepository;
import com.example.appclinica.service.TutorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;

@Service
public class TutorServiceImpl implements TutorService {

	private final TutorRepository tutorRepository;
	private final EnderecoRepository enderecoRepository;
	private final PetRepository petRepository;

	public TutorServiceImpl(TutorRepository tutorRepository, EnderecoRepository enderecoRepository, PetRepository petRepository) {
		this.tutorRepository = tutorRepository;
		this.enderecoRepository = enderecoRepository;
		this.petRepository = petRepository;
	}

	@Override
	public List<Tutor> pesquisar(String query) {
		return tutorRepository.findByNomeContainsIgnoreCase(query);
	}

	@Override
	public Tutor buscar(Long id) throws ValidacaoException {
		return tutorRepository.findById(id).orElseThrow(() -> new ValidacaoException("Cadastro não encontrado."));
	}

	@Transactional
	@Override
	public Tutor salvar(@Valid Tutor tutor) {
		tutor.setEndereco(this.enderecoRepository.save(tutor.getEndereco()));
		tutor.setPet(this.petRepository.save(tutor.getPet()));
		return tutorRepository.save(tutor);
	}

	@Transactional
	@Override
	public void remover(Long id) throws ValidacaoException {
		Tutor tutor = buscar(id);
		if (tutor != null) {
			if (tutor.getNome() != null && tutor.getId() != null) {
				tutorRepository.delete(tutor);
			}
			tutorRepository.delete(tutor);
		}
	}
}