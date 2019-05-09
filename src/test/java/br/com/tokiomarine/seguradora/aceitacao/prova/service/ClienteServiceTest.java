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

import br.com.tokiomarine.seguradora.aceitacao.prova.model.Cliente;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ClienteServiceTest {
	
	private static final Long ID_CLIENTE = 6l;
	
	@Autowired
	private ClienteService clienteService;
	
	@Test
	public void loadTest() {
		assertNotNull(clienteService.load(ID_CLIENTE));		
	}

	@Test
	@Commit 
	public void saveTest() {

		Cliente cliente = new Cliente();
		cliente.setCep("05145-000");
		cliente.setCpf("226.598.459-08");
		cliente.setEndereco("XXXXXXXXXXXXx");
		cliente.setIdade(43);
		cliente.setNome("Tokio Marine Seguradora");
		
		clienteService.save(cliente);	
		assertTrue(true);
	}
	
	@Test
	public void listaTest(){
		assertTrue(!clienteService.lista().isEmpty());
	}
	
	@Test
	@Ignore
	@Commit
	public void updateTest() {
		Cliente cliente = clienteService.load(ID_CLIENTE);
		cliente.setCep("05145-000");
		cliente.setCpf("226.598.459-08");
		cliente.setEndereco("CCCCCCCCCCCCCCCCC");
		cliente.setIdade(43);
		cliente.setNome("Tokio Marine Seguradora");
		
		clienteService.update(0l,cliente);	

		assertTrue(true);
	}

	@Test
	@Ignore
	@Commit
	public void removeTest() {
		clienteService.remove(ID_CLIENTE);
		assertTrue(true);
	}
}
