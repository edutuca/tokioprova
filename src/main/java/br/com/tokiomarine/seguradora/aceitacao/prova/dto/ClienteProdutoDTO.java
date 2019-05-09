package br.com.tokiomarine.seguradora.aceitacao.prova.dto;

import javax.validation.constraints.NotNull;

public class ClienteProdutoDTO {
	
	private Long id;
		
	@NotNull
	private Integer qtdPedido;
	
	private ProdutoDTO produto;
		
	private ClienteDTO cliente;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQtdPedido() {
		return qtdPedido;
	}

	public void setQtdPedido(Integer qtdPedido) {
		this.qtdPedido = qtdPedido;
	}

	public ProdutoDTO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}


	
}
