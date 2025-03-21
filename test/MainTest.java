
import br.com.util.Propries;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author marlo
 */
public class MainTest {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    
    public static void main(String[] args) throws IOException {

        Empresa e = new Empresa();
        e.setCodloja(1);
        e.setCgc("123456789");
        e.setRazaosocial("Empresa 1");

        System.out.println(e.toString());

    }


    }


