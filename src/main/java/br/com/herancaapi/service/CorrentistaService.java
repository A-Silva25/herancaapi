package br.com.herancaapi.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.herancaapi.entity.Correntista;

@Service
public class CorrentistaService implements ICorrentistaService {

	@Override
	public Map<String, Object> calcularMovimentacao(Correntista c) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("correntista", c);
		
		String errorResult = "";
		String successResult = "";
		
		if(c.getOperacao().equals("deposito") || c.getOperacao().equals("Deposito") || c.getOperacao().equals("depósito") || c.getOperacao().equals("Depósito")) {
			
			map.put("Saldo atual", c.getSaldo());
			map.put("Valor do depósito", c.getValor());
			map.put("Operacao", "Depósito");
			c.setSaldo(c.getSaldo() + c.getValor());
			map.put("Novo saldo", c.getSaldo());
			successResult = "Depósito realizado com sucesso";
			map.put("success", successResult);
			
		}else if(c.getOperacao().equals("retirada") || c.getOperacao().equals("Retirada")) {
			
			if(c.getValor()<=c.getSaldo()) {
				
				map.put("Saldo atual", c.getSaldo());
				map.put("Valor da retirada", c.getValor());
				map.put("Operacao", "Retirada");
				c.setSaldo(c.getSaldo() - c.getValor());
				map.put("Novo saldo", c.getSaldo());
				successResult = "Retirada realizado com sucesso";
				map.put("success", successResult);
				
			}else {
				
				errorResult = "Saldo insuficiente";
				map.put("error", errorResult);
				
			}
		}else {
			
			errorResult = "Operação não definida";
			map.put("error", errorResult);
			
		}
		
		return map;
	}

}
