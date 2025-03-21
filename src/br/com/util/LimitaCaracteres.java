/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Marlon
 */
public class LimitaCaracteres extends PlainDocument {

    public enum TipoEntrada {
        NUMEROINTEIRO, NUMERODECIMAL, NOME, EMAIL, DATA;
    };

    private int qtdCaracteres;
    private TipoEntrada tpEntrada;
    
    
    /**
     * Permite definir o tipo de caractere a ser aceito em uma JTextfild
     * permite também definir o numero de caracteres aceito
     *
     * @param qtdCaracteres quantidade de caractere
     * @param tpEntrada tipo de caractere 
     * 
     * 
     * 
     */
    public LimitaCaracteres(int qtdCaracteres, TipoEntrada tpEntrada) {
        this.qtdCaracteres = qtdCaracteres;
        this.tpEntrada = tpEntrada;
    }
    
    @Override
    public void insertString(int i, String string, AttributeSet as) throws BadLocationException {

        if (string == null || getLength() == qtdCaracteres) {
            return;
        }
        int totalCarac = getLength() + string.length();
        // filtro de caracteres
        String regex = "";
        switch (tpEntrada) {
            case NUMEROINTEIRO:
                regex = "[^0-9]";
                break;
            case NUMERODECIMAL:
                regex = "[^0-9,]";
                break;
            case NOME:
                regex = "[^\\p{IsLatin}][^0-9]";
                break;
            case EMAIL:
                regex = "[^\\p{IsLatin}@.\\-_][^0-9]";
                break;
            case DATA:
                regex = "[^0-9/]";
                break;
        }
        //fazendo a substituição dos caracteres não permitidos
        string = string.replaceAll(regex, "");
        
        if(totalCarac <= qtdCaracteres){
        super.insertString(i, string, as); //To change body of generated methods, choose Tools | Templates.
        }else{
           String nova = string.substring(0, qtdCaracteres);
           super.insertString(i, nova, as);
        }
    }

}
