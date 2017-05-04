package br.com.ecommerce.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.ecomerce.dao.GeneroDAO;
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
			JavaUtil.adicionarMensagemSucesso("Genero cadastrada com sucesso!");
		}
	}
}
