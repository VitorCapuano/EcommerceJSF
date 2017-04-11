package br.com.ecommerce.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.ecomerce.dao.ClienteDAO;
import br.com.ecommerce.modelo.Cliente;

@ManagedBean(name="Cliente")
@ViewScoped
public class ClienteBean {
	// propriedades de entrada
	private Cliente cliente;
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliene(Cliente cliene) {
		this.cliente = cliente;
	}
	
	// propriedades de saida
	private String page;
	private String pageError;
	
	public String getPage() {
		return page;
	}
	
	public String getPageError() {
		return pageError;
	}
	
	public String registrarCliente() {
		cliente = new Cliente();
		ClienteDAO dao = new ClienteDAO();
		dao.registrarCliente(cliente);
		return "";
	}
}
