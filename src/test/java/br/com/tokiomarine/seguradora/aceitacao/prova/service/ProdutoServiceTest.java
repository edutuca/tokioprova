package br.com.tokiomarine.seguradora.aceitacao.prova.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.tokiomarine.seguradora.aceitacao.prova.model.Produto;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProdutoServiceTest {
	private static final Long ID_PRODUTO = 1l;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Test
	public void loadTest() {
		assertNotNull(produtoService.load(ID_PRODUTO));		
	}

	@Test
	@Ignore
	@Commit 
	public void saveTest() {

		Produto produto = new Produto();
		produto.setPreco(56D);
		produto.setProduto("Cerveja");
		produtoService.save(produto);	
		
		assertTrue(true);
	}
	
	@Test
	public void listaTest(){
		assertTrue(!produtoService.lista().isEmpty());
	}
	
	@Test
	@Commit
	public void updateTest() {
		Produto produto = produtoService.load(ID_PRODUTO);
		produto.setPreco(89.5D);
		produto.setProduto("Pinga");

		produtoService.update(produto.getId(),produto);	

		assertTrue(true);
	}

	@Test
	@Ignore
	@Commit
	public void removeTest() {
		produtoService.remove(ID_PRODUTO);
		assertTrue(true);
	}
}
