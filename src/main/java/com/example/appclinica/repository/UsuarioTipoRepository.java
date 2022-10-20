package com.example.appclinica.repository;

import com.example.appclinica.security.Usuario;
import com.example.appclinica.security.UsuarioTipo;
import com.example.appclinica.security.UsuarioTipoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioTipoRepository extends JpaRepository<UsuarioTipo, UsuarioTipoId> {

	List<UsuarioTipo> findAllByUsuario(Usuario usuario);

}