package br.com.tokiomarine.seguradora.aceitacao.prova.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

@Entity
public class ClienteProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer qtdPedido;
	
	private LocalDateTime dtPedido;
	
	@ManyToOne(targetEntity=Cliente.class, optional=false)
	private Cliente cliente;
	
	@ManyToOne(targetEntity=Produto.class, optional=false)
	private Produto produto;

	
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

	public LocalDateTime getDtPedido() {
		return dtPedido;
	}

	public void setDtPedido(LocalDateTime dtPedido) {
		this.dtPedido = dtPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@PrePersist
	public void addDtPedido() {
		dtPedido = LocalDateTime.now();
	}
}
