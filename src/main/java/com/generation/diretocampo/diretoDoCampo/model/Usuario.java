package com.generation.diretocampo.diretoDoCampo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(max = 50, message = "Valor minimo de 1 caracter e máximo 50")
	private String nome;
	
	@NotNull
	@Size(max = 50, message = "Valor minimo de 1 caracter e máximo 50")
	private String email;
	
	@NotNull
	@Size(max = 10, message = "Valor minimo de 1 caracter e máximo 10")
	private String senha;
	
	@NotNull
	@Size(max = 9, message = "Valor minimo de 1 caracter e máximo 9")
	private String cep;
	
	@NotNull
	@Size(max = 20, message = "Valor minimo de 1 caracter e máximo 20")
	private String tipo; 			// Produtor, Consumidor, Ponto de Revenda ou Admin
	
	@NotBlank					// Não aceita Nulo ou " "
	private String imagem;
	
	@OneToMany (mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Produto> produto;
	
	@OneToMany (mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Compra> compra;

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public String getCep() {
		return cep;
	}

	public String getTipo() {
		return tipo;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public List<Compra> getCompra() {
		return compra;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public void setCompra(List<Compra> compra) {
		this.compra = compra;
	}
}
