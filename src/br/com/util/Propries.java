/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author marlo
 */
public class Propries {

    public void setar(String key, String value, File file) throws FileNotFoundException, IOException {
        Properties prop = new Properties();

        try (InputStream in = new FileInputStream(file)) {
            if (in == null) {
                throw new FileNotFoundException();
            }
            prop.load(in);
            prop.setProperty(key, value);
            OutputStream out = new FileOutputStream(file);
            prop.save(out, "");
        } catch (Exception e) {
            e.getMessage();

        }

    }

    public String getProp(String key, File file) throws IOException {
        
        String valor = null;
        
        try (InputStream in = new FileInputStream(file)) {
            if (in == null) {
                throw new FileNotFoundException();
            }

            Properties prop = new Properties();
            prop.load(in);
            valor = prop.getProperty(key);

        } catch (IOException e) {
            e.getMessage();
        }
        return valor;

    }
}
