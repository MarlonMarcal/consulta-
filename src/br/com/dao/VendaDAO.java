/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.conection.Conexao;
import br.com.model.ItensVenda;
import br.com.model.Nfe;
import br.com.model.TipoPag;
import br.com.model.Venda;
import static br.com.view.TelaPeqVenda.jtVenda;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author marlon
 */
public class VendaDAO {

    //private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public List<ItensVenda> readProd() throws IOException {

        con = Conexao.getConnection();
        stmt = null;
        rs = null;

        int setar = jtVenda.getSelectedRow();
        String id = "" + jtVenda.getValueAt(jtVenda.getSelectedRow(), 0);

        List<ItensVenda> ivendas = new ArrayList<>();

        String sql = " select\n"
                + "\n"
                + "I.id_item as Item,\n"
                + "p.cod as Codigo,\n"
                + "p.codind as CodBarras,\n"
                + "coalesce(P.produto,'') ||'   '|| coalesce(i.obs,'') as Descricao,\n"
                + "p.unid,\n"
                + "I.valor valorUnd,\n"
                + "I.quant,\n"
                + "I.valortotal\n"
                + "\n"
                + "FROM IOE I\n"
                + "LEFT JOIN PROD P ON I.cod = P.cod\n"
                + "LEFT JOIN oe o ON O.id_oe = I.id_oe\n"
                + "LEFT JOIN CLI C ON C.codcli = O.codcli\n"
                + "\n"
                + "WHERE I.id_oe = ?\n"
                + "\n"
                + "order by 1";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {

                ItensVenda i = new ItensVenda();

                i.setItem(rs.getInt("item"));
                i.setCodigo(rs.getInt("Codigo"));
                i.setCodBarras(rs.getString("CodBarras"));
                i.setDescricao(rs.getString("Descricao"));
                i.setUnidade(rs.getString("unid"));
                i.setValorund(rs.getDouble("ValorUnd"));
                i.setQuantidade(rs.getDouble("quant"));
                i.setValortotal(rs.getDouble("valortotal"));

                ivendas.add(i);

            }

        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return ivendas;
    }

    public void readvendas(Venda objvendas) throws IOException {

        con = Conexao.getConnection();
        stmt = null;
        rs = null;

        int setar = jtVenda.getSelectedRow();
        String id = "" + jtVenda.getValueAt(jtVenda.getSelectedRow(), 0);
        String sql = "  select\n"
                + "\n"
                + "  o.id_oe as codigo,\n"
                + "  case when coalesce(o.hora,'') = '' then o.data\n"
                + "  else o.hora end as data,\n"
                + "  o.codcli,\n"
                + "  c.cpf as cgc,\n"
                + "  c.cli as nome,\n"
                + "case when coalesce(o.dig,'' ) = '' then  upper(trim(substring(n.vendedor from 4 for 15)))\n"
                + "else upper(o.dig)  end as vendedor,\n"
                + "  o.tipo AS status,\n"
                + "\n"
                + " o.total as subtotal,\n"
                + " o.desconto,\n"
                + " o.frete,\n"
                + " coalesce(o.total,0) + coalesce(o.frete,0) - coalesce(o.desconto,0)as total,\n"
                + " e.entd as descricaofiscal,\n"
                + " o.loja\n"
                + "\n"
                + " from oe o\n"
                + " left join cli c on c.codcli = o.codcli\n"
                + " left join pgtos p on p.id_oe = o.id_oe\n"
                + " left join ent e on e.ent = p.ent\n"
                + " left join nf n on n.id_oe = o.id_oe\n"
                + "\n"
                + " where o.id_oe =?\n"
                + "order by 2";

        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {

                objvendas.setCondigo(rs.getInt("codigo"));
                objvendas.setData(rs.getTimestamp("data"));
                objvendas.setCodcli(rs.getInt("codcli"));
                objvendas.setCgc(rs.getString("cgc"));
                objvendas.setNome(rs.getString("nome"));
                objvendas.setVendedor(rs.getString("vendedor"));
                objvendas.setStatus(rs.getString("status"));
                objvendas.setSubtotal(rs.getDouble("subtotal"));
                objvendas.setDesconto(rs.getDouble("desconto"));
                objvendas.setFrete(rs.getDouble("frete"));
                objvendas.setTotal(rs.getDouble("total"));
                objvendas.setTipopag(rs.getString("descricaofiscal"));
                objvendas.setLoja(rs.getInt("loja"));

                
                
            } else {
                JOptionPane.showMessageDialog(null, "Venda não Encontrada!");
            }
        } catch (SQLException e2) {
            JOptionPane.showMessageDialog(null, e2);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

    }
//public List<ItensVenda> readProd()

    public List<TipoPag> readTipo() throws IOException {

        con = Conexao.getConnection();
        stmt = null;
        rs = null;

        List<TipoPag> tipopag = new ArrayList<>();

        int setar = jtVenda.getSelectedRow();
        String id = "" + jtVenda.getValueAt(jtVenda.getSelectedRow(), 0);
        String sql = "  select\n"
                + "\n"
                + "p.ent as codigo,\n"
                + "e.entd as nome,\n"
                + "sum(p.valor_pg) as valor\n"
                + "\n"
                + "from pgtos p\n"
                + "\n"
                + "left join ent e on e.ent = p.ent\n"
                + "\n"
                + "\n"
                + "where p.id_oe = ?\n"
                + "\n"
                + "group by 1,2";

        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {

                TipoPag t = new TipoPag();

                t.setCod(rs.getInt("codigo"));
                t.setNome(rs.getString("nome"));
                t.setValor(rs.getDouble("valor"));

                tipopag.add(t);
            }
        } catch (SQLException e2) {
            JOptionPane.showMessageDialog(null, e2);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return tipopag;

    }

    public void readNfe(Nfe nfe) throws IOException {

        con = Conexao.getConnection();
        stmt = null;
        rs = null;

        int setar = jtVenda.getSelectedRow();
        String id = "" + jtVenda.getValueAt(jtVenda.getSelectedRow(), 0);
        String sql = "select\n"
                + "\n"
                + "n.emis as data,\n"
                + "n.nf as Numero,\n"
                + "n.serie as serie,\n"
                + "case when n.nfetipo = 'C' then '65'\n"
                + "else '55' end as modelo,\n"
                + "coalesce( n.nfechave, '') as nfechave,\n"
                + "coalesce( n.recibodeentregadenfe, '') as protocolo,\n"
                + "n.valor as valor,\n"
                + "coalesce( n.cfop, '') as cfop,\n"
                + "coalesce( n.obs, '') as obs\n"
                + "\n"
                + "from nf n where n.id_oe = ? \n"
                + "and n.canc not in ('S')";

        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {

                nfe.setData(rs.getTimestamp("data"));
                nfe.setNumero(rs.getInt("Numero"));
                nfe.setSerie(rs.getInt("serie"));
                nfe.setModelo(rs.getString("modelo"));
                nfe.setChave(rs.getString("nfechave"));
                nfe.setProtocolo(rs.getString("protocolo"));
                nfe.setValor(rs.getDouble("valor"));
                nfe.setCfop(rs.getString("cfop"));
                nfe.setObs(rs.getString("obs"));

                //desabilitando funções
            } else {
                //JOptionPane.showMessageDialog(null, "não Encontrada!");
            }
        } catch (SQLException e2) {
            JOptionPane.showMessageDialog(null, e2);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

    }

}
