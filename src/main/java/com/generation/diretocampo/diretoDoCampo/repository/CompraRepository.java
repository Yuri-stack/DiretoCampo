package com.generation.diretocampo.diretoDoCampo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.diretocampo.diretoDoCampo.model.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long>{
	public List<Compra> findAllByUsuarioId(long id);
}
