package br.com.tokiomarine.seguradora.aceitacao.prova.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String produto;
	
	private Double preco;
	
	private LocalDateTime dtInclsAlt;
	
	@OneToMany(mappedBy="produto",fetch=FetchType.LAZY)
	private List<ClienteProduto> clienteProduto;

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

	public LocalDateTime getDtInclsAlt() {
		return dtInclsAlt;
	}

	public void setDtInclsAlt(LocalDateTime dtInclsAlt) {
		this.dtInclsAlt = dtInclsAlt;
	}


	public List<ClienteProduto> getClienteProduto() {
		return clienteProduto;
	}

	public void setClienteProduto(List<ClienteProduto> clienteProduto) {
		this.clienteProduto = clienteProduto;
	}

	@PrePersist
	@PreUpdate
	public void addDtInclsAlt() {
		dtInclsAlt = LocalDateTime.now();
	}
	
	

}
