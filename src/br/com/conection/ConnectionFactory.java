/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marlon
 */
public class ConnectionFactory {
    
    /*conexão usando JPA
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("meubancoBase");
    
    public static EntityManager getConnection(){
       return emf.createEntityManager(); 
    }*/
    
  
    
    //Conexão Usando JDBC
   
    //private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/base?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "";
    
    public static Connection getJdbc(){
        

        try {
            //Class.forName(DRIVER);            
            return DriverManager.getConnection(URL, USER, PASS);          
        } catch (SQLException ex) {
            throw new RuntimeException("Erro na conexão:",ex);
        }      
    } 
    
    public static void closeConnection(Connection con){                   
        try {
            if (con!=null){
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
          }
    }  
       
   public static void closeConnection(Connection con, PreparedStatement stmt){ 
       
       closeConnection(con);
        try {
           if(stmt !=null){
             stmt.close();  
           }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
          }
    }    
     
   public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){ 
       
       closeConnection(con, stmt);
        try {
           if(rs !=null){
             rs.close();  
           }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
          }
    } 
}
        

    
    
