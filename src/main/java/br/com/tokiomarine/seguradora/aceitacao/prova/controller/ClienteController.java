package br.com.tokiomarine.seguradora.aceitacao.prova.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tokiomarine.seguradora.aceitacao.prova.dto.ClienteDTO;
import br.com.tokiomarine.seguradora.aceitacao.prova.model.Cliente;
import br.com.tokiomarine.seguradora.aceitacao.prova.service.ClienteService;

@RestController("${versao}/")
@ResponseStatus(HttpStatus.OK)
public class ClienteController {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("clientes")
	public List<Cliente> lista(){
		return clienteService.lista();
	}
	
	@DeleteMapping("cliente/${id}")
	public void delete(@PathVariable("id") Long id){
		clienteService.remove(id);
	}
	
	@GetMapping("cliente/${id}")
	public Cliente load(@PathVariable("id") Long id){
		return clienteService.load(id);
	}

	@PostMapping("cliente")
	public void save(@RequestBody ClienteDTO cliente){
		clienteService.save(modelMapper.map(cliente, Cliente.class));
	}

	@PutMapping("cliente")
	public void update(@RequestBody ClienteDTO cliente){
		clienteService.update(modelMapper.map(cliente, Cliente.class));
	}

}
