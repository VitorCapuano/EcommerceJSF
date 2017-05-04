package br.com.ecommerce.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.ecomerce.dao.AutorDAO;
import br.com.ecomerce.dao.EditoraDAO;
import br.com.ecomerce.dao.GeneroDAO;
import br.com.ecomerce.dao.LivroDAO;
import br.com.ecommerce.modelo.Autor;
import br.com.ecommerce.modelo.Editora;
import br.com.ecommerce.modelo.Genero;
import br.com.ecommerce.modelo.Livro;
import br.com.ecommerce.util.JavaUtil;

@ManagedBean(name="Livro")
@ViewScoped
public class LivroBean {
	private Livro livro = new Livro();
	private List<Editora> listaEditora;
	private List<Autor> listaAutor;
	private List<Genero> listaGenero;
	
	
	//Get e Set do Listar editoras
	public List<Editora> getListaEditora() {
		EditoraDAO dao = new EditoraDAO();
		listaEditora = dao.listarEditora();
		return listaEditora;
	}

	
	//Get e Set do Listar autor
	public List<Autor> getListaAutor() {
		AutorDAO dao = new AutorDAO();
		listaAutor = dao.listarAutor();
		return listaAutor;
	}
	
	//Get e Set do Listar autor
	
	
	//Get e Set do genero
	public List<Genero> getListaGenero() {
		GeneroDAO dao = new GeneroDAO();
		listaGenero = dao.listarGenero();
		return listaGenero;
	}

	public void setListaGenero(List<Genero> listaGenero) {
		this.listaGenero = listaGenero;
	}

	//Get e Set do Livro
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
