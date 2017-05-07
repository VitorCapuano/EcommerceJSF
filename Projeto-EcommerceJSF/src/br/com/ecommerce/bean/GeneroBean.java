package br.com.ecommerce.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.com.ecomerce.dao.AutorDAO;
import br.com.ecomerce.dao.GeneroDAO;
import br.com.ecommerce.modelo.Autor;
import br.com.ecommerce.modelo.Genero;
import br.com.ecommerce.util.JavaUtil;

@ManagedBean(name="Genero")
@ViewScoped
public class GeneroBean {
	private Genero genero = new Genero();
	private List<Genero> listarGenero;

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	public List<Genero> getListarGenero() {
		return listarGenero;
	}
	
	public void setListarGenero(List<Genero> listarGenero) {
		this.listarGenero = listarGenero;
	}
	
	@PostConstruct
	public void listar(){
		GeneroDAO genero = new GeneroDAO();
		listarGenero = genero.listarGenero();
	}
	
	public void cadastrar(){
		GeneroDAO dao = new GeneroDAO();
		boolean cadastrado = dao.cadastrarGenero(genero);
		if(cadastrado == true){
			listarGenero = dao.listarGenero();
			genero = new Genero();
			JavaUtil.adicionarMensagemSucesso("Genero cadastrada com sucesso!");
		}
	}
	
	public void excluir(ActionEvent evento){
		genero = (Genero) evento.getComponent().getAttributes().get("generoSelecionado");
		GeneroDAO dao = new GeneroDAO();
		dao.excluir(genero);
		listarGenero = dao.listarGenero();
		
		JavaUtil.adicionarMensagemSucesso("Editora excluída com sucesso!");
	}
	
	
	public void editar(ActionEvent evento){
		genero = (Genero) evento.getComponent().getAttributes().get("generoSelecionado");
		
	}
	
	public void alterar(){
		GeneroDAO dao = new GeneroDAO();
		boolean alterado = dao.editar(genero);
		if(alterado == true){
			listarGenero = dao.listarGenero();
			JavaUtil.adicionarMensagemSucesso("Genero alterado com sucesso!");
		}
		else{
			JavaUtil.adicionarMensagemSucesso("Erro ao editar banco");
		}
		
	}
}
