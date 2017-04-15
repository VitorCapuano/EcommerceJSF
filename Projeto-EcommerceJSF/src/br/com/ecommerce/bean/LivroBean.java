package br.com.ecommerce.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.ecomerce.dao.EditoraDAO;
import br.com.ecomerce.dao.LivroDAO;
import br.com.ecommerce.modelo.Editora;
import br.com.ecommerce.modelo.Livro;
import br.com.ecommerce.util.JavaUtil;

@ManagedBean(name="Livro")
@ViewScoped
public class LivroBean {
	private Livro livro = new Livro();
	private List<Editora> listaEditora; //editoras
	

	public List<Editora> getListaEditora() {
		EditoraDAO dao = new EditoraDAO();
		listaEditora = dao.listarEditora();
		return listaEditora;
	}

	public void setListaEditora(List<Editora> listaEditora) {
		this.listaEditora = listaEditora;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	
	
	public void cadastrar(){
		LivroDAO dao = new LivroDAO();
		boolean cadastrou = dao.cadastrarLivro(livro);
		if(cadastrou == true){
			JavaUtil.adicionarMensagemSucesso("Editora cadastrada com sucesso!");
		}
	}
}
