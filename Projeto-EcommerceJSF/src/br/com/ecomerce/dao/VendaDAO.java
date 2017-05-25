package br.com.ecomerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.ecommerce.conexao.Conexao;
import br.com.ecommerce.modelo.ItemPedido;
import br.com.ecommerce.modelo.Venda;
import br.com.ecommerce.util.JavaUtil;

public class VendaDAO {
	private Connection connection;
    private PreparedStatement p;
    private String sql;
    private ResultSet rs;
    

	public boolean cadastrarVendas(List<ItemPedido> carrinhoCompra) {
		boolean cadastrado = false;
		sql = "INSERT INTO PEDIDO VALUES ( NULL, ?, ?, ?, SYSDATE)";
		connection = Conexao.getConnection();
    	
    	try {
    		p = connection.prepareStatement(sql);
    		for (int i = 0; i < carrinhoCompra.size(); i++) {
    			p.setInt(1, carrinhoCompra.get(i).getLivro().getIdLivro());
    			p.setString(2, carrinhoCompra.get(i).getCpf());
    			p.setDouble(3, carrinhoCompra.get(i).getPrecoComDesconto());
    			p.execute();
    		}
    		cadastrado = true;
    		
    	}catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
			JavaUtil.adicionarMensagemErro("Erro ao Cadastrar dados no banco");
		}
		
		
		return cadastrado;
	}
}
