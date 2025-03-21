/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.daosoft;


import br.com.conection.ConexaoSoft;
import br.com.modelsoft.VendasSoft;
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
public class PesquisaSoftDAO {

    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public List<VendasSoft> conVendas(String condicao) throws IOException {

        con = ConexaoSoft.getConnection();
        stmt = null;
        rs = null;

        List<VendasSoft> vendas = new ArrayList<>();

        String sql = 
                "select\n"
                + "\n"
                + "o.codorcamento as codigo,\n"
                + "o.datastatus as data,\n"
                + "o.cgc, \n"
                + "c.razaosocial as nome,\n"
                + "o.operador as vendedor,\n"
                + "s.descstatus as status,\n"
                + "o.totalpago\n"
                + "\n"
                + "\n"
                + "from orcamentos o\n"
                + "join clientes c on c.cgc = o.cgc\n"
                + "join status s on s.status = o.status\n"
                + "where 1=1 and " + condicao
                + " order by 2 ";
        try {
            System.out.println("SQL conVendas "+ sql);
            stmt = con.prepareStatement(sql);
            //stmt.setString(1, query);
            rs = stmt.executeQuery();

            while (rs.next()) {

                VendasSoft objvendas = new VendasSoft();

                objvendas.setCondigo(rs.getInt("codigo"));
                objvendas.setData(rs.getTimestamp("data"));
                objvendas.setCgc(rs.getString("cgc"));
                objvendas.setNome(rs.getString("nome"));
                objvendas.setVendedor(rs.getString("vendedor"));
                objvendas.setStatus(rs.getString("status"));
                objvendas.setTotal(rs.getDouble("totalpago"));
                // objvendas.setTipopag(rs.getString("descricaofiscal"));

                vendas.add(objvendas);

            }

        } catch (SQLException ex) {
            Logger.getLogger(VendaSoftDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoSoft.closeConnection(con, stmt, rs);
        }

        return vendas;
    }

}
