package com.generation.diretocampo.diretoDoCampo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity							
@Table(name = "tb_compra")		
public class Compra {

	@Id													
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;									
	
	@ManyToOne
	private Produto produto;
	
	@ManyToOne
	private Usuario usuario;
	
	@NotNull
	@Size(max = 10, message = "Valor minimo de 1 caracter e máximo 10")
	private float precoTotal;
	
	@NotNull
	@Size(max = 4, message = "Valor minimo de 1 caracter e máximo 4")
	private float quantidade;
	
	@NotBlank
	private boolean status;		// Vendido ou não

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public float getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(float precoTotal) {
		this.precoTotal = precoTotal;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
