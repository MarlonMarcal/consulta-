/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.daosoft;

import br.com.dao.*;
import br.com.conection.Conexao;
import br.com.conection.ConexaoSoft;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author marlon
 */
public class GerarImpressaoSoft {

    public static void gerarRelatorioOrc(String numOrcamento) throws Exception {

        try {

           Map params = new HashMap();
            params.put("codigo", numOrcamento);

            JasperReport jas = (JasperReport) JRLoader.loadObjectFromFile("src/br/com/relatorios/PedidoSoft.jasper");
            JasperPrint jasprint = JasperFillManager.fillReport(jas, params, ConexaoSoft.getConnection());

            JasperViewer viewer = new JasperViewer(jasprint, false);

            viewer.setVisible(true);

        } catch (IOException | JRException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Imprimir: "+ex);
            System.out.println("Erro ao Imprimir: \n" + ex);
            throw ex;
        }

    }
}
