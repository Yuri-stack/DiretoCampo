package com.generation.diretocampo.diretoDoCampo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.generation.diretocampo.diretoDoCampo.model.Produto;
import com.generation.diretocampo.diretoDoCampo.repository.ProdutoRepository;

@RestController						// Anotação que declara que esta classe é um Controlador Rest (Controller)
@RequestMapping("/produtos")		// Rota/URL/Caminho padrão para esse Controller
public class ProdutoController {
	
	// Injetando/Importando o Repositorio desse Controller
	@Autowired	
	private ProdutoRepository repository;
	
	// Rota que é acessada quando queremos BUSCAR todos produtos
	@GetMapping
	public ResponseEntity<List<Produto>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	// Rota que é acessada quando queremos BUSCAR um produto pelo ID
	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable long id){
		return repository.findById(id).map(produto -> ResponseEntity.ok(produto))
				.orElse(ResponseEntity.notFound().build());
	}
	
	// Rota que é acessada quando queremos BUSCAR todos produtos com certo Nome
	@GetMapping("/produto/{nome}")	
	public ResponseEntity<List<Produto>> getById(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	// Rota que é acessada quando queremos CADASTRAR um novo Produto
	@PostMapping
	public ResponseEntity<Produto> post(@Valid @RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(produto));
	}
	
	// Rota que é acessada quando queremos ATUALIZAR um Produto
	@PutMapping
	public ResponseEntity<Produto> put(@Valid @RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.OK)
				.body(repository.save(produto));
	}
	
	// Rota que é acessada quando queremos APAGAR um Produto
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}	
}
