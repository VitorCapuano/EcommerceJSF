package br.com.ecommerce.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	  private static Connection connection;
	  private static String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521/orcl";
	  private static String usuario = "rm75077";
	  private static String senha = "270185";
	  
	  public static Connection getConnection(){
		  if (connection == null) {
	            try {
	                Class.forName("oracle.jdbc.driver.OracleDriver");
	                connection = DriverManager.getConnection(url, usuario, senha);
	            }
	            catch(ClassNotFoundException e) {
	            	e.printStackTrace();
	            }
	            catch(SQLException e) {
	            	e.printStackTrace();
	            }
	        }
		  return connection;
	  }
}