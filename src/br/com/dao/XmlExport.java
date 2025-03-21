/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dao;

import br.com.conection.Conexao;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;
import javax.swing.JOptionPane;

public class XmlExport {

    public void export(int id,int loja,String caminho) {

        
        String sql = "SELECT nfexml, nfechave FROM nf  WHERE id_oe = ? and emit_codloja = ?";

        try (Connection connection = Conexao.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

           // int id = 828815; // Altere o valor de acordo com o seu caso
           // int loja = 2;

            statement.setInt(1, id);
            statement.setInt(2, loja);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Blob blob = resultSet.getBlob("nfexml");
                   
                    byte[] xmlBytes = blob.getBytes(1, (int) blob.length());

                    // Altere o caminho de destino conforme necessário
                    String outputPath = caminho+".xml";
                    try (OutputStream outputStream = new FileOutputStream(outputPath)) {
                        outputStream.write(xmlBytes);
                    }

                    //System.out.println("Arquivo XML salvo com sucesso em: " + outputPath);
                    JOptionPane.showMessageDialog(null, "Arquivo XML salvo com sucesso em: " + outputPath);
                } else {
                    //System.out.println("Nenhum resultado encontrado para o ID fornecido.");
                    JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado para essa Venda.");
                }
            }
        } catch (SQLException | IOException e) {
            System.out.println("Erro" + e);
        }
        
        
    }

}
