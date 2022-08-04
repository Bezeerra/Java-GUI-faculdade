package br.com.projectFinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connect {
    
	String nameDB;
	String nameUser;
	String senhaDB;
	
	
	
	
	public Connect(String nameDB, String nameUser, String senhaDB){
		this.nameDB = nameDB;
		this.nameUser = nameUser;
		this.senhaDB = senhaDB;
	}


	public void sendConnection(String QUERY) {
		try {    
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/"+ this.nameDB, this.nameUser, this.senhaDB);
	        int rsCliente = connect.createStatement().executeUpdate(QUERY);  //diferente quando se trata de fazer um select
	        //while(rsCliente.next()){
	        //    System.out.println("Nome: "+ rsCliente.getString("description"));
	        //}
	        System.out.println("SUCEFULLY" + rsCliente);
	    } catch (ClassNotFoundException ex) {
	        Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
	        System.out.println("ERRO DRIVER");
	    } catch (SQLException ex) {
	        Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
	        System.out.println("ERROR IN CONNECTION MYSQL");
	    };
	    
		}
}