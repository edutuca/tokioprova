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
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private Integer idade;
	
	private String cpf;
	
	private String endereco;
	
	private String cep;
	
	private LocalDateTime dtInclsAlt;

	@OneToMany(mappedBy="cliente", fetch=FetchType.LAZY)
	private List<ClienteProduto> clienteProduto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	
	public List<ClienteProduto> getClienteProduto() {
		return clienteProduto;
	}

	public void setClienteProduto(List<ClienteProduto> clienteProduto) {
		this.clienteProduto = clienteProduto;
	}

	public LocalDateTime getDtInclsAlt() {
		return dtInclsAlt;
	}

	public void setDtInclsAlt(LocalDateTime dtInclsAlt) {
		this.dtInclsAlt = dtInclsAlt;
	}

	@PrePersist
	@PreUpdate
	public void addDtInclsAlt() {
		dtInclsAlt = LocalDateTime.now();
	}
	
}
