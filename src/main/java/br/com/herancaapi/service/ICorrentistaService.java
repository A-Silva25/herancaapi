package br.com.herancaapi.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.herancaapi.entity.Correntista;

@Service
public interface ICorrentistaService {
	
	public Map<String, Object> calcularMovimentacao(Correntista c);

}
