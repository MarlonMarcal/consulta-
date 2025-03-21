/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.conection.Conexao;
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
public class GerarImpressao {

    public static void gerarRelatorioOrc(String numOrcamento) throws Exception {

        try {

           Map params = new HashMap();
            params.put("codigo", numOrcamento);

            JasperReport jas = (JasperReport) JRLoader.loadObjectFromFile("src/br/com/relatorios/Pedido.jasper");
            JasperPrint jasprint = JasperFillManager.fillReport(jas, params, Conexao.getConnection());

            JasperViewer viewer = new JasperViewer(jasprint, false);

            viewer.setVisible(true);

        } catch (IOException | JRException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Imprimir: "+ex);
            //System.out.println("ERRO METODO:" + ex);
            throw ex;
        }

    }
}
