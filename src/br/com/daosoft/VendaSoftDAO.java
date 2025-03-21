/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.daosoft;

import br.com.conection.ConexaoSoft;
//import br.com.model.Nfe;
import br.com.modelsoft.ItensVendaSoft;
import br.com.modelsoft.NfeSoft;
import br.com.modelsoft.TipoPagSoft;
import br.com.modelsoft.VendaSoft;
import static br.com.view.TelaPeqVendaSoft.jtVenda;
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
public class VendaSoftDAO {

    //private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public List<ItensVendaSoft> readProd() throws IOException {

        con = ConexaoSoft.getConnection();
        stmt = null;
        rs = null;

        int setar = jtVenda.getSelectedRow();
        String id = "" + jtVenda.getValueAt(jtVenda.getSelectedRow(), 0);

        List<ItensVendaSoft> ivendas = new ArrayList<>();

        String sql = "select\n"
                + "    I.numitem as ITEM,\n"
                + "    i.codproduto as CODIGO,\n"
                + "    i.codbarras,\n"
                + "    i.descricao as DESCRICAO,\n"
                + "    p.codembalagem,\n"
                + "    i.quantidade,\n"
                + "    coalesce(sum(i.precotabela),0) as valor_und,\n"
                + "    cast(i.desconto as numeric(18,2)) as desconto,\n"
                + "    coalesce(sum(i.quantidade * i.preco),0) as valor_total,\n"
                + "    coalesce(sum(i.preco * o.totalpago / o.totalprodutos),0) as valor_final,\n"
                + "    coalesce(sum(i.quantidade * i.preco * o.totalpago / o.totalprodutos),0) as total_final\n"
                + "from itemsprod i\n"
                + "join orcamentos o on o.loja = i.loja and o.codorcamento = i.codorcamento\n"
                + "left join produtos p on p.codproduto = i.codproduto\n"
                + "\n"
                + "where i.loja = 2\n"
                + "and i.codorcamento = ?\n"
                + "\n"
                + "group by 1,2,3,4,5,6,8\n"
                + "\n"
                + "order by 1";
        try {
            
            System.out.println("SQL readProd" + sql);
            stmt = con.prepareStatement(sql);
            stmt.setString(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {

                ItensVendaSoft i = new ItensVendaSoft();

                i.setItem(rs.getInt("item"));
                i.setCodigo(rs.getInt("Codigo"));
                i.setCodBarras(rs.getString("codbarras"));
                i.setDescricao(rs.getString("Descricao"));
                i.setCodembalagem(rs.getString("codembalagem"));
                i.setQuantidade(rs.getDouble("quantidade"));
                i.setValorund(rs.getDouble("valor_und"));
                i.setDesconto(rs.getDouble("desconto"));
                i.setValortotal(rs.getDouble("valor_total"));
                i.setValorfinal(rs.getDouble("valor_final"));
                i.setTotalfinal(rs.getDouble("total_final"));

                ivendas.add(i);

            }

        } catch (SQLException ex) {
            Logger.getLogger(VendaSoftDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoSoft.closeConnection(con, stmt, rs);
        }
        return ivendas;
    }

    public void readvendas(VendaSoft objvendas) throws IOException {

        con = ConexaoSoft.getConnection();
        stmt = null;
        rs = null;

        int setar = jtVenda.getSelectedRow();
        String id = "" + jtVenda.getValueAt(jtVenda.getSelectedRow(), 0);
        String sql = "select\n"
                + "    o.codorcamento as codigo,\n"
                + "    o.datastatus as data,\n"
                + "    c.codigo as codcli,\n"
                + "    O.cgc,\n"
                + "    c.razaosocial as nome,\n"
                + "    o.operador as vendedor,\n"
                + "    s.descstatus as status,\n"
                + "    O.totalprodutos as subtotal,\n"
                + "    O.descontor,\n"
                + "    cast(O.DESCONTOP as numeric(18,2)) as descontop,\n"
                + "    O.frete,\n"
                + "    o.totalpago as total,\n"
                + "    O.loja\n"
                + "\n"
                + "from orcamentos O\n"
                + "left join clientes C on C.cgc = O.cgc\n"
                + "left join status s on s.status = o.status\n"
                + "where O.codorcamento = ?\n"
                + "and o.loja = 2\n"
                + "order by 2  ";

        try {
            
            
            System.out.println("SQL readVendas: "+sql+" Parametro: "+id);
            
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
                objvendas.setDescontor(rs.getDouble("descontor"));
                objvendas.setDescontop(rs.getDouble("descontop"));
                objvendas.setFrete(rs.getDouble("frete"));
                objvendas.setTotal(rs.getDouble("total"));
                objvendas.setLoja(rs.getInt("loja"));

            } else {
                JOptionPane.showMessageDialog(null, "Venda não Encontrada!");
            }
        } catch (SQLException e2) {
            JOptionPane.showMessageDialog(null, e2);
        } finally {
            ConexaoSoft.closeConnection(con, stmt, rs);
        }

    }
//public List<ItensVenda> readProd()

    public List<TipoPagSoft> readTipo() throws IOException {

        con = ConexaoSoft.getConnection();
        stmt = null;
        rs = null;

        List<TipoPagSoft> tipopag = new ArrayList<>();

        int setar = jtVenda.getSelectedRow();
        String id = "" + jtVenda.getValueAt(jtVenda.getSelectedRow(), 0);
        String sql = "select\n"
                + "\n"
                + "    r.tipo as CODIGO,\n"
                + "    t.descricao as NOME,\n"
                + "    sum(r.valorbruto) as VALOR\n"
                + "\n"
                + "from recebimentos r\n"
                + "\n"
                + "join tipopag t on t.codigo = r.tipo\n"
                + "\n"
                + "where 1=1\n"
                + "and r.codorcamento = ?\n"
                + "and r.loja = 2\n"
                + "\n"
                + "group by 1, 2  ";

        try {
            System.out.println("SQL ReadTipo: "+ sql);
            stmt = con.prepareStatement(sql);
            stmt.setString(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {

                TipoPagSoft t = new TipoPagSoft();

                t.setCodigo(rs.getInt("codigo"));
                t.setDescricao(rs.getString("nome"));
                t.setValor(rs.getDouble("valor"));

                tipopag.add(t);
            }
        } catch (SQLException e2) {
            JOptionPane.showMessageDialog(null, e2);
        } finally {
            ConexaoSoft.closeConnection(con, stmt, rs);
        }
        return tipopag;

    }

    public void readNfe(NfeSoft nfe) throws IOException {

        con = ConexaoSoft.getConnection();
        stmt = null;
        rs = null;

        int setar = jtVenda.getSelectedRow();
        String id = "" + jtVenda.getValueAt(jtVenda.getSelectedRow(), 0);
        String sql = "select\n"
                + " \n"
                + " n.dataautorizacao as data,\n"
                + " n.numeronota as Numero,\n"
                + " n.serienota as serie,\n"
                + " n.modelonota modelo,\n"
                + " coalesce( n.chave, '') as nfechave,\n"
                + " coalesce( n.protocolo, '') as protocolo,\n"
                + " n.valornota as valor,\n"
                + " coalesce( n.cfop, '') as cfop,\n"
                + " coalesce( n.obs, '') as obs\n"
                + " \n"
                + " from notafiscal n\n"
                + " where 1=1\n"
                + " and n.codorcamento = ?\n"
                + " and n.loja = 2\n"
                + " and n.cancelada not in ('T')";

        try {
            System.out.println("SQL readNFE: "+sql);
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
            ConexaoSoft.closeConnection(con, stmt, rs);
        }

    }

}
 