package br.com.tokiomarine.seguradora.aceitacao.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tokiomarine.seguradora.aceitacao.prova.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
