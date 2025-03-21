/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author marlon
 */
public class PosicaoFormulario {
    
    
    public void abrirFormulario(JInternalFrame janela, JDesktopPane desktop){
        int lDesk = desktop.getWidth();
        int aDesk = desktop.getHeight();
        int lIFrama = janela.getWidth();
        int aIFrame = janela.getHeight();
        janela.setLocation(lDesk / 2 - lIFrama / 2, aDesk /2 - aIFrame /2);
        desktop.add(janela);
        janela.setVisible(true);
        
    }
    
    public void tamanhoFormulario(JInternalFrame janela, JDesktopPane desktop){
        int lDesk = desktop.getWidth();
        int aDesk = desktop.getHeight();
        int lIFrama = janela.getWidth();
        int aIFrame = janela.getHeight();
        janela.setSize(lDesk ,aDesk);
        desktop.add(janela);
        janela.setVisible(true);
        
    }
    
}
