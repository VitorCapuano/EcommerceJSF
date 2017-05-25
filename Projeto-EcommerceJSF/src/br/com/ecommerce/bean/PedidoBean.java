package br.com.ecommerce.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import br.com.ecomerce.dao.LivroDAO;
import br.com.ecommerce.modelo.ItemPedido;
import br.com.ecommerce.modelo.Livro;
import br.com.ecommerce.modelo.Pedido;
import br.com.ecommerce.util.JavaUtil;

@ManagedBean(name = "Pedido")
@SessionScoped
public class PedidoBean {
	private Pedido pedido;
	private List<Livro> livros;
	private List<ItemPedido> carrinhoCompra;
	private Livro livro = new Livro();
	
	public Pedido getPedido() {
		return pedido;
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public List<ItemPedido> getCarrinhoCompra() {
		return carrinhoCompra;
	}

	public void setCarrinhoCompra(List<ItemPedido> carrinhoCompra) {
		this.carrinhoCompra = carrinhoCompra;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	@PostConstruct
	public void novo(){
		pedido = new Pedido();
		pedido.setPrecoTotal(0.0);
		
		LivroDAO livro = new LivroDAO();
		livros = livro.listarLivro();
		carrinhoCompra = new ArrayList();
	}

	// insere no carrinho
	public void adicionarItem(ActionEvent e) {
		livro = (Livro) e.getComponent().getAttributes().get("livroAdicionado");

		// verifica se ja existe o livro no carrinho
		int achou = -1;
		for (int posicao = 0; posicao < carrinhoCompra.size(); posicao++) {
			if (carrinhoCompra.get(posicao).getLivro().equals(livro)) {
				achou = posicao;
			}
		}

		if (achou < 0) {
			ItemPedido iPedido = new ItemPedido();
			iPedido.setPrecoComDesconto(livro.getPrecoAtual());
			iPedido.setPrecoFinal(livro.getPrecoAtual());
			iPedido.setQuantidade(1);
			iPedido.setLivro(livro);
			carrinhoCompra.add(iPedido);
		} else {
			JavaUtil.adicionarMensagemErro("Livro j� adicionado ao carrinho");
		}
		calcularTotal();
	}

	public void removerItem(ActionEvent e) {
		ItemPedido iPedido = (ItemPedido) e.getComponent().getAttributes().get("livroSelecionado");

		// acha a posi��o do item no arraylist
		int achou = -1;
		for (int posicao = 0; posicao < carrinhoCompra.size(); posicao++) {
			if (carrinhoCompra.get(posicao).getLivro().equals(iPedido.getLivro())) {
				achou = posicao;
			}
		}

		if (achou > -1) {
			carrinhoCompra.remove(achou);
		}
		alteraTotal();
	}

	// incrementa a quantidade de livros e atualiza o valor total
	public void aumentar(ActionEvent e) {
		ItemPedido it = (ItemPedido) e.getComponent().getAttributes().get("selecionado");

		int achouL = -1;
		int achouP = -1;
		// percorre o o array de livro e o do carrinho
		for (int i = 0; i < livros.size(); i++) {
			for (int j = 0; j < carrinhoCompra.size(); j++) {
				// verifica se a linha retornada � igual a que foi selecionada
				if ((livros.get(i).getPrecoAtual().equals(it.getPrecoComDesconto())
						&& carrinhoCompra.get(j).getLivro().equals(it.getLivro()))) {
					achouP = i;
					achouL = j;
				}
			}
		}

		// se achou passa o numero da linha para as variaveis
		ItemPedido iPedido = carrinhoCompra.get(achouL);
		Livro l = livros.get(achouP);
		if (achouL > -1 && achouP > -1) {
			iPedido.setQuantidade(iPedido.getQuantidade() + 1);
			double v = l.getPrecoAtual() * iPedido.getQuantidade();
			iPedido.setPrecoFinal(v);
		}
		calcularTotal();
	}

	public void diminuir(ActionEvent e) {
		ItemPedido it = (ItemPedido) e.getComponent().getAttributes().get("livroSel");
		int achouL = -1;
		for(int i = 0; i < carrinhoCompra.size(); i++) {
			if(carrinhoCompra.get(i).getLivro().equals(it.getLivro())
					&& carrinhoCompra.get(i).getPrecoFinal().equals(it.getPrecoFinal())) {
				achouL = i;
			}
		}
	
		if(achouL > -1) {
			ItemPedido iPedido = carrinhoCompra.get(achouL);
			iPedido.setQuantidade(iPedido.getQuantidade() - 1);
			iPedido.setPrecoFinal(iPedido.getPrecoFinal() - iPedido.getPrecoComDesconto());
			alteraTotal();
		}
	}
	
	// calcula total
	public void calcularTotal() {
		pedido.setPrecoTotal(0.0);
		for(int i = 0; i < carrinhoCompra.size(); i++) {
			ItemPedido iPedido = carrinhoCompra.get(i);
			pedido.setPrecoTotal(pedido.getPrecoTotal()+iPedido.getPrecoFinal());
		}
	}
	
	public void alteraTotal() {
		pedido.setPrecoTotal(0.0);
		for(int i = 0; i < carrinhoCompra.size(); i++) {
			ItemPedido iPedido = carrinhoCompra.get(i);
			pedido.setPrecoTotal(pedido.getPrecoTotal()-iPedido.getPrecoFinal());
		}
	}
}