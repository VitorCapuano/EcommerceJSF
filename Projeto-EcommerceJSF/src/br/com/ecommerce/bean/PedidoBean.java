package br.com.ecommerce.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import com.sun.faces.taglib.html_basic.OutputTextTag;

import br.com.ecomerce.dao.LivroDAO;
import br.com.ecommerce.modelo.ItemPedido;
import br.com.ecommerce.modelo.Livro;
import br.com.ecommerce.util.JavaUtil;

@ManagedBean(name = "Pedido")
@SessionScoped
public class PedidoBean {
	private List<Livro> livros;
	private List<ItemPedido> carrinhoCompra = new ArrayList();
	private Livro livro = new Livro();
	
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
	public void listar(){
		LivroDAO livro = new LivroDAO();
		livros = livro.listarLivro();
	}

	// insere no carrinho
	public void adicionarItem(ActionEvent e) {
		livro = (Livro) e.getComponent().getAttributes().get("livroAdicionado");

		// verifica se ja existe o livro no carrinho
		int achou = -1;
		for (int posicao = 0; posicao < carrinhoCompra.size(); posicao++) {
			if (carrinhoCompra.get(posicao).getLivro().equals(livro)
					&& carrinhoCompra.get(posicao).getPrecoComDesconto().equals(livro.getPrecoAtual())) {
				achou = posicao;
			}
		}

		if (achou < 0) {
			ItemPedido iPedido = new ItemPedido();
			iPedido.setPreco(livro.getPreco());
			iPedido.setPrecoComDesconto(livro.getPrecoAtual());
			iPedido.setPrecoFinal(livro.getPrecoAtual());
			iPedido.setQuantidade(1);
			iPedido.setLivro(livro);
			carrinhoCompra.add(iPedido);
		} else {
			JavaUtil.adicionarMensagemErro("Livro já adicionado ao carrinho");
		}
	}

	public void removerItem(ActionEvent e) {
		ItemPedido iPedido = (ItemPedido) e.getComponent().getAttributes().get("livroSelecionado");

		// acha a posição do item no arraylist
		int achou = -1;
		for (int posicao = 0; posicao < carrinhoCompra.size(); posicao++) {
			if (carrinhoCompra.get(posicao).getLivro().equals(iPedido.getLivro())) {
				achou = posicao;
			}
		}

		if (achou > -1) {
			carrinhoCompra.remove(achou);
		}
	}

	// incrementa a quantidade de livros e atualiza o valor total
	public void aumentar(ActionEvent e) {
		ItemPedido it = (ItemPedido) e.getComponent().getAttributes().get("selecionado");

		int achouL = -1;
		int achouP = -1;
		for(int i = 0; i < livros.size();i++) {
			for(int j = 0; j < carrinhoCompra.size(); j++) {
				if((livros.get(i).getPrecoAtual().equals(it.getPrecoComDesconto())
						&& carrinhoCompra.get(j).getLivro().equals(it.getLivro()))) {
					achouP = i;
					achouL = j; 
				}
			}
		}
		
		ItemPedido iPedido = carrinhoCompra.get(achouL);
		Livro l = livros.get(achouP);
		if(achouL > -1 && achouP > -1) {
			iPedido.setQuantidade(iPedido.getQuantidade() + 1);
			double v = l.getPrecoAtual()*iPedido.getQuantidade();
			iPedido.setPrecoFinal(v);
		}
	}

	public void diminuir(ActionEvent e) {
		ItemPedido it = (ItemPedido) e.getComponent().getAttributes().get("selecionado");

		int achouL = -1;
		int achouP = -1;
		for(int i = 0; i < carrinhoCompra.size(); i++) {
			if(carrinhoCompra.get(i).getLivro().equals(it.getLivro())
					&& carrinhoCompra.get(i).getPrecoFinal().equals(it.getPrecoFinal())) {
				achouL = i;
			}
		}
		
		ItemPedido iPedido = carrinhoCompra.get(achouL);
		if(achouL > -1 && achouP > -1) {
			iPedido.setQuantidade(iPedido.getQuantidade() - 1);
			iPedido.setPrecoFinal(iPedido.getPrecoFinal() -iPedido.getPrecoComDesconto());
		}
	}
}