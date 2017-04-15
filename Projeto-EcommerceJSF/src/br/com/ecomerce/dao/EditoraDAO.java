package br.com.ecomerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import br.com.ecommerce.conexao.Conexao;
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
				editora.setTelefone(rs.getString("endereco"));
				lista.add(editora);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return lista;
    }
    
    
    /*
    public static void main(String[] args){
    	
    	Editora ed = new Editora();
    	
    	ed.setNome("Editora Abril");
    	ed.setCnpj("12345678000123");
    	ed.setEndereco("Rua Gabriele Fattorini, 128");
    	ed.setTelefone("111111111");
    	
    	EditoraDAO dao = new EditoraDAO();
    	boolean cadastrou = dao.cadastrarEditora(ed);
    	if(cadastrou == true){
    		System.out.println("Editora cadastrada com sucesso");
    	}
    	else{
    		System.out.println("Erro ao cadastrar");
    	}
    	
    	
    	
    	EditoraDAO dao = new EditoraDAO();
    	try{
    		ArrayList<Editora> lista = dao.listarEditora();
    		for(Editora f : lista){
    			System.out.println("\n" + f);
    		}
    	}
    	catch (Exception e) {
    		System.out.println("Erro no banco");
		}
    	
    	
    }
    */
}
