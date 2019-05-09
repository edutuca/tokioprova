package br.com.tokiomarine.seguradora.aceitacao.prova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.tokiomarine.seguradora.aceitacao.prova.model.Produto;
import br.com.tokiomarine.seguradora.aceitacao.prova.repository.ProdutoRepository;
import br.com.tokiomarine.seguradora.aceitacao.prova.util.ProvaUtil;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> lista(){
		return ProvaUtil.analisaList(produtoRepository.findAll());
	}
	
	public Produto load(Long id) {
		return produtoRepository.getOne(id);
	}
	
	@Transactional
	public void update(Long id, Produto produto) {
		produto.setId(id);
		produtoRepository.saveAndFlush(produto);
	}
	
	@Transactional
	public void save(Produto produto) {
		produtoRepository.saveAndFlush(produto);
	}
	
	@Transactional
	public void remove(Long id) {
		produtoRepository.deleteById(id);
	}
}
