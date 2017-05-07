package br.com.ecomerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ecommerce.conexao.Conexao;
import br.com.ecommerce.modelo.Autor;
import br.com.ecommerce.modelo.Livro;

public class LivroDAO {
	private Connection connection;
    private PreparedStatement p;
    private String sql;
    private ResultSet rs;
    
    public boolean cadastrarLivro(Livro livro){
    	boolean cadastrou = false;
    	sql = "INSERT INTO LIVRO VALUES ( NULL, ?, NULL, ?, ?, ?, ?)";
    	connection = Conexao.getConnection();
        
        try {
			p = connection.prepareStatement(sql);
			p.setString(1, livro.getTitulo());
			p.setString(2, livro.getDescricao());
			p.setInt(3, livro.getEditora().getIdEditora());
			p.setInt(4, livro.getGenero().getGeneroId());
			p.setInt(5, livro.getAutor().getIdAutor());
			p.execute();
			cadastrou = true;
        }catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
		}
    	return cadastrou;
    }

	public ArrayList<Livro> listarLivro() {
		ArrayList<Livro> lista = new ArrayList<Livro>();
		
		sql = "SELECT * FROM LIVRO";
    	connection = Conexao.getConnection();
    	
    	try {
			p = connection.prepareStatement(sql);
			rs = p.executeQuery();
			while(rs.next()){
				Livro livro = new Livro();
				livro.setIdLivro(rs.getInt("livro_id"));
				livro.setTitulo(rs.getString("titulo"));
				livro.setDescricao(rs.getString("descricao"));
				lista.add(livro);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return lista;
	}

	public void excluir(Livro livro) {
		sql = "DELETE FROM LIVRO WHERE LIVRO_ID = ?";
		connection = Conexao.getConnection();
		try{
			p = connection.prepareStatement(sql);
			p.setInt(1, livro.getIdLivro());
			p.execute();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
