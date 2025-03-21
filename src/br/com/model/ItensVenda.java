/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

/**
 *
 * @author marlon
 */
public class ItensVenda {

    private Integer item;
    private Integer codigo;
    private String codBarras;
    private String descricao;
    private String unidade;
    private Double valorund;
    private Double quantidade;
    private Double valortotal;

    public ItensVenda() {
    }

    public ItensVenda(Integer item, Integer codigo, String codBarras, String descricao, String unidade, Double valorund, Double quantidade, Double valortotal) {
        this.item = item;
        this.codigo = codigo;
        this.codBarras = codBarras;
        this.descricao = descricao;
        this.unidade = unidade;
        this.valorund = valorund;
        this.quantidade = quantidade;
        this.valortotal = valortotal;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Double getValorund() {
        return valorund;
    }

    public void setValorund(Double valorund) {
        this.valorund = valorund;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValortotal() {
        return valortotal;
    }

    public void setValortotal(Double valortotal) {
        this.valortotal = valortotal;
    }
    
    

}
