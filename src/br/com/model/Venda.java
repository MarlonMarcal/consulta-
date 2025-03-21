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
public class Venda {
    
    private Integer condigo;
    private Timestamp data;
    private Integer codcli;
    private String cgc;
    private String nome;
    private String vendedor;
    private String status;
    private Double subtotal;
    private Double desconto;
    private Double frete;
    private Double total;
    private String tipopag;
    private Integer loja;

    public String getTipopag() {
        return tipopag;
    }

    public void setTipopag(String tipopag) {
        this.tipopag = tipopag;
    }

    public Venda() {
    }

    public Venda(Integer condigo, Timestamp data, Integer codcli, String cgc, String nome, String status, Double subtotal, Double desconto, Double frete, Double total, Integer loja) {
        this.condigo = condigo;
        this.data = data;
        this.codcli = codcli;
        this.cgc = cgc;
        this.nome = nome;
        this.status = status;
        this.subtotal = subtotal;
        this.desconto = desconto;
        this.frete = frete;
        this.total = total;
        this.loja = loja;
    }
    
   

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
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

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
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
