/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.daosoft;

import br.com.conection.ConexaoSoft;
import br.com.modelsoft.ClienteSoft;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marlon
 */
public class ClienteSoftDAO {

    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public List<ClienteSoft> conClientes(String condicao) throws IOException {

        con = ConexaoSoft.getConnection();
        stmt = null;
        rs = null;

        List<ClienteSoft> cliente = new ArrayList<>();

        String sql = "select\n"
                + "  c.codigo as codigo,\n"
                + "  c.cgc as cgc,\n"
                + "  c.razaosocial as nome,\n"
                + "  c.ddd||' '||c.fone as fone,\n"
                + "  c.cidade as cidade\n"
                + "\n"
                + " from\n"
                + " clientes c " + condicao;
        try {

            stmt = con.prepareStatement(sql);
            //stmt.setString(1, query);
            rs = stmt.executeQuery();

            while (rs.next()) {

                ClienteSoft c = new ClienteSoft();

                c.setCodigo(rs.getInt("codigo"));
                c.setCgc(rs.getString("cgc"));
                c.setNome(rs.getString("nome"));
                c.setFone(rs.getString("fone"));
                c.setCidade(rs.getString("cidade"));

                cliente.add(c);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteSoftDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoSoft.closeConnection(con, stmt, rs);
        }
        System.out.println(rs);

        return cliente;
    }

}
