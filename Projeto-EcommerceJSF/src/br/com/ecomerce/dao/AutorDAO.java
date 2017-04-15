package br.com.ecomerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.ecommerce.conexao.Conexao;
import br.com.ecommerce.modelo.Autor;
import br.com.ecommerce.modelo.Editora;

public class AutorDAO {
	private Connection connection;
    private PreparedStatement p;
    private String sql;
    private ResultSet rs;
    
    public boolean cadastrarAutor(Autor autor){
    	boolean cadastrou = false;
    	sql = "INSERT INTO AUTOR (ID_AUTOR, NOME, ENDERECO, CPF, TELEFONE)"
    			+ " VALUES ( NULL, ?, ?, ?, ?)";
        connection = Conexao.getConnection();
        
        try {
			p = connection.prepareStatement(sql);
			p.setString(1, autor.getNome());
			p.setString(3, autor.getCpf());
			p.setString(2, autor.getEndereco());
			p.setString(4, autor.getTelefone());
			p.execute();
			cadastrou = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return cadastrou;
    }
    
    
    public ArrayList<Autor> listarAutor(){
    	ArrayList<Autor> lista = new ArrayList<Autor>();
    	sql = "SELECT * FROM AUTOR";
    	connection = Conexao.getConnection();
    	
    	try {
			p = connection.prepareStatement(sql);
			rs = p.executeQuery();
			while(rs.next()){
				Autor autor = new Autor();
				autor.setIdAutor(rs.getInt("id_autor"));
				autor.setNome(rs.getString("nome"));
				autor.setCpf(rs.getString("cpf"));
				autor.setEndereco(rs.getString("endereco"));
				autor.setTelefone(rs.getString("telefone"));
				lista.add(autor);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return lista;
    }
}
