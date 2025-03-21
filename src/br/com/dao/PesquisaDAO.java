/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.conection.Conexao;
import br.com.model.Vendas;
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
public class PesquisaDAO {

    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public List<Vendas> conVendas(String condicao) throws IOException {

        con = Conexao.getConnection();
        stmt = null;
        rs = null;

        List<Vendas> vendas = new ArrayList<>();

        String sql = "select\n"
                + "\n"
                //+ "distinct (e.entd) as descricaofiscal,\n"
                + "o.id_oe as codigo,\n"
                + "o.data,\n"
                + "c.cpf as cgc,\n"
                + "c.cli as nome,\n"
                + "\n"
                +"case when coalesce(o.dig,'' ) = '' then  upper(trim(substring(n.vendedor from 4 for 15)))\n"
                +"else upper(o.dig)  end as vendedor,\n"
                //+ " case when coalesce(o.dig,'' ) = '' then  upper(o.autor)\n"
                //+ "            else upper(o.dig) end as vendedor,\n"
                + "\n"
                + "\n"
                + " o.tipo AS status,\n"
                + "coalesce(o.total,0) + coalesce(o.frete,0) - coalesce(o.desconto,0)as total\n"
                + "\n"
                + "from oe o\n"
                + "\n"
                + "left join cli c on c.codcli = o.codcli\n"
                +"left join nf n on n.id_oe = o.id_oe\n"
                //+ "left join pgtos p on p.id_oe = o.id_oe\n"
                //+ "left join ent e on e.ent = p.ent\n"
                + "\n"
                + "where o.tipo not in ('A','T') and " + condicao + " \n"
                + "order by 2";
        try {

            stmt = con.prepareStatement(sql);
            //stmt.setString(1, query);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Vendas objvendas = new Vendas();

                objvendas.setCondigo(rs.getInt("codigo"));
                objvendas.setData(rs.getTimestamp("data"));
                objvendas.setCgc(rs.getString("cgc"));
                objvendas.setNome(rs.getString("nome"));
                objvendas.setVendedor(rs.getString("vendedor"));
                objvendas.setStatus(rs.getString("status"));
                objvendas.setTotal(rs.getDouble("total"));
               // objvendas.setTipopag(rs.getString("descricaofiscal"));

                vendas.add(objvendas);

            }

        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

        return vendas;
    }

}
