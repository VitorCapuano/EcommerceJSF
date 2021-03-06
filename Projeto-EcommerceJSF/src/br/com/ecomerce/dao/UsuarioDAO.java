package br.com.ecomerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.ecommerce.conexao.Conexao;
import br.com.ecommerce.modelo.Pessoa;
import br.com.ecommerce.util.JavaUtil;

public class UsuarioDAO {
	private Connection connection;
    private PreparedStatement p;
    private String sql;
    private ResultSet rs;
    
    public boolean cadastrarUsuario(Pessoa pessoa){
    	boolean cadastrou = false;
    	sql = "INSERT INTO PESSOA VALUES (?, 'A', ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        connection = Conexao.getConnection();
        try {
			p = connection.prepareStatement(sql);
			p.setString(1, pessoa.getSenha());
			p.setString(2, pessoa.getNome());
			p.setString(3, pessoa.getCpf());
			p.setString(4, pessoa.getRua());
			p.setString(5, pessoa.getNumero());
			p.setString(6, pessoa.getBairro());
			p.setString(7, pessoa.getCep());
			p.setString(8, pessoa.getTelefone());
			p.setString(9, pessoa.getCelular());
			p.setString(10, pessoa.getEmail());
			p.setString(11, pessoa.getCidade());
			p.execute();
			cadastrou = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JavaUtil.adicionarMensagemSucesso("Erro ao cadastrar administrador no banco!");
		}
        return cadastrou;
    }
}
