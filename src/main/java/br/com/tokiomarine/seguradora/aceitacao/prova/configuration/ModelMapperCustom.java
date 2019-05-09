package br.com.tokiomarine.seguradora.aceitacao.prova.configuration;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperCustom extends ModelMapper{
	
	public <T,C> List<C> mapCollection(Stream<T> stream, Class<C> classConvert){
		return stream.map(p->super.map(p, classConvert)).collect(Collectors.toList());
	}

}
