package br.com.ecomerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.ecommerce.conexao.Conexao;
import br.com.ecommerce.modelo.Cliente;

public class ClienteDAO {
	private Connection connection;
	private PreparedStatement p;
	private ResultSet rs;
	private String sql;
	
	
	public void registrarCliente(Cliente cliente) {
		try {
			connection = Conexao.getConnection();
			sql = "INSERT INTO CLIENTE"
						+ "VALUES(NULL,?,?,?,?,?,?)";
			p = connection.prepareStatement(sql);
			p.setString(1, cliente.getNome());
			p.setString(2, cliente.getCpf());
			p.setDate(3, cliente.getDtNascimento());
			p.setString(4, cliente.getEndereco());
			p.setString(5, cliente.getEmail());
			p.setString(6, cliente.getSenha());
			p.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}