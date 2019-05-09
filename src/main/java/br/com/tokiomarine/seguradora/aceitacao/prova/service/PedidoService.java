package br.com.tokiomarine.seguradora.aceitacao.prova.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tokiomarine.seguradora.aceitacao.prova.model.Cliente;
import br.com.tokiomarine.seguradora.aceitacao.prova.model.Pedido;
import br.com.tokiomarine.seguradora.aceitacao.prova.model.Produto;
import br.com.tokiomarine.seguradora.aceitacao.prova.repository.PedidoRepository;
import br.com.tokiomarine.seguradora.aceitacao.prova.util.ProvaUtil;

@Service
public class PedidoService {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<Pedido> listaPorCliente(Long id){
		
		return ProvaUtil.analisaStream(pedidoRepository.listaPorCliente(id));
	}
	
	public List<Pedido> listaPorProduto(Long id) {
		return ProvaUtil.analisaStream(pedidoRepository.listaPorProduto(id));
	}
	
	@Transactional
	public void save(Pedido pedido) {
		
		Cliente cliente = clienteService.load(pedido.getCliente().getId());
		Produto produto = produtoService.load(pedido.getProduto().getId());
		
		pedido.setCliente(cliente);
		pedido.setProduto(produto);
		
		pedidoRepository.save(pedido);
	}
	
	@Transactional
	public void remove(Long id) {
		pedidoRepository.deleteById(id);
	}
}
