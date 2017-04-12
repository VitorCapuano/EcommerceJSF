package br.com.ecomerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.ecommerce.conexao.Conexao;
import br.com.ecommerce.modelo.Editora;

public class EditoraDAO {
	private Connection connection;
    private PreparedStatement p;
    private String sql;
    private ResultSet rs;
    
    public void cadastrarEditora(Editora editora){
    	sql = "INSERT INTO EDITORA VALUES ( NULL, ?, ?, ?, ?)";
        connection = Conexao.getConnection();
        
        try {
			p = connection.prepareStatement(sql);
			p.setString(1, editora.getNome());
			p.setString(2, editora.getCnpj());
			p.setString(3, editora.getEndereco());
			p.setString(4, editora.getTelefone());
			p.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
