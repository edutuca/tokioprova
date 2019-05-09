package br.com.tokiomarine.seguradora.aceitacao.prova.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tokiomarine.seguradora.aceitacao.prova.configuration.ModelMapperCustom;
import br.com.tokiomarine.seguradora.aceitacao.prova.dto.ClienteDTO;
import br.com.tokiomarine.seguradora.aceitacao.prova.model.Cliente;
import br.com.tokiomarine.seguradora.aceitacao.prova.service.ClienteService;

@RestController()
@RequestMapping("/{versao}/")
@ResponseStatus(HttpStatus.OK)
public class ClienteController {
	
	@Autowired
	private ModelMapperCustom modelMapper;
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("clientes")
	public List<ClienteDTO> lista(){
		return modelMapper.mapCollection(clienteService.lista().stream(), ClienteDTO.class);
	}
	
	@DeleteMapping("cliente/{id}")
	public void delete(@PathVariable("id") Long id){
		clienteService.remove(id);
	}
	
	@GetMapping("cliente/{id}")
	public ClienteDTO load(@PathVariable("id") Long id){
		return modelMapper.map(clienteService.load(id),ClienteDTO.class);
	}

	@PostMapping("cliente")
	public void save(@Valid @RequestBody ClienteDTO cliente){
		clienteService.save(modelMapper.map(cliente, Cliente.class));
	}

	@PutMapping("cliente/{id}")
	public void update(@PathVariable("id") Long id, @Valid @RequestBody ClienteDTO cliente){
		clienteService.update(id, modelMapper.map(cliente, Cliente.class));
	}

}
