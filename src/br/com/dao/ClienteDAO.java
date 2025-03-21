/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.conection.Conexao;
import br.com.model.Cliente;
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
public class ClienteDAO {

    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public List<Cliente> conClientes (String condicao) throws IOException {

        con = Conexao.getConnection();
        stmt = null;
        rs = null;

        List<Cliente> cliente = new ArrayList<>();

        String sql = "select\n"
                + "   c.codcli as codigo,\n"
                + "   c.cpf as cgc,\n"
                + "   c.cli as nome,\n"
                + "   c.telr as fone,\n"
                + "   c.cidr as cidade\n"
                + "from\n"
                + "    cli c " + condicao;
        try {

            stmt = con.prepareStatement(sql);
            //stmt.setString(1, query);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Cliente c = new Cliente();

                c.setCodigo(rs.getInt("codigo"));
                c.setCgc(rs.getString("cgc"));
                c.setNome(rs.getString("nome"));
                c.setFone(rs.getString("fone"));
                c.setCidade(rs.getString("cidade"));


                cliente.add(c);

            }

        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        System.out.println(rs);

        return cliente;
    }

}
