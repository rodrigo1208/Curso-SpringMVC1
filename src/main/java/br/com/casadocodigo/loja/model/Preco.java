package br.com.casadocodigo.loja.model;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

import br.com.casadocodigo.loja.enums.TipoPreco;

@Embeddable
public class Preco {
	
	private BigDecimal valor;
	private TipoPreco tipoPreco;
	
	public Preco() {
		// TODO Auto-generated constructor stub
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public TipoPreco getTipoPreco() {
		return tipoPreco;
	}
	public void setTipoPreco(TipoPreco tipoPreco) {
		this.tipoPreco = tipoPreco;
	}
	
	
}
