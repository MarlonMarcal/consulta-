/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author marlo
 */
public class Empresa {
    
    private Integer codloja;
    private String cgc;
    private String razaosocial;

    /**
     * @return the codloja
     */
    public Integer getCodloja() {
        return codloja;
    }

    /**
     * @param codloja the codloja to set
     */
    public void setCodloja(Integer codloja) {
        this.codloja = codloja;
    }

    /**
     * @return the cgc
     */
    public String getCgc() {
        return cgc;
    }

    /**
     * @param cgc the cgc to set
     */
    public void setCgc(String cgc) {
        this.cgc = cgc;
    }

    /**
     * @return the razaosocial
     */
    public String getRazaosocial() {
        return razaosocial;
    }

    /**
     * @param razaosocial the razaosocial to set
     */
    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    @Override
    public String toString() {
        return "Empresa{" + "codloja=" + codloja + ", cgc=" + cgc + ", razaosocial=" + razaosocial + '}';
    }
    
    
     
    
    
}
