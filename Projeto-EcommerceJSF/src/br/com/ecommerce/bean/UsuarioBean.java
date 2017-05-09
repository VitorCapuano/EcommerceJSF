package br.com.ecommerce.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.ecomerce.dao.UsuarioDAO;
import br.com.ecommerce.modelo.Pessoa;
import br.com.ecommerce.util.JavaUtil;

@ManagedBean(name="Admin")
@ViewScoped
public class UsuarioBean {
	private Pessoa admin = new Pessoa();

	public Pessoa getAdmin() {
		return admin;
	}

	public void setAdmin(Pessoa admin) {
		this.admin = admin;
	}
	
	public void cadastrar(){
		UsuarioDAO dao = new UsuarioDAO();
		boolean cadastrado = dao.cadastrarUsuario(admin);
		if(cadastrado == true){
			admin = new Pessoa();
			JavaUtil.adicionarMensagemSucesso("Administrador cadastrado com sucesso!");
		}
		else{
			JavaUtil.adicionarMensagemSucesso("Erro ao cadastrar Administrador!");
		}
	}
}
