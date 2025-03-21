
import br.com.conection.Conexao;
import br.com.conection.ConexaoSoft;
import static br.com.view.TelaPeqVenda.txtCli;
import static br.com.view.TelaPeqVenda.txtNvenda;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author marlo
 */
public class Test2 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        Connection con = ConexaoSoft.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        String sql = "select codloja, cgc, razaosocial from empresa ";
        
        try {
            
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
           while(rs.next()){
                
                System.out.println(rs.getInt("codloja"));
                System.out.println(rs.getString("cgc"));
                System.out.println(rs.getString("razaosocial"));
            }
            
        } catch (SQLException e) {
            System.out.println("Erro "+ e);
        }finally{
            ConexaoSoft.closeConnection(con, stmt, rs);
            
        }
        
        
        
    }

}
