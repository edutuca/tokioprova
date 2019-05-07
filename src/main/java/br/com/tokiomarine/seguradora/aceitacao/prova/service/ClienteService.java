package br.com.tokiomarine.seguradora.aceitacao.prova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.tokiomarine.seguradora.aceitacao.prova.model.Cliente;
import br.com.tokiomarine.seguradora.aceitacao.prova.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> lista(){
		return clienteRepository.findAll();
	}
	
	public Cliente load(Long id) {
		return clienteRepository.getOne(id);
	}
	
	@Transactional
	public void update(Cliente cliente) {
		clienteRepository.saveAndFlush(cliente);
	}
	
	@Transactional
	public void save(Cliente cliente) {
		clienteRepository.saveAndFlush(cliente);
	}
	
	@Transactional
	public void remove(Long id) {
		clienteRepository.deleteById(id);
	}
}
