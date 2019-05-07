package br.com.tokiomarine.seguradora.aceitacao.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tokiomarine.seguradora.aceitacao.prova.model.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
