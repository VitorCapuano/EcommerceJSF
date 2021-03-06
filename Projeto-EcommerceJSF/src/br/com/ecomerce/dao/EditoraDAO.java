package br.com.ecomerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ecommerce.conexao.Conexao;
import br.com.ecommerce.modelo.Autor;
import br.com.ecommerce.modelo.Editora;
import br.com.ecommerce.util.JavaUtil;

public class EditoraDAO {
	private Connection connection;
    private PreparedStatement p;
    private String sql;
    private ResultSet rs;
    
    public boolean cadastrarEditora(Editora editora){
    	boolean cadastrado = false;
    	sql = "INSERT INTO EDITORA VALUES ( NULL, ?, ?, ?, ?)";
        connection = Conexao.getConnection();
        
        try {
			p = connection.prepareStatement(sql);
			p.setString(1, editora.getNome());
			p.setString(2, editora.getCnpj());
			p.setString(3, editora.getEndereco());
			p.setString(4, editora.getTelefone());
			p.execute();
			cadastrado = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JavaUtil.adicionarMensagemErro("Erro ao Cadastrar dados no banco");
		}
        return cadastrado;
    }
    
    public ArrayList<Editora> listarEditora(){
    	ArrayList<Editora> lista = new ArrayList<Editora>();
    	sql = "SELECT * FROM EDITORA";
    	connection = Conexao.getConnection();
    	
    	try {
			p = connection.prepareStatement(sql);
			rs = p.executeQuery();
			while(rs.next()){
				Editora editora = new Editora();
				editora.setIdEditora(rs.getInt("id_editora"));
				editora.setNome(rs.getString("nome"));
				editora.setCnpj(rs.getString("cnpj"));
				editora.setEndereco(rs.getString("endereco"));
				editora.setTelefone(rs.getString("telefone"));
				lista.add(editora);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return lista;
    }

	public void excluir(Editora editora) {
		sql = "DELETE FROM EDITORA WHERE ID_EDITORA = ?";
		connection = Conexao.getConnection();
		try{
			p = connection.prepareStatement(sql);
			p.setInt(1, editora.getIdEditora());
			p.execute();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public boolean editar(Editora editora) {
		boolean alterou = false;
		sql = "UPDATE EDITORA SET NOME = ?, CNPJ = ?, ENDERECO = ?, TELEFONE = ? WHERE ID_EDITORA = ? ";
		connection = Conexao.getConnection();
		try{
			p = connection.prepareStatement(sql);
			p.setString(1, editora.getNome());
			p.setString(2, editora.getCnpj());
			p.setString(3, editora.getEndereco());
			p.setString(4, editora.getTelefone());
			p.setInt(5, editora.getIdEditora());
			p.execute();
			alterou = true;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JavaUtil.adicionarMensagemSucesso("Erro ao registrar no banco");
		}
		return alterou;
	}
    
}
