/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

import java.awt.Component;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Marlon
 */
public class decimalformat extends DefaultTableCellRenderer {

    NumberFormat nf = NumberFormat.getNumberInstance(new Locale(TOOL_TIP_TEXT_KEY));
    DecimalFormat df = new DecimalFormat("#.###");

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        
        super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
        
        if(o instanceof Double){
            
           this.setText(df.format((Double)o));
            
        }
        
        return this;
        
    }

}
