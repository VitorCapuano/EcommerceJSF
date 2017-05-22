package br.com.ecommerce.modelo;

public class ItemPedido {
	private Pedido pedido;
	private Livro livro;
	private Integer quantidade;
	private Double preco;
	private Double precoComDesconto;
	private Double precoFinal;
	
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getPrecoFinal() {
		return precoFinal;
	}
	public void setPrecoFinal(Double precoFinal) {
		this.precoFinal = precoFinal;
	}
	public Double getPrecoComDesconto() {
		return precoComDesconto;
	}
	public void setPrecoComDesconto(Double precoComDesconto) {
		this.precoComDesconto = precoComDesconto;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
}