/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import java.sql.Timestamp;

/**
 *
 * @author marlon
 */
public class Vendas {
    
    private Integer condigo;
    private Timestamp data;
    private String cgc;
    private String nome;
    private String vendedor;
    private String status;
    private Double total;
    private String tipopag;

    public Vendas() {
    }

    public Vendas(Integer condigo, Timestamp data, String cgc, String nome, String vendedor, String status, Double total, String tipopag) {
        this.condigo = condigo;
        this.data = data;
        this.cgc = cgc;
        this.nome = nome;
        this.vendedor = vendedor;
        this.status = status;
        this.total = total;
        this.tipopag = tipopag;
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

    public String getTipopag() {
        return tipopag;
    }

    public void setTipopag(String tipopag) {
        this.tipopag = tipopag;
    }
  
    
    
}


