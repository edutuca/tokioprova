package br.com.tokiomarine.seguradora.aceitacao.prova.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tokiomarine.seguradora.aceitacao.prova.model.Cliente;
import br.com.tokiomarine.seguradora.aceitacao.prova.model.ClienteProduto;
import br.com.tokiomarine.seguradora.aceitacao.prova.model.Produto;
import br.com.tokiomarine.seguradora.aceitacao.prova.repository.PedidoRepository;
import br.com.tokiomarine.seguradora.aceitacao.prova.util.ProvaUtil;

@Service
public class ClienteProdutoService {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<ClienteProduto> listaPorCliente(Long id){
		
		return ProvaUtil.analisaStream(pedidoRepository.listaPorCliente(id));
	}
	
	public List<ClienteProduto> listaPorProduto(Long id) {
		return ProvaUtil.analisaStream(pedidoRepository.listaPorProduto(id));
	}
	
	@Transactional
	public void save(ClienteProduto clienteProduto) {
		
		Cliente cliente = clienteService.load(clienteProduto.getCliente().getId());
		Produto produto = produtoService.load(clienteProduto.getProduto().getId());
		
		clienteProduto.setCliente(cliente);
		clienteProduto.setProduto(produto);
		
		pedidoRepository.save(clienteProduto);
	}
	
	@Transactional
	public void remove(Long id) {
		pedidoRepository.deleteById(id);
	}
}
