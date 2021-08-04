package com.generation.diretocampo.diretoDoCampo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity							
@Table(name = "tb_compra")		
public class Compra {

	@Id													
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;		
		
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Usuario usuario;
	
	@ManyToOne
	@JsonIgnoreProperties("usuario")
	private Produto produto;
					
	@NotNull(message = "Esse campo não pode ser nulo")
	private float precoTotal;
	
	@UpdateTimestamp
	private LocalDate dataCompra;
	
	@NotNull(message = "Esse campo não pode ser nulo")
	private float quantidade;
	
	@NotNull
	private boolean status;		// Vendido ou não

	public long getId() {
		return id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Produto getProduto() {
		return produto;
	}

	public float getPrecoTotal() {
		return precoTotal;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public boolean isStatus() {
		return status;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setPrecoTotal(float precoTotal) {
		this.precoTotal = precoTotal;
	}

	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
