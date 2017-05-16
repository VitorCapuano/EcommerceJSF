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
import br.com.ecommerce.util.JavaUtil;

@ManagedBean(name="Pedido")
@SessionScoped
public class PedidoBean {
	private List<Livro> livros;
	private List<ItemPedido> carrinhoCompra;
	
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
	
	// carrega os itens no carrinho se ja existir algum
	@PostConstruct
	public void listar(){
		try {
			LivroDAO dao = new LivroDAO();
			livros = dao.listarLivro();
			carrinhoCompra = new ArrayList();
		} catch(Exception e) {
			JavaUtil.adicionarMensagemErro("Erro ao carregar carrinho de compras");
		}
	}
	
	// insere no carrinho
	public void adicionarItem(ActionEvent e) {
		Livro livro = (Livro) e.getComponent().getAttributes().get("livroSelecionado");
		
		ItemPedido iPedido = new ItemPedido();
		iPedido.setPreco(livro.getPrecoAtual());
		iPedido.setQuantidade(1);
		iPedido.setLivro(livro);
		carrinhoCompra.add(iPedido);
		
		if(carrinhoCompra != null) {
			JavaUtil.adicionarMensagemSucesso("Livro adicionado no carrinho de compras");
		}
	}
	
	public void removerItem(ActionEvent e) {
		ItemPedido iPedido = (ItemPedido) e.getComponent().getAttributes().get("livroSelecionado");
		
		// acha a posição do item no arraylist
		int achou = -1;
		for(int posicao = 0; posicao < carrinhoCompra.size(); posicao++) {
			if(carrinhoCompra.get(posicao).getLivro().equals(iPedido.getLivro())) {
				achou = posicao;
			}
		}
		
		if(achou > -1) {
			carrinhoCompra.remove(achou);
		}
	}
	
	// incrementa a quantidade de livros e atualiza o valor total
	public void atualizar(ActionEvent e) {
		ItemPedido i = (ItemPedido) e.getComponent().getAttributes().get("selecionado");
		
		int achou = -1;
		for(int posicao = 0; posicao < carrinhoCompra.size(); posicao++) {
			if(carrinhoCompra.get(posicao).getLivro().equals(i.getLivro())) {
				achou = posicao;
			}
		}
		
		ItemPedido iPedido = carrinhoCompra.get(achou);
		if(achou > -1) {
			iPedido.setQuantidade(iPedido.getQuantidade() + 1);
			double valorFinal = 0;
			valorFinal = livros.get(achou).getPrecoAtual() * iPedido.getQuantidade();
			iPedido.setPreco(valorFinal);
		}
	}
 }