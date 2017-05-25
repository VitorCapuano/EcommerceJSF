package br.com.ecommerce.modelo;

public class ItemVenda {
	private int quantidade;
	private Double valorParcial;
	private Livro livro;
	private Venda venda;
	private Pessoa pessoa;
	
	
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public void setValorParcial(Double valorParcial) {
		this.valorParcial = valorParcial;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getValorParcial() {
		return valorParcial;
	}
	public void setValorParcial(double valorParcial) {
		this.valorParcial = valorParcial;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Venda getVenda() {
		return venda;
	}
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((livro == null) ? 0 : livro.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + quantidade;
		result = prime * result + ((valorParcial == null) ? 0 : valorParcial.hashCode());
		result = prime * result + ((venda == null) ? 0 : venda.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemVenda other = (ItemVenda) obj;
		if (livro == null) {
			if (other.livro != null)
				return false;
		} else if (!livro.equals(other.livro))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (quantidade != other.quantidade)
			return false;
		if (valorParcial == null) {
			if (other.valorParcial != null)
				return false;
		} else if (!valorParcial.equals(other.valorParcial))
			return false;
		if (venda == null) {
			if (other.venda != null)
				return false;
		} else if (!venda.equals(other.venda))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ItemVenda [quantidade=" + quantidade + ", valorParcial=" + valorParcial + ", livro=" + livro
				+ ", venda=" + venda + ", pessoa=" + pessoa + "]";
	}
	
	
		
	
	
}
