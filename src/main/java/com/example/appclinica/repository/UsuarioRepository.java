package com.example.appclinica.repository;

import com.example.appclinica.security.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByUsername(String username);

	@Query("""
			select u from Usuario u
			where upper(u.nome) like upper(concat('%', ?1, '%'))
			or upper(u.username) like upper(concat('%', ?1, '%'))
			or upper(u.cpf) like upper(concat('%', ?1, '%'))""")
	List<Usuario> findByNomeContainsOrUsernameContainsOrCpfContainsAllIgnoreCase(@Nullable String query);

}
