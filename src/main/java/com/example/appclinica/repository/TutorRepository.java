package com.example.appclinica.repository;

import com.example.appclinica.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {

	@Query("select p from Tutor p where upper(p.nome) like upper(concat('%', ?1, '%')) order by p.nome")
	List<Tutor> findByNomeContainsIgnoreCase(@Nullable String nome);

	@Query("select p from Tutor p where upper(p.nome) like upper(concat('%', ?1, '%')) order by p.nome")
	List<Tutor> findByNomeContainsIgnoreCaseOrderByNomeAsc(@Nullable String nome);
}

