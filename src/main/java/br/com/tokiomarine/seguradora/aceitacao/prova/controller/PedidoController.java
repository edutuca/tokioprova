package br.com.tokiomarine.seguradora.aceitacao.prova.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tokiomarine.seguradora.aceitacao.prova.configuration.ModelMapperCustom;
import br.com.tokiomarine.seguradora.aceitacao.prova.dto.PedidoDTO;
import br.com.tokiomarine.seguradora.aceitacao.prova.model.Pedido;
import br.com.tokiomarine.seguradora.aceitacao.prova.service.PedidoService;

@RestController()
@RequestMapping("/{versao}/")
@ResponseStatus(HttpStatus.OK)
public class PedidoController {
	
	@Autowired
	private ModelMapperCustom modelMapper;
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping("cliente/{idClien}/pedido")
	public List<PedidoDTO> listaPorCliente(@PathVariable("idClien") Long idClien){
		return modelMapper.mapCollection(pedidoService.listaPorCliente(idClien).stream(), PedidoDTO.class);
	}
	
	@GetMapping("produto/{idProd}/pedido")
	public List<PedidoDTO> listaPorProduto(@PathVariable("idProd") Long idProd){
		return modelMapper.mapCollection(pedidoService.listaPorProduto(idProd).stream(), PedidoDTO.class);
	}
	
	@PostMapping("pedido")
	public void save(@Valid @RequestBody PedidoDTO pedidoDTO){
		pedidoService.save(modelMapper.map(pedidoDTO, Pedido.class));
	}
	
	@DeleteMapping("pedido/{id}")
	public void delete(@PathVariable Long id){
		pedidoService.remove(id);
	}
}
