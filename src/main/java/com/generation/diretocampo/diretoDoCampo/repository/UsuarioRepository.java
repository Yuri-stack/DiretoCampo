package com.generation.diretocampo.diretoDoCampo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.diretocampo.diretoDoCampo.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	public List<Usuario> findAllByEmailContainingIgnoreCase(String email);
}
