package br.com.tokiomarine.seguradora.aceitacao.prova.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.tokiomarine.seguradora.aceitacao.prova.exception.NoContentException;

public class ProvaUtil {

	public static <T> List<T> analisaStream(Stream<T> stream) {
		
		try (Stream<T> dados = stream){
			
			List<T> lista = dados.collect(Collectors.toList());
			
			lancaNoContentCasoVazio(lista);
			
			return lista;
		}
	}

	public static <T> List<T> analisaList(List<T> lista) {

		lancaNoContentCasoVazio(lista);
			
		return lista;
	}
	
	private static <T> void lancaNoContentCasoVazio(List<T> lista) {
		if(lista.isEmpty()) {
			throw new NoContentException();
		}		
	}
}
