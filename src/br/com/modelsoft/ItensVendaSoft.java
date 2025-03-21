/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelsoft;

/**
 *
 * @author marlon
 */
public class ItensVendaSoft {

    private Integer item;
    private Integer codigo;
    private String codBarras;
    private String descricao;
    private String codembalagem;
    private Double quantidade;
    private Double valorund;
    private Double desconto;
    private Double valortotal;
    private Double valorfinal;
    private Double totalfinal;

    public ItensVendaSoft() {
    }

    public ItensVendaSoft(Integer item, Integer codigo, String codBarras, String descricao, String codembalagem, Double quantidade, Double valorund, Double desconto, Double valortotal, Double valorfinal, Double totalfinal) {
        this.item = item;
        this.codigo = codigo;
        this.codBarras = codBarras;
        this.descricao = descricao;
        this.codembalagem = codembalagem;
        this.quantidade = quantidade;
        this.valorund = valorund;
        this.desconto = desconto;
        this.valortotal = valortotal;
        this.valorfinal = valorfinal;
        this.totalfinal = totalfinal;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
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

    public String getCodembalagem() {
        return codembalagem;
    }

    public void setCodembalagem(String codembalagem) {
        this.codembalagem = codembalagem;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorund() {
        return valorund;
    }

    public void setValorund(Double valorund) {
        this.valorund = valorund;
    }

    public Double getValortotal() {
        return valortotal;
    }

    public void setValortotal(Double valortotal) {
        this.valortotal = valortotal;
    }

    public Double getValorfinal() {
        return valorfinal;
    }

    public void setValorfinal(Double valorfinal) {
        this.valorfinal = valorfinal;
    }

    public Double getTotalfinal() {
        return totalfinal;
    }

    public void setTotalfinal(Double totalfinal) {
        this.totalfinal = totalfinal;
    }
    
    

}
