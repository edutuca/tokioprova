package br.com.tokiomarine.seguradora.aceitacao.prova.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tokiomarine.seguradora.aceitacao.prova.configuration.ModelMapperCustom;
import br.com.tokiomarine.seguradora.aceitacao.prova.dto.ClienteProdutoDTO;
import br.com.tokiomarine.seguradora.aceitacao.prova.model.ClienteProduto;
import br.com.tokiomarine.seguradora.aceitacao.prova.service.ClienteProdutoService;

@RestController()
@RequestMapping("/{versao}/")
public class PedidoController {
	
	@Autowired
	private ModelMapperCustom modelMapper;
	
	@Autowired
	private ClienteProdutoService clienteProdutoService;
	
	@GetMapping("cliente/{idClien}/pedido")
	public List<ClienteProdutoDTO> listaPorCliente(@PathVariable("idClien") Long idClien){
		return modelMapper.mapCollection(clienteProdutoService.listaPorCliente(idClien).stream(), ClienteProdutoDTO.class);
	}
	
	@GetMapping("produto/{idProd}/pedido")
	public List<ClienteProdutoDTO> listaPorProduto(@PathVariable("idProd") Long idProd){
		return modelMapper.mapCollection(clienteProdutoService.listaPorProduto(idProd).stream(), ClienteProdutoDTO.class);
	}
	
	@PostMapping("pedido")
	public void save(@Valid @RequestBody ClienteProdutoDTO pedidoDTO){
		clienteProdutoService.save(modelMapper.map(pedidoDTO, ClienteProduto.class));
	}
	
	@DeleteMapping("pedido/{id}")
	public void delete(@PathVariable Long id){
		clienteProdutoService.remove(id);
	}
}
