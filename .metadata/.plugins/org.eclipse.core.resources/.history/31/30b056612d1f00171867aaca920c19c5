package br.com.ecommerce.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.ecomerce.dao.EditoraDAO;
import br.com.ecommerce.modelo.Editora;

@ManagedBean(name="Editora")
@ViewScoped
public class EditoraBean {
	private Editora editora = new Editora();
	
	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	
	public void cadastrar(){
		EditoraDAO dao = new EditoraDAO();
		dao.cadastrarEditora(editora);
	
}
	
	
}
