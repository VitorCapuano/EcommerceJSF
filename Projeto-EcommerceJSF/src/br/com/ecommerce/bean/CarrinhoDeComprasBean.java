package br.com.ecommerce.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import br.com.ecommerce.modelo.Livro;

@ManagedBean(name="Carrinho")
@SessionScoped
public class CarrinhoDeComprasBean {
	private Livro livroComprado = new Livro();
	
	
	public Livro getLivroComprado() {
		return livroComprado;
	}

	public void setLivroComprado(Livro livroComprado) {
		this.livroComprado = livroComprado;
	}
	
	public void livroSelecionado(ActionEvent evento){
		livroComprado = (Livro) evento.getComponent().getAttributes().get("livroComprado");
	}
	
	public String redirecionar(){
		return "produto";
	}
}