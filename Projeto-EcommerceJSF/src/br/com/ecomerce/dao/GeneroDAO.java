package br.com.ecomerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.ecommerce.conexao.Conexao;
import br.com.ecommerce.modelo.Genero;
import br.com.ecommerce.util.JavaUtil;

public class GeneroDAO {
	private Connection connection;
    private PreparedStatement p;
    private String sql;
    private ResultSet rs;
    
    public boolean cadastrarGenero(Genero genero){
    	boolean cadastrado = false;
    	sql = "INSERT INTO GENERO VALUES ( NULL, ?)";
        connection = Conexao.getConnection();
        
        try {
			p = connection.prepareStatement(sql);
			p.setString(1, genero.getNome());
			p.execute();
			cadastrado = true;
        }catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
			JavaUtil.adicionarMensagemErro("Erro ao Cadastrar dados no banco");
		}
        return cadastrado;
    }
    
    public ArrayList<Genero> listarGenero(){
    	ArrayList<Genero> lista = new ArrayList<Genero>();
    	sql = "SELECT * FROM GENERO";
    	
    	connection = Conexao.getConnection();
        
        try {
			p = connection.prepareStatement(sql);
			rs = p.executeQuery();
			while(rs.next()){
				Genero genero = new Genero();
				genero.setGeneroId(rs.getInt("id_genero"));
				genero.setNome(rs.getString("nome"));
				lista.add(genero);
			}
        }
        catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return lista;
    }
}
