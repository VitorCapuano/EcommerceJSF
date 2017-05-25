package br.com.ecommerce.modelo;

import java.sql.Date;

public class Venda {
	private Double precoTotal;
	private String cpf;
	private int idLivro;
	
	
	
	public int getIdLivro() {
		return idLivro;
	}
	
	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}
	
	public Double getPrecoTotal() {
		return precoTotal;
	}
	public void setPrecoTotal(Double precoTotal) {
		this.precoTotal = precoTotal;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Venda [precoTotal=" + precoTotal + ", cpf=" + cpf + ", idLivro=" + idLivro + "]";
	}

			
	
}
