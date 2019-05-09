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
import br.com.tokiomarine.seguradora.aceitacao.prova.dto.ProdutoDTO;
import br.com.tokiomarine.seguradora.aceitacao.prova.model.Produto;
import br.com.tokiomarine.seguradora.aceitacao.prova.service.ProdutoService;

@RestController()
@RequestMapping("/{versao}/")
@ResponseStatus(HttpStatus.OK)
public class ProdutoController {
	
	@Autowired
	private ModelMapperCustom modelMapper;
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("produtos")
	public List<ProdutoDTO> lista(){
		return modelMapper.mapCollection(produtoService.lista().stream(), ProdutoDTO.class);
	}
	
	@DeleteMapping("produto/{id}")
	public void delete(@PathVariable("id") Long id){
		produtoService.remove(id);
	}
	
	@GetMapping("produto/{id}")
	public ProdutoDTO load(@PathVariable("id") Long id){
		return modelMapper.map(produtoService.load(id),ProdutoDTO.class);
	}

	@PostMapping("produto")
	public void save(@Valid @RequestBody ProdutoDTO produto){
		produtoService.save(modelMapper.map(produto, Produto.class));
	}

	@PutMapping("produto/{id}")
	public void update(@PathVariable("id") Long id, @Valid @RequestBody ProdutoDTO produto){
		produtoService.update(id, modelMapper.map(produto, Produto.class));
	}

}
