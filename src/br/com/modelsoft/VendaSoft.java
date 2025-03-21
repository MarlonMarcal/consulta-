/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelsoft;


import java.sql.Timestamp;

/**
 *
 * @author marlon
 */
public class VendaSoft {
    
    private Integer condigo;
    private Timestamp data;
    private Integer codcli;
    private String cgc;
    private String nome;
    private String vendedor;
    private String status;
    private Double subtotal;
    private Double descontor;
    private Double descontop;
    private Double frete;
    private Double total;
    private Integer loja;

    public VendaSoft() {
    }

    public VendaSoft(Integer condigo, Timestamp data, Integer codcli, String cgc, String nome, String vendedor, String status, Double subtotal, Double descontor, Double descontop, Double frete, Double total, Integer loja) {
        this.condigo = condigo;
        this.data = data;
        this.codcli = codcli;
        this.cgc = cgc;
        this.nome = nome;
        this.vendedor = vendedor;
        this.status = status;
        this.subtotal = subtotal;
        this.descontor = descontor;
        this.descontop = descontop;
        this.frete = frete;
        this.total = total;
        this.loja = loja;
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

    public Integer getCodcli() {
        return codcli;
    }

    public void setCodcli(Integer codcli) {
        this.codcli = codcli;
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

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getDescontor() {
        return descontor;
    }

    public void setDescontor(Double descontor) {
        this.descontor = descontor;
    }

    public Double getDescontop() {
        return descontop;
    }

    public void setDescontop(Double descontop) {
        this.descontop = descontop;
    }

    public Double getFrete() {
        return frete;
    }

    public void setFrete(Double frete) {
        this.frete = frete;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getLoja() {
        return loja;
    }

    public void setLoja(Integer loja) {
        this.loja = loja;
    }
    
    
    
  
    
}
