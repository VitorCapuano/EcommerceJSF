package br.com.ecommerce.modelo;

public class Pedido {
	private int idPedido;
	private Livro livro;
	private Pessoa cliente;
	private Double precoTotal;
	private Double precoComFrete;
	
	public Double getPrecoComFrete() {
		return precoComFrete;
	}
	
	public void setPrecoComFrete(Double precoComFrete) {
		this.precoComFrete = precoComFrete;
	}
	
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Pessoa getCliente() {
		return cliente;
	}
	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}
	public Double getPrecoTotal() {
		return precoTotal;
	}
	public void setPrecoTotal(Double precoTotal) {
		this.precoTotal = precoTotal;
	}
}