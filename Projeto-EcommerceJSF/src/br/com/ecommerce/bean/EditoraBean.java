package br.com.ecommerce.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.com.ecomerce.dao.AutorDAO;
import br.com.ecomerce.dao.EditoraDAO;
import br.com.ecommerce.modelo.Autor;
import br.com.ecommerce.modelo.Editora;
import br.com.ecommerce.util.JavaUtil;

@ManagedBean(name="Editora")
@ViewScoped
public class EditoraBean {
	private Editora editora = new Editora();
	private List<Editora> listarEditora;
	
	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	
	public List<Editora> getListarEditora() {
		return listarEditora;
	}
	
	public void setListarEditora(List<Editora> listarEditora) {
		this.listarEditora = listarEditora;
	}
	
	@PostConstruct
	public void listar(){
		EditoraDAO dao = new EditoraDAO();
		listarEditora = dao.listarEditora();
	}
	
	public void cadastrar(){
		EditoraDAO dao = new EditoraDAO();
		boolean cadastrado = dao.cadastrarEditora(editora);
		if(cadastrado == true){
			listarEditora = dao.listarEditora();
			editora = new Editora();
			JavaUtil.adicionarMensagemSucesso("Editora cadastrada com sucesso!");
		}
	}
	
	public void excluir(ActionEvent evento){
		editora = (Editora) evento.getComponent().getAttributes().get("editoraSelecionada");
		EditoraDAO dao = new EditoraDAO();
		dao.excluir(editora);
		listarEditora = dao.listarEditora();
		
		JavaUtil.adicionarMensagemSucesso("Editora exclu�da com sucesso!");
	}
	
	public void editar(ActionEvent evento){
		editora = (Editora) evento.getComponent().getAttributes().get("editoraSelecionada");
		
	}
	
	public void alterar(){
		EditoraDAO dao = new EditoraDAO();
		boolean alterado = dao.editar(editora);
		if(alterado == true){
			listarEditora = dao.listarEditora();
			JavaUtil.adicionarMensagemSucesso("Editora alterada com sucesso!");
		}
		else{
			JavaUtil.adicionarMensagemErro("Erro ao cadastrar Editora");
		}
		
	}
	
}
