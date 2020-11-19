package br.com.herancaapi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "correntista")
@PrimaryKeyJoinColumn(name = "id")
public class Correntista extends Conta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(length = 50)
	private String operacao;
	
	@Column
	private Double valor;

	public Correntista() {
		
	}
	
	public Correntista(String operacao, Double valor) {
		super();
		this.operacao = operacao;
		this.valor = valor;
	}

	public Correntista(Long id, String nome, Double saldo, String operacao, Double valor) {
		super(id, nome, saldo);
		this.operacao = operacao;
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Correntista [operacao=" + operacao + ", valor=" + valor + ", getId()=" + getId() + ", getNome()="
				+ getNome() + ", getSaldo()=" + getSaldo() + "]";
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	

}
