package br.com.herancaapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.herancaapi.entity.Correntista;
import br.com.herancaapi.repository.ICorrentistaRepository;
import br.com.herancaapi.service.CorrentistaService;

@RestController
@ResponseBody
@RequestMapping(value = "/api")
public class CorrentistaController {
	
	@Autowired
	ICorrentistaRepository dao;
	
	@Autowired
	CorrentistaService service;
	
	@PostMapping(value = "/")
	public ResponseEntity<?> createCorrentista(@RequestBody Correntista c) throws Exception{
		
		try {
			
			Correntista correntista = new Correntista(c.getId(), c.getNome(), c.getSaldo(), c.getOperacao(), c.getValor());
			Map<String, Object> calc = service.calcularMovimentacao(c);
			Correntista result = dao.save(correntista);
			if(result == null) {
				throw new IllegalArgumentException("Error");
			}
			return ResponseEntity.status(200).body(calc);
			
		} catch (Exception ex) {
			
			Map<String, Object> error = new HashMap<String, Object>();
			error.put("error", "Dados não gravados");
			return ResponseEntity.status(500).body(error);			
		}
	}
	
	@GetMapping(value = "/")
	public List<Correntista> findAllCorrentista(){
		return dao.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable(value = "id") Long id){
		
		Optional<?> correntista = dao.findById(id);
		
		return ResponseEntity.status(200).body(correntista);
		
	}
	
	@PutMapping(value = "/")
	public ResponseEntity<?> updateCorrentista(@RequestBody Correntista c) throws Exception{
		
		try {
			
			Correntista correntista = new Correntista(c.getId(), c.getNome(), c.getSaldo(), c.getOperacao(), c.getValor());
			Map<String, Object> calc = service.calcularMovimentacao(c);
			Correntista result = dao.save(correntista);
			if(result == null) {
				throw new IllegalArgumentException("Error");
			}
			return ResponseEntity.status(200).body(calc);
			
		} catch (Exception ex) {
			
			Map<String, Object> error = new HashMap<String, Object>();
			error.put("error", "Dados não gravados");
			return ResponseEntity.status(500).body(error);			
		}
	}

}
