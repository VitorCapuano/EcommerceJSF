package br.com.ecommerce.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

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
	private List<Livro> listarLivro;
	private List<Editora> listaEditora;
	private List<Autor> listaAutor;
	private List<Genero> listaGenero;
	 

	
	public List<Livro> getListarLivro() {
		return listarLivro;
	}
	
	public void setListarLivro(List<Livro> litarLivro) {
		this.listarLivro = litarLivro;
	}
	
	@PostConstruct
	public void listar(){
		LivroDAO livro = new LivroDAO();
		listarLivro = livro.listarLivro();
	}
	
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
			listarLivro = dao.listarLivro();
			livro = new Livro();
			JavaUtil.adicionarMensagemSucesso("Livro cadastrado com sucesso!");
		}
	}
	
	public void excluir(ActionEvent evento){
		livro = (Livro) evento.getComponent().getAttributes().get("livroSelecionado");
		LivroDAO dao = new LivroDAO();
		dao.excluir(livro);
		listarLivro = dao.listarLivro();
		
		JavaUtil.adicionarMensagemSucesso("Livro exclu�do com sucesso!");
		
	}
	
	public void editar(ActionEvent evento){
		livro = (Livro) evento.getComponent().getAttributes().get("livroSelecionado");
		LivroDAO dao = new LivroDAO();
		listarLivro = dao.listarLivro();
	}
	
	public void alterar(){
		LivroDAO dao = new LivroDAO();
		boolean alterado = dao.editar(livro);
		if(alterado == true){
			listarLivro = dao.listarLivro();
			JavaUtil.adicionarMensagemSucesso("Livro alterado com sucesso!");
		}
		else{
			JavaUtil.adicionarMensagemSucesso("Erro ao editar banco");
		}
		
	}
	
	
	
	/* Filtro de livros*/
	private String livroSelecionado;
	private String comboSelecionado;
	
	public String getLivroSelecionado() {
		return livroSelecionado;
	}

	public void setLivroSelecionado(String livroSelecionado) {
		this.livroSelecionado = livroSelecionado;
	}
	
	public String getComboSelecionado() {
		return comboSelecionado;
	}

	public void setComboSelecionado(String comboSelecionado) {
		this.comboSelecionado = comboSelecionado;
	}
	
	public void filtrar(){
		LivroDAO dao = new LivroDAO();
				
		if(livroSelecionado == ""){
			listarLivro = dao.listarLivro();
		}
		else{
			if (comboSelecionado.equalsIgnoreCase("titulo")){
				listarLivro = dao.buscarPorLivro(livroSelecionado);
				
			}
			else if(comboSelecionado.equalsIgnoreCase("autor")){
				int idAutor = dao.buscarAutor(livroSelecionado);
				listarLivro = dao.buscarLivroPorAutor(idAutor);
			}
			else{
				int idEditora = dao.buscarEditora(livroSelecionado);
				listarLivro = dao.buscarLivroPorEditora(idEditora);
			}
		}
	}
	
	/*Fim do filtro de livro */
	
}
