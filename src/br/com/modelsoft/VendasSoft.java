/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.modelsoft;

import java.sql.Timestamp;

/**
 *
 * @author marlo
 */
public class VendasSoft {

    private Integer condigo;
    private Timestamp data;
    private String cgc;
    private String nome;
    private String vendedor;
    private String status;
    private Double total;

    public VendasSoft(){
    }

    public VendasSoft(Integer condigo, Timestamp data, String cgc, String nome, String vendedor, String status, Double total) {
        this.condigo = condigo;
        this.data = data;
        this.cgc = cgc;
        this.nome = nome;
        this.vendedor = vendedor;
        this.status = status;
        this.total = total;
    }

    public Integer getCondigo() {
        return condigo;
    }

    public void setCondigo(Integer condigo) {
        this.condigo = condigo;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public String getCgc() {
        return cgc;
    }

    public void setCgc(String cgc) {
        this.cgc = cgc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    
    

}
