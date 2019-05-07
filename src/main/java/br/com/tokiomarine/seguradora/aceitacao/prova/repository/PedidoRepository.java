package br.com.tokiomarine.seguradora.aceitacao.prova.repository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.tokiomarine.seguradora.aceitacao.prova.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	@Query("select p from Pedido p where p.cliente.id = ?1")
	Stream<Pedido> listaPorCliente(Long id);
	
	@Query("select p from Pedido p where p.produto.id = ?1")
	Stream<Pedido> listaPorProduto(Long id);
}
