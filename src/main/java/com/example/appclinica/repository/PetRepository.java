package com.example.appclinica.repository;

import com.example.appclinica.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

	Pet findByIdContaining(Long id);

    @Query("""
			select u from Usuario u
			where upper(u.nome) like upper(concat('%', ?1, '%'))
			or upper(u.username) like upper(concat('%', ?1, '%'))
			or upper(u.cpf) like upper(concat('%', ?1, '%'))""")
    List<Pet> findByNomeContainsOrUsernameContainsOrCpfContainsAllIgnoreCase(@Nullable String query);
}
