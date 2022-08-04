package br.com.projectFinal;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bezerra
 */
public class Conexao {
    public static void main(String[] args) throws SQLException{
        Connection conect = null;
        try {    
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/chaledb", "root", "chale123");
            ResultSet rsCliente = connect.createStatement().executeQuery("\"INSERT INTO client_chale (nameClient, cpfClient, rgClient, endereco, numClient, cidade, estado, dataClient) VALUES (\"bezerra\", \"04601045884\", \"7746464\",\"PERTO DAQUI\", 12456, \"AQUI PERTO\", null , null)");
            while(rsCliente.next()){
                System.out.println("Nome: "+ rsCliente.getString("description"));
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO DRIVER");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR IN CONNECTION MYSQL");
        } finally {
            if(conect != null){
                conect.close();
            }
        }
        
    }
}