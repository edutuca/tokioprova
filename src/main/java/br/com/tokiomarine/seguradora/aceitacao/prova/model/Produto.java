package br.com.tokiomarine.seguradora.aceitacao.prova.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.tokiomarine.seguradora.aceitacao.prova.service.PedidoService;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String produto;
	
	private Double preco;
	
	private Date dtIncls;
	
	@OneToMany(mappedBy="pedido")
	private List<Pedido> pedidos;

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

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	

}
