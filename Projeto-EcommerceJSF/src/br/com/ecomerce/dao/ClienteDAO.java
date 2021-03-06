package br.com.ecomerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.ecommerce.conexao.Conexao;
import br.com.ecommerce.modelo.Pessoa;
import br.com.ecommerce.util.JavaUtil;

public class ClienteDAO {
	private Connection connection;
    private PreparedStatement p;
    private String sql;
    private ResultSet rs;
    
    public Pessoa autenticar(String email, String senha){
    	Pessoa cliente = null;
    	sql = "SELECT * FROM PESSOA WHERE EMAIL = ? AND SENHA = ?";
    	connection = Conexao.getConnection();
    	try {
			p = connection.prepareStatement(sql);
			p.setString(1, email);
			p.setString(2, senha);
			rs = p.executeQuery();
			while(rs.next()){
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				String rua = rs.getString("rua");
				String numero = rs.getString("numero");
				String bairro = rs.getString("bairro");
				String cep = rs.getString("cep");
				String telefone = rs.getString("telefone");
				String celular = rs.getString("celular");
				String cidade = rs.getString("cidade");
				String tipo = rs.getString("tipo");
				cliente = new Pessoa(nome, cpf, rua, numero, bairro, cep, telefone, email, senha, celular, cidade, tipo);
			}
    	}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JavaUtil.adicionarMensagemSucesso("Erro ao localizar cliente no banco!");
		}
    	return cliente;
    }
    
    
    public static void main(String[]args){
    	Pessoa p = new Pessoa();
    	p.setEmail("jclima2738@gmail.com");
    	p.setSenha("436973JU");
    	
    	ClienteDAO dao = new ClienteDAO();
    	Pessoa teste = dao.autenticar(p.getEmail(), p.getSenha());
    	
    	if(teste == null){
    		System.out.println("Cliente n�o localizado");
    	}
    	else{
    		System.out.println("Nome: "+ teste.getNome());
    	}
    	
    }
    
    
    
    public boolean cadastrarCliente(Pessoa pessoa){
    	boolean cadastrou = false;
    	sql = "INSERT INTO PESSOA VALUES (?, 'C', ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
			JavaUtil.adicionarMensagemSucesso("Erro ao cadastrar cliente no banco!");
		}
        return cadastrou;
    }
}
