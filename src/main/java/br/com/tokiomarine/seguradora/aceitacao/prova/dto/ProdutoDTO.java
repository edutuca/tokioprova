package br.com.tokiomarine.seguradora.aceitacao.prova.dto;

import java.util.Date;

public class ProdutoDTO {
	
	private Long id;
	
	private String produto;
	
	private Double preco;
	
	private Date dtIncls;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Date getDtIncls() {
		return dtIncls;
	}

	public void setDtIncls(Date dtIncls) {
		this.dtIncls = dtIncls;
	}
	
	
}
