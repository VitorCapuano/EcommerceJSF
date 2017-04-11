package br.com.ecommerce.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.ecomerce.dao.AutorDAO;
import br.com.ecommerce.modelo.Autor;

@ManagedBean(name="Autor")
@ViewScoped
public class AutorBean {
	private Autor autor = new Autor();
	
	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}


	public void cadastrar(){
		AutorDAO dao = new AutorDAO();
		dao.cadastrarAutor(autor);
	
}
	
}

