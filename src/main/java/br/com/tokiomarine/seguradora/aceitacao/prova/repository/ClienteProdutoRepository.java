package br.com.tokiomarine.seguradora.aceitacao.prova.repository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.tokiomarine.seguradora.aceitacao.prova.model.ClienteProduto;

public interface ClienteProdutoRepository extends JpaRepository<ClienteProduto, Long>{

	@Query("select cp from ClienteProduto cp where cp.cliente.id = ?1")
	Stream<ClienteProduto> listaPorCliente(Long id);
	
	@Query("select cp from ClienteProduto cp where cp.produto.id = ?1")
	Stream<ClienteProduto> listaPorProduto(Long id);
}
