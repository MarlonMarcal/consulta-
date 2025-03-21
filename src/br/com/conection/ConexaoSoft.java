/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.conection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexaoSoft {

    public static Connection getConnection() throws FileNotFoundException, IOException {

        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("./src/properties/confsoft.properties");  
        prop.load(file);

        Connection conn = null;
        try {
               
            String Charset = "?encoding=ISO8859_1";
            String driver = "org.firebirdsql.jdbc.FBDriver";
            Class.forName(driver);
            String caminho = prop.getProperty("banco.caminho");          //C:\Softsystem\Base\LUX\LUXTINTASSAMAMBAIA.FDB
            String host = prop.getProperty("banco.host");
            String porta = prop.getProperty("banco.porta");  //"3050";
            String url = "jdbc:firebirdsql:"+ host +"/" + porta + ":" + caminho + Charset;
            String user = prop.getProperty("banco.usuario");//"SYSDBA";
            String password = prop.getProperty("banco.senha");//"masterkey";
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro Conexão: " + e);
            System.out.println("erro" + e);

        }
        return conn;
    }

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {

        closeConnection(con);
        try {
            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);
        try {
            if (rs != null) {
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
