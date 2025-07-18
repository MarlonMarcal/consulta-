/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

import java.awt.Component;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Marlon
 */
public class PrecoRender extends DefaultTableCellRenderer {

    NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        
        super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
        
        if(o instanceof Double){
            
           this.setText(nf.format((Double)o));
            
        }
        
        return this;
        
    }

}
