package br.com.tokiomarine.seguradora.aceitacao.prova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tokiomarine.seguradora.aceitacao.prova.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private PedidoRepository pedidoRepository;
}
